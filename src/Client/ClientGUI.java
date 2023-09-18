package Client;

import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientGUI {

    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    private TextArea textArea;
    private TextField textField;
    private PrintWriter out;

    public ClientGUI(Stage stage) {
        textArea = new TextArea();
        textArea.setEditable(false);

        textField = new TextField();
        textField.setOnAction(event -> {
            sendMessage(textField.getText());
            textField.clear();
        });

        VBox layout = new VBox(10, textArea, textField);
        Scene scene = new Scene(layout, 400, 350);

        stage.setTitle("JavaFX Chat Client");
        stage.setScene(scene);
        stage.show();

        connectToServer();
    }

    private void connectToServer() {
        try {
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            out = new PrintWriter(socket.getOutputStream(), true);

            ClientReceiver receiver = new ClientReceiver(socket, textArea);
            new Thread(receiver).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(String message) {
        out.println(message);
    }
}
