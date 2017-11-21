package sample;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import sample.com.util.ConnectionConfig;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;

public class Controller implements Initializable {
    public static int a=0;
    public static String name;
    public  String pass;
    public static String getName(){
        return name;
    }

    @FXML
    private JFXTextField UsrText;
    @FXML
    private JFXPasswordField PasswdTxt;
    @FXML
    private StackPane stackPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    public void loadSecond1(ActionEvent event) throws IOException, SQLException {
        Connection con= ConnectionConfig.getConnection();
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM LOGIN");
        while (rs.next()) {
            String Name = rs.getString("USERNAME");
            String pwd = rs.getString("PASSWORD");
           // System.out.println(coffeeName + "\t" + supplierID);
           name=UsrText.getText();
           pass=PasswdTxt.getText();
           if((name.equals(Name))&&(pass.equals(pwd))){
               a++;
               break;
           }
        }

        if(a>0) {
            if(name.equals("admin")){
                Parent p = FXMLLoader.load(getClass().getResource("AdminPage.fxml"));
                Scene ps = new Scene(p);
                Stage ap = (Stage) ((Node) event.getSource()).getScene().getWindow();
                ap.setScene(ps);
                ap.show();

            }
            else {

                Parent p = FXMLLoader.load(getClass().getResource("FrontPage.fxml"));
                Scene ps = new Scene(p);
                Stage ap = (Stage) ((Node) event.getSource()).getScene().getWindow();
                ap.setScene(ps);
                ap.show();
            }
        }
        else {
            JFXDialogLayout content=new JFXDialogLayout();
            content.setHeading(new javafx.scene.text.Text("Error!!"));
            content.setBody(new javafx.scene.text.Text("Username or Password invalid"));
            JFXDialog dialog = new JFXDialog(stackPane,content,JFXDialog.DialogTransition.CENTER);
            JFXButton button = new JFXButton("Ok");
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                dialog.close();
                }
            });
            content.setActions(button);
            dialog.show();
       }
    }
}
