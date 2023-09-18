package Client;

import javafx.application.Application;
import javafx.stage.Stage;

public class ChatClient extends Application {

    @Override
    public void start(Stage primaryStage) {
        ClientGUI gui = new ClientGUI(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
