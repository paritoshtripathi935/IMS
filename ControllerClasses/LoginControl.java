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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;  
import java.util.Objects;

public class LoginControl {

    @FXML
    public Button LoginButton;
    @FXML
    public PasswordField PassTF;
    @FXML
    public Label Stat;
    @FXML
    public Button RegButton;
    @FXML
    public TextField UserTf;

    @FXML
    public void LoginAction(ActionEvent evt){
        String username = UserTf.getText();
        String password = PassTF.getText();

        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","Fallout@4");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from logindetails");
            while(rs.next()){
                if(rs.getString("LoginID").equals(username) && rs.getString("Password").equals(password)) {
                    if(rs.getString("Admin").equals("Yes")) {
                        Parent AdminBoard = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/pageDesigns/Adminpanel.fxml")));
                        Scene AdminBoardScene = new Scene(AdminBoard);
                        Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
                        userStage.setScene(AdminBoardScene);
                        userStage.setTitle("Admin Dashboard!");
                        userStage.show();
                    }
                }
                if(rs.getString("LoginID").equals(username) && rs.getString("Password").equals(password)) {
                    if(rs.getString("Admin").equals("No")){
                        Parent userAdd = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/pageDesigns/UserAdd.fxml")));
                        Scene userAddScene = new Scene(userAdd);
                        Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
                        userStage.setScene(userAddScene);
                        userStage.setTitle("User Registration");
                        userStage.show();

                    }
                }
                else
                    Stat.setText("Access Denied!!");

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void RegisterAction(ActionEvent evt) throws Exception {
        Parent userAdd = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/pageDesigns/UserAdd.fxml")));
        Scene userAddScene = new Scene(userAdd);
        Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        userStage.setScene(userAddScene);
        userStage.show();
    }
}
