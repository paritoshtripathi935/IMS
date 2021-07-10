package ControllerClasses;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class AdminPanelController {
    @FXML
    public JFXButton UMSbutton;
    @FXML
    public JFXButton IncomBtn;
    @FXML
    public JFXButton OutgoingBtn;


    @FXML
    public void UMSOpenAction(ActionEvent evt) throws IOException {
        Parent AdminBoard = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/pageDesigns/UMS.fxml")));
        Scene AdminBoardScene = new Scene(AdminBoard);
        Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        userStage.setScene(AdminBoardScene);
        userStage.setTitle("User Management System");
        userStage.show();
    }

    @FXML
    public void IncomingOpenAction(ActionEvent evt) throws IOException {
        Parent AdminBoard = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/pageDesigns/IncomingMenu.fxml")));
        Scene AdminBoardScene = new Scene(AdminBoard);
        Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        userStage.setScene(AdminBoardScene);
        userStage.setTitle("Incoming");
        userStage.show();
    }

}
