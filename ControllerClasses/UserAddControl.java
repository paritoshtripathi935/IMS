package ControllerClasses;

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
import java.sql.Statement;

public class UserAddControl {
    @FXML
    public Button Switch;
    @FXML
    public TextField EnumTF;
    @FXML
    public TextField fnTF;
    @FXML
    public TextField lnTF;
    @FXML
    public TextField userTF;
    @FXML
    public TextField posTF;
    @FXML
    public TextField phoneTF;
    @FXML
    public PasswordField passTF;
    @FXML
    public Button RegButton;
    @FXML
    public Label Status;

    @FXML
    public void switchAct(ActionEvent evt) throws IOException {
        Parent userAdd = FXMLLoader.load(getClass().getResource("../pageDesigns/LoginDesign.fxml"));
        Scene userAddScene = new Scene(userAdd);
        Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        userStage.setScene(userAddScene);
        userStage.show();
    }

    @FXML
    public void registerAct(ActionEvent evt) {
        String EmpN = EnumTF.getText();
        String first = fnTF.getText();
        String last = lnTF.getText();
        String username = userTF.getText();
        String password = passTF.getText();
        String posit = posTF.getText();
        int phone = Integer.parseInt(phoneTF.getText());
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "Fallout@4");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("Insert into userdata values('"+EmpN+"','"+first+"','"+last+"','"+username+"','"+password+"',"+phone+",'"+posit+"')");
            stmt.executeUpdate("Insert into logindetails values('"+username+"','"+password+"';)");

        } catch (Exception e) {
            e.printStackTrace();
        }
        Status.setText("Record added!");

    }
}
