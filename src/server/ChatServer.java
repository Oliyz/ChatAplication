package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    private static final int SERVER_PORT = 12345;
    private ServerSocket serverSocket;

    public ChatServer() {
        try {
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server started on port " + SERVER_PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ChatServer();
    }
}
