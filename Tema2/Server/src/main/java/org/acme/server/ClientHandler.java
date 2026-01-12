package org.acme.server;

import org.acme.service.ReservationService;
import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket socket;
    private ReservationService service;
    private String clientId;

    public ClientHandler(Socket socket, ReservationService service, String clientId) {
        this.socket = socket;
        this.service = service;
        this.clientId = clientId;
    }

    @Override
    public void run() {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            out.println("Bine ai venit! ID-ul tau este: " + clientId);
            out.println("Comenzi: LIST, RESERVE <ora>, MY, CANCEL <ora>, EXIT");

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                String[] parts = inputLine.split(" ");
                String command = parts[0].toUpperCase();
                String response = "";
                switch (command) {
                    case "LIST":
                        response = service.getAvailableSlots();
                        break;
                    case "RESERVE":
                        if (parts.length < 2) response = "Folosire: RESERVE <ora>";
                        else response = service.makeReservation(clientId, parts[1]);
                        break;
                    case "MY":
                        response = service.getMyReservations(clientId);
                        break;
                    case "CANCEL":
                        if (parts.length < 2) response = "Folosire: CANCEL <ora>";
                        else response = service.cancelReservation(clientId, parts[1]);
                        break;
                    case "EXIT":
                        out.println("La revedere!");
                        socket.close();
                        return;
                    default:
                        response = "Comanda necunoscuta.";
                }
                out.println(response);
            }
        } catch (IOException e) {
            System.out.println("Eroare client " + clientId + ": " + e.getMessage());
        }
    }
}