package ControllerClasses;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.text.Position;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UserAddControl {
    @FXML
    public TextField Login;
    @FXML
    public TextField Phone;
    @FXML
    public TextField EmpNo;
    @FXML
    public TextField Fname;
    @FXML
    public TextField Lname;
    @FXML
    public JFXRadioButton YesRB;
    @FXML
    public ToggleGroup AdminSelection;
    @FXML
    public JFXRadioButton NoRB;
    @FXML
    public JFXButton regUser;
    @FXML
    public JFXButton ClearBtn;
    @FXML
    public JFXButton CancelBtn;
    @FXML
    public PasswordField Password;
    @FXML
    public PasswordField ConfPass;
    @FXML
    public TextField Position;
    @FXML
    public Label Status;


    @FXML
    public void switchAct(ActionEvent evt) throws IOException {
        Parent userAdd = FXMLLoader.load(getClass().getResource("../pageDesigns/UMS.fxml"));
        Scene userAddScene = new Scene(userAdd);
        Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        userStage.setScene(userAddScene);
        userStage.show();
    }

    @FXML
    public void registerAct(ActionEvent evt) {
        String Admin = "";
        String EmpN = EmpNo.getText();
        String first = Fname.getText();
        String last = Lname.getText();
        String username = Login.getText();
        String password = Password.getText();
        String confPass = ConfPass.getText();
        String posit = Position.getText();
        int phone = Integer.parseInt(Phone.getText());
        if(YesRB.isSelected())
            Admin="Yes";
        else if(NoRB.isSelected())
            Admin="No";
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "Fallout@4");
            Statement stmt = con.createStatement();
            if(password.equals(confPass)) {
                stmt.executeUpdate("Insert into userdata values('" + username + "','" + password + "','" + EmpN + "','" + first + "','" + last + "'," + posit + ",'" + phone + "')");
                stmt.executeUpdate("Insert into logindetails values('" + username + "','" + password + "','" + Admin + "')");
                Status.setTextFill(Color.GREEN);
                Status.setText("Record added!");
            }
            else
                Status.setTextFill(Color.RED);
                Status.setText("Passwords do not Match");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void clearAll(ActionEvent evt){
        EmpNo.setText("");
        Fname.setText("");
        Lname.setText("");
        Login.setText("");
        Password.setText("");
        Position.setText("");
        Phone.setText("");
        YesRB.setSelected(false);
        NoRB.setSelected(false);
    }
}
