package ControllerClasses;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Objects;

public class Outgoing {
    @FXML
    public JFXButton CrUserBTN;
    @FXML
    public JFXButton ManageUserBTN;
    @FXML
    public JFXButton UMSbutton;

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
    public void ReportsOpenAction(ActionEvent evt) throws IOException {
        Parent AdminBoard = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/pageDesigns/Reports/Repo.fxml")));
        Scene AdminBoardScene = new Scene(AdminBoard);
        Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        userStage.setScene(AdminBoardScene);
        userStage.setTitle("Incoming");
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
    public void BackHome(ActionEvent evt) throws Exception {
        Parent userAdd = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/pageDesigns/AdminBoard.fxml")));
        Scene userAddScene = new Scene(userAdd);
        Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        userStage.setScene(userAddScene);
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
    @FXML
    public void InvOpenAction(ActionEvent evt) throws IOException {
        Parent AdminBoard = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/pageDesigns/Inventory/Inv.fxml")));
        Scene AdminBoardScene = new Scene(AdminBoard);
        Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        userStage.setScene(AdminBoardScene);
        userStage.setTitle("Inventory");
        userStage.show();
    }
    @FXML
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
}
