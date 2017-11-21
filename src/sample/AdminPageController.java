package sample;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.com.util.ConnectionConfig;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AdminPageController implements Initializable {
    public JFXTextField pid;
    public JFXTextField name;
    public JFXTextField mrp;
    public JFXTextField cat;
    public JFXTextField stock;
    @FXML
    private TableView<AdminDetails> ptable;
    @FXML
    private TableColumn<AdminDetails, String> idc;
    @FXML
    private TableColumn<AdminDetails, String> namec;
    @FXML
    private TableColumn<AdminDetails, String> mrpc;
    @FXML
    private TableColumn<AdminDetails, String> catc;
    @FXML
    private TableColumn<AdminDetails, String> stockc;
    private ObservableList<AdminDetails> data;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showTable();
    }

    public void onClickInsertBtn(ActionEvent event) {
        String a,b,c,d,e;
        a=pid.getText();
        b=name.getText();
        c=mrp.getText();
        d=cat.getText();
        e=stock.getText();
        String q="INSERT INTO PRODUCT VALUES('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"')";
        try {
            Connection con = ConnectionConfig.getConnection();
            Statement s=con.createStatement();
            s.executeUpdate(q);

        }
        catch (Exception e1){
            System.out.println(e1);

        }
        showTable();

    }
    public void showTable(){
        try {
            Connection con = ConnectionConfig.getConnection();
            data = FXCollections.observableArrayList();
            ResultSet rs = con.createStatement().executeQuery("CALL ptable");
            while (rs.next()) {
                data.add(new AdminDetails(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        }
        catch (Exception e){
            System.out.println(e);

        }
        idc.setCellValueFactory(new PropertyValueFactory<>("pid"));
        namec.setCellValueFactory(new PropertyValueFactory<>("pname"));
        mrpc.setCellValueFactory(new PropertyValueFactory<>("mrp"));
        catc.setCellValueFactory(new PropertyValueFactory<>("cat"));
        stockc.setCellValueFactory(new PropertyValueFactory<>("stock"));
        ptable.setItems(null);
        ptable.setItems(data);
    }
    public void onClickDeleteBtn(ActionEvent event) {
        String a1=pid.getText();
        String q1="DELETE FROM PRODUCT WHERE PID='"+a1+"'" ;
        try {
            Connection con = ConnectionConfig.getConnection();
            Statement s=con.createStatement();
            s.executeUpdate(q1);

        }
        catch (Exception e1){
            System.out.println(e1);

        }
        showTable();

    }

    public void onClickUpadateBtn(ActionEvent event) {
        String e2=stock.getText();
        String a2=pid.getText();
        System.out.println(e2+"khvasjh "+a2);
        String q2="UPDATE PRODUCT SET Stock ='"+e2+"'WHERE PID='"+a2+"'";
        try {
            Connection con = ConnectionConfig.getConnection();
            Statement s=con.createStatement();
            s.executeUpdate(q2);

        }
        catch (Exception e1){
            System.out.println(e1);

        }
        showTable();
   }
}
