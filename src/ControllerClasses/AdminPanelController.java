package ControllerClasses;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.io.IOException;
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
        Parent AdminBoard = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/pageDesigns/UMS/UMS.fxml")));
        Scene AdminBoardScene = new Scene(AdminBoard);
        Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        userStage.setScene(AdminBoardScene);
        userStage.setTitle("User Management System");
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
    public void OutgoingOpenAction(ActionEvent evt) throws IOException {
        Parent AdminBoard = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/pageDesigns/Outgoing/Outgoing.fxml")));
        Scene AdminBoardScene = new Scene(AdminBoard);
        Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        userStage.setScene(AdminBoardScene);
        userStage.setTitle("Incoming");
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
    LineChart<String,Number> lineChart;
    public void loadChart(javafx.event.ActionEvent event){
        XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
        series.getData().add(new XYChart.Data<String,Number>("Jan",200));
        series.getData().add(new XYChart.Data<String,Number>("Feb",100));
        series.getData().add(new XYChart.Data<String,Number>("March",500));
        series.getData().add(new XYChart.Data<String,Number>("April",400));
        lineChart.getData().add(series);
    }
}
