package ControllerClasses;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

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
    public JFXButton Inv;
    @FXML
    public JFXButton log;
    @FXML
    public PieChart PieChar;
    @FXML
    private AnchorPane anchorRoot;
    @FXML
    private StackPane parentContainer;


    public void initialize() {
        loadChart();
        loadPieChart();
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
    public void InvOpenAction(ActionEvent evt) throws IOException {
        Parent AdminBoard = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/pageDesigns/Inventory/Inv.fxml")));
        Scene AdminBoardScene = new Scene(AdminBoard);
        Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        userStage.setScene(AdminBoardScene);
        userStage.setTitle("Inventory");
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
        lineChart.getData().clear();
        XYChart.Series<String,Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("Jan", 200));
        series.getData().add(new XYChart.Data<>("Feb", 100));
        series.getData().add(new XYChart.Data<>("March", 500));
        series.getData().add(new XYChart.Data<>("April", 400));
        lineChart.getData().add(series);
    }
    @FXML
    public void loadPieChart(javafx.event.ActionEvent event){
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("2019", 13),
                new PieChart.Data("2020", 25),
                new PieChart.Data("2021", 10),
                new PieChart.Data("2022", 22));
        PieChar.setData(pieChartData);
        PieChar.setClockwise(true);
        PieChar.setLabelLineLength(150);
        PieChar.setLabelsVisible(true);
        PieChar.setStartAngle(180);
    }
    @FXML
    public void loadChart(){
        lineChart.getData().clear();
        XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
        series.getData().add(new XYChart.Data<>("Jan", 200));
        series.getData().add(new XYChart.Data<>("Feb", 100));
        series.getData().add(new XYChart.Data<>("March", 500));
        series.getData().add(new XYChart.Data<>("April", 400));
        lineChart.getData().add(series);
    }
    @FXML
    public void loadPieChart(){
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("2019", 13),
                new PieChart.Data("2020", 25),
                new PieChart.Data("2021", 10),
                new PieChart.Data("2022", 22));
        PieChar.setData(pieChartData);
        PieChar.setClockwise(true);
        PieChar.setLabelLineLength(150);
        PieChar.setLabelsVisible(true);
        PieChar.setStartAngle(180);
    }
}
