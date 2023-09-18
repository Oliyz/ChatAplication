package Client;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReceiver implements Runnable {

    private Socket socket;
    private TextArea textArea;

    public ClientReceiver(Socket socket, TextArea textArea) {
        this.socket = socket;
        this.textArea = textArea;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverInput;
            while ((serverInput = in.readLine()) != null) {
                final String message = serverInput;
                textArea.appendText(message + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
