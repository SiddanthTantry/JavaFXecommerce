package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.com.util.ConnectionConfig;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class FPcontroller implements Initializable {
    public String user;
    public  static int cid;
    public static int getInt(){
        return cid;
    }

    public void onClickBuyBtn(ActionEvent event) throws IOException {
        Parent p1= FXMLLoader.load(getClass().getResource("BuyPage.fxml"));
        Scene ps1=new Scene(p1);
        Stage ap1=(Stage) ((Node) event.getSource()).getScene().getWindow();
        ap1.setScene(ps1);
        ap1.show();
    }

    public void onClickurOrders(ActionEvent event) throws SQLException, IOException {
        Parent p1= FXMLLoader.load(getClass().getResource("OrderPage.fxml"));
        Scene ps1=new Scene(p1);
        Stage ap1=(Stage) ((Node) event.getSource()).getScene().getWindow();
        ap1.setScene(ps1);
        ap1.show();

        }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            user = Controller.getName();
            Connection con = ConnectionConfig.getConnection();
            String q = "SELECT CID FROM CUSTOMER WHERE Username ='" + user + "'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(q);
            while (rs.next()) {
                cid=rs.getInt("CID");

            }
        }
        catch(Exception e){
            System.out.println("Exception "+e);
        }


    }

    public void onClickBckBtn(ActionEvent event) throws IOException {
        Parent p1= FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene ps1=new Scene(p1);
        Stage ap1=(Stage) ((Node) event.getSource()).getScene().getWindow();
        ap1.setScene(ps1);
        ap1.show();
    }
}

