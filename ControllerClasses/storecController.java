package ControllerClasses.Incoming;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class storecController {
    @FXML
    public JFXButton IncomBtn;
    @FXML
    public JFXButton OutgoingBtn;
    @FXML
    public JFXButton UMSbutton;
    @FXML
    public JFXButton LogoutBtn;
    @FXML
    public JFXButton searchBtn;
    @FXML
    public JFXButton Back;
    @FXML
    public JFXButton Home;
    @FXML
    public ComboBox MonthCB;
    @FXML
    public ComboBox YearCB;
    @FXML
    public TableView RecievedTable;
    @FXML
    public TableColumn Sno;
    @FXML
    public TableColumn Pcode;
    @FXML
    public TableColumn Name;
    @FXML
    public TableColumn Comp;
    @FXML
    public TableColumn Quant;
    @FXML
    public TableColumn Date;

    @FXML
    public void buildData(ActionEvent evt) throws ClassNotFoundException, SQLException {

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","Fallout@4");
        Statement stmt = con.createStatement();
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("select * from stockrecieved");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        ObservableList dbData = FXCollections.observableArrayList(dataBaseArrayList(rs));

        //Giving readable names to columns
        for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++) {
            TableColumn column = new TableColumn<>();
            switch (rs.getMetaData().getColumnName(i+1)) {
                case "id":
                    column.setText("ID #");
                    break;
                case "name":
                    column.setText("Person Name");
                    break;
                case "married":
                    column.setText("Marital Status");
                    break;
                default: column.setText(rs.getMetaData().getColumnName(i+1)); //if column name in SQL Database is not found, then TableView column receive SQL Database current column name (not readable)
                    break;
            }
            column.setCellValueFactory(new PropertyValueFactory<>(rs.getMetaData().getColumnName(i+1))); //Setting cell property value to correct variable from Person class.
            RecievedTable.getColumns().add(column);
        }

        //Filling up tableView with data
        RecievedTable.setItems(dbData);
    }

    public class StockRec {

        IntegerProperty SNo = new SimpleIntegerProperty(); //variable names should be exactly as column names in SQL Database Table. In case if you want to use <int> type instead of <IntegerProperty>, then you need to use getter/setter procedures instead of xxxProperty() below
        StringProperty ProdCode = new SimpleStringProperty();
        StringProperty Name = new SimpleStringProperty();
        StringProperty Company = new SimpleStringProperty();
        IntegerProperty Quantity = new SimpleIntegerProperty();
        StringProperty DateRecieved = new SimpleStringProperty();
        StringProperty Month = new SimpleStringProperty();
        IntegerProperty Year = new SimpleIntegerProperty();

        public IntegerProperty SNoProperty() { //name should be exactly like this [IntegerProperty variable name (id) + (Property) = idProperty] (case sensitive)
            return SNo;
        }
        public StringProperty ProdCodeProperty() {
            return ProdCode;
        }
        public StringProperty NameProperty() {
            return Name;
        }
        public StringProperty CompanyProperty() {
            return Company;
        }
        public IntegerProperty QuantityProperty() {
            return Quantity;
        }
        public StringProperty DateProperty() {
            return DateRecieved;
        }
        public StringProperty MonthProperty() {
            return Month;
        }
        public IntegerProperty YearProperty() {
            return Year;
        }

        public StockRec(int SNoValue, String ProdCodeValue, String NameValue, String CompanyValue, int QuantityValue, String DateValue,String MonthValue, int YearValue) {
            SNo.set(SNoValue);
            ProdCode.set(ProdCodeValue);
            Name.set(NameValue);
            Company.set(CompanyValue);
            Quantity.set(QuantityValue);
            DateRecieved.set(DateValue);
            Month.set(MonthValue);
            Year.set(YearValue);
        }

        StockRec(){}
    }

    private ArrayList dataBaseArrayList(ResultSet resultSet) throws SQLException {
        ArrayList<StockRec> data =  new ArrayList<>();
        while (resultSet.next()) {
            StockRec sr = new StockRec();
            sr.SNo.set(resultSet.getInt("SNo"));
            sr.ProdCode.set(resultSet.getString("ProdCode"));
            sr.Name.set(resultSet.getString("Name"));
            sr.Company.set(resultSet.getString("Company"));
            sr.Quantity.set(resultSet.getInt("Quantity"));
            sr.DateRecieved.set(resultSet.getString("DateRecieved"));
            sr.Month.set(resultSet.getString("Month"));
            sr.Year.set(resultSet.getInt("Year"));
            data.add(sr);

        }
        return data;
    }





    @FXML
    public void SearchRecords(ActionEvent evt){
        String Month = (MonthCB.getValue()).toString();
        String Year = (String) YearCB.getValue();
        String PrCode,PrName,Comp,Date;
        String Sno,Quantity;
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","Fallout@4");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from stockrecieved where Year ="+Year+" and Month ='"+Month+"'");
            while (rs.next()){
                Sno = rs.getString("SNo");
                PrCode = rs.getString("ProdCode");
                PrName = rs.getString("Name");
                Comp = rs.getString("Company");
                Quantity = rs.getString("Quantity");
                Date = rs.getString("DateRecieved");
                //data dd = new data(Sno,PrCode,PrName,Comp,Quantity,Date);
                //RecievedTable.getItems().add(dd);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

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
    public void BackOpenAction(ActionEvent evt) throws IOException {
        Parent AdminBoard = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/pageDesigns/Incoming/IncomingMenu.fxml")));
        Scene AdminBoardScene = new Scene(AdminBoard);
        Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        userStage.setScene(AdminBoardScene);
        userStage.setTitle("User Management System");
        userStage.show();
    }
}
