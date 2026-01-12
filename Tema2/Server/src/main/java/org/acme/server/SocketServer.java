package org.acme.server;

import io.quarkus.runtime.Startup;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.service.ReservationService;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Startup
@ApplicationScoped
public class SocketServer {

    @Inject
    ReservationService service;

    private final ExecutorService threadPool = Executors.newCachedThreadPool();

    void onStart(@jakarta.enterprise.event.Observes io.quarkus.runtime.StartupEvent ev) {
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(8888)) {
                System.out.println("Serverul de rezervari a pornit pe portul 8888...");

                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    String clientId = "Client-" + UUID.randomUUID().toString().substring(0, 5);
                    System.out.println("Client nou conectat: " + clientId);
                    threadPool.execute(new ClientHandler(clientSocket, service, clientId));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}