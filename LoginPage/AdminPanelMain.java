package LoginPage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class AdminPanelMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/pageDesigns/Adminpanel.fxml")));
        primaryStage.setTitle("Admin Dashboard");
        primaryStage.setScene(new Scene(root, 529, 406));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
