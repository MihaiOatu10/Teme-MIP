package org.acme.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class ReservationClient {

    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 8888;

        System.out.println("--- CLIENT REZERVARI ---");
        System.out.println("Se incearca conectarea la " + serverAddress + ":" + port + "...");

        try (Socket socket = new Socket(serverAddress, port)) {

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Scanner consoleScanner = new Scanner(System.in);

            Thread listenerThread = new Thread(() -> {
                try {
                    String serverResponse;
                    while ((serverResponse = in.readLine()) != null) {
                        System.out.println("\n[SERVER]: " + serverResponse);
                        System.out.print("> ");
                    }
                } catch (IOException e) {
                    System.out.println("\nConexiunea cu serverul a fost intrerupta.");
                }
            });
            listenerThread.start();

            while (true) {
                String command = consoleScanner.nextLine();

                out.println(command);

                if ("EXIT".equalsIgnoreCase(command.trim())) {
                    System.out.println("Inchidere client...");
                    break;
                }
            }

        } catch (IOException e) {
            System.err.println("Eroare: Nu m-am putut conecta la server.");
            System.err.println("Verifica daca serverul Quarkus este pornit! (" + e.getMessage() + ")");
        }
    }
}