package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.com.util.ConnectionConfig;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.*;
import java.util.ResourceBundle;

public class OrderPageController implements Initializable{
    public String q;


    @FXML
    private TableView<OrderDetails> OrderTable;
    @FXML
    private TableColumn<OrderDetails, String> COid;
    @FXML
    private TableColumn<OrderDetails, String> COdate;
    @FXML
    private TableColumn<OrderDetails, String> CDdate;
    @FXML
    private TableColumn<OrderDetails, String> Ccost;
    @FXML
    private TableColumn<OrderDetails, String> Cpid;
    @FXML
    private TableColumn<OrderDetails, String> Ccid;
    private ObservableList<OrderDetails> data;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Connection con = ConnectionConfig.getConnection();
            int cid=FPcontroller.getInt();
            data = FXCollections.observableArrayList();
            String q="SELECT * FROM ORDERS WHERE CID='"+cid+"'";
            ResultSet rs = con.createStatement().executeQuery(q);
            while (rs.next()) {
                data.add(new OrderDetails(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        }
        catch (Exception e){
            System.out.println(e);

        }
        COid.setCellValueFactory(new PropertyValueFactory<>("id"));
        COdate.setCellValueFactory(new PropertyValueFactory<>("orderdate"));
        CDdate.setCellValueFactory(new PropertyValueFactory<>("deliverydate"));
        Ccost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        Cpid.setCellValueFactory(new PropertyValueFactory<>("pid"));
        Ccid.setCellValueFactory(new PropertyValueFactory<>("cid"));
        OrderTable.setItems(null);
        OrderTable.setItems(data);
    }

    public void onClickBckBtn(ActionEvent event) throws IOException {
        Parent p1= FXMLLoader.load(getClass().getResource("FrontPage.fxml"));
        Scene ps1=new Scene(p1);
        Stage ap1=(Stage) ((Node) event.getSource()).getScene().getWindow();
        ap1.setScene(ps1);
        ap1.show();
    }
}
