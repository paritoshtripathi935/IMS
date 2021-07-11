package ControllerClasses;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Objects;

public class AISController {
    @FXML
    public JFXButton incombtn;
    @FXML
    public JFXButton out;
    @FXML
    public JFXButton UMSbutton;
    @FXML
    public JFXButton Inv;
    @FXML
    public JFXButton Logact;
    @FXML
    public JFXButton Back;
    @FXML
    public JFXButton Sub;
    @FXML
    public Label Stat;
    @FXML
    private JFXButton Home;

    @FXML
    public void BackHome(ActionEvent evt) throws Exception {
        Parent userAdd = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/pageDesigns/AdminBoard.fxml")));
        Scene userAddScene = new Scene(userAdd);
        Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        userStage.setScene(userAddScene);
        userStage.show();
    }
    @FXML
    public void OutgoingOpenAction(ActionEvent evt) throws IOException {
        Parent AdminBoard = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/pageDesigns/Outgoing/Outgoing.fxml")));
        Scene AdminBoardScene = new Scene(AdminBoard);
        Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        userStage.setScene(AdminBoardScene);
        userStage.setTitle("Incoming");
        userStage.show();
    }
    @FXML
    public void IncomingOpenAction(ActionEvent evt) throws IOException {
        Parent AdminBoard = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/pageDesigns/Incoming/IncomingMenu.fxml")));
        Scene AdminBoardScene = new Scene(AdminBoard);
        Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        userStage.setScene(AdminBoardScene);
        userStage.setTitle("Incoming");
        userStage.show();
    }

    @FXML
    public void UMSOpenAction(ActionEvent evt) throws IOException {
        Parent AdminBoard = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/pageDesigns/UMS/UMS.fxml")));
        Scene AdminBoardScene = new Scene(AdminBoard);
        Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        userStage.setScene(AdminBoardScene);
        userStage.setTitle("User Management System");
        userStage.show();
    }
    public void LogoutAction(ActionEvent evt) throws IOException {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "Andy", "Andy#2002");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("delete from inventory.loginsession");
            Parent AdminBoard = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/pageDesigns/LoginDesign.fxml")));
            Scene AdminBoardScene = new Scene(AdminBoard);
            Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
            userStage.setScene(AdminBoardScene);
            userStage.setTitle("Login Page");
            userStage.show();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    public void AISOpenAction(ActionEvent evt) throws IOException {
        Stat.setText("Hello ");
    }
}
