package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BuyPageController implements Initializable {

    public static String search;
    public static String getSearch(){

        return search;
    }

    public JFXButton SearchBtn;
    public JFXTextField SearchField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void onClickSearchBtn(ActionEvent event) throws IOException {
        search=SearchField.getText();
        Parent p1= FXMLLoader.load(getClass().getResource("Search.fxml"));
        Scene ps1=new Scene(p1);
        Stage ap1=(Stage) ((Node) event.getSource()).getScene().getWindow();
        ap1.setScene(ps1);
        ap1.show();
    }

    public void onClickView(ActionEvent event) throws IOException {
        search="null";
        Parent p1= FXMLLoader.load(getClass().getResource("Search.fxml"));
        Scene ps1=new Scene(p1);
        Stage ap1=(Stage) ((Node) event.getSource()).getScene().getWindow();
        ap1.setScene(ps1);
        ap1.show();

    }

    public void onClickBckBtn(ActionEvent event) throws IOException {
        Parent p1= FXMLLoader.load(getClass().getResource("FrontPage.fxml"));
        Scene ps1=new Scene(p1);
        Stage ap1=(Stage) ((Node) event.getSource()).getScene().getWindow();
        ap1.setScene(ps1);
        ap1.show();
    }
}
