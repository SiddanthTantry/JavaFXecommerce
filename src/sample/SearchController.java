package sample;

import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import sample.com.util.ConnectionConfig;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class SearchController implements Initializable {
    public String search;
    public String odate;
    public String ddate;
    public String pid1;
    public String q,q1;
    public int cost;
    public int cid;
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @FXML
    private JFXTextField pidTxt;
    @FXML
    private TableView<SearchDetails> SearchTable;
    @FXML
    private TableColumn<SearchDetails, String> pid;
    @FXML
    private TableColumn<SearchDetails, String> name;
    @FXML
    private TableColumn<SearchDetails, String> mrp;
    @FXML
    private TableColumn<SearchDetails, String> cat;
    private ObservableList<SearchDetails> data;
    @FXML
    private StackPane sp;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        search=BuyPageController.getSearch();
        String query="SELECT * FROM PRODUCT WHERE Pname LIKE '%"+search+"%'";
        if(search.equals("Find")){
            System.out.println("NULL");
            query="SELECT * FROM PRODUCT WHERE Pname LIKE '%"+search+"%'";
        }
        else if(search.equals("null")){
            query="SELECT * FROM PRODUCT";
        }
        try {
            Connection con = ConnectionConfig.getConnection();
            data = FXCollections.observableArrayList();
            Statement statement = con.createStatement();

            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                data.add(new SearchDetails(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));

            }
        }catch (Exception e){
            e.printStackTrace();

        }
        pid.setCellValueFactory(new PropertyValueFactory<>("pid"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        mrp.setCellValueFactory(new PropertyValueFactory<>("mrp"));
        cat.setCellValueFactory(new PropertyValueFactory<>("catagory"));

        SearchTable.setItems(null);
        SearchTable.setItems(data);
    }

    public void onClickBbtn(ActionEvent event) {

        Date currentDate = new Date();
        odate=dateFormat.format(currentDate);
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.YEAR, 0);
        c.add(Calendar.MONTH, 0);
        c.add(Calendar.DATE, 2);
        Date currentDatePlusOne = c.getTime();
        ddate=dateFormat.format(currentDatePlusOne);
        pid1=pidTxt.getText();
        cid=FPcontroller.getInt();
        q="SELECT MRP FROM PRODUCT WHERE PID = '"+pid1+"'";
        try {
            Connection con = ConnectionConfig.getConnection();
            Statement statement = con.createStatement();
            String q2="DROP TRIGGER trigger_name";
            statement.executeUpdate(q2);
            String q3="CREATE TRIGGER trigger_name AFTER INSERT ON ORDERS FOR EACH ROW BEGIN UPDATE PRODUCT SET Stock=Stock-1 WHERE PID='"+pid1+"'; END;";
            statement.executeUpdate(q3);
            ResultSet rs = statement.executeQuery(q);
            while (rs.next()) {
                cost=rs.getInt("MRP");

            }
            q1="INSERT INTO ORDERS VALUES(NULL,'"+odate+"','"+ddate+"','"+cost+"','"+pid1+"','"+cid+"')";
            statement.executeUpdate(q1);
            JFXDialogLayout content=new JFXDialogLayout();
            content.setHeading(new javafx.scene.text.Text("Success!!"));
            content.setBody(new javafx.scene.text.Text("Order Successfully Placed :)\n Please check OrderPage for more details"));
            JFXDialog dialog = new JFXDialog(sp,content,JFXDialog.DialogTransition.CENTER);
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
        catch(Exception e){
            System.out.println("Exception "+e);
        }
    }

    public void onClickBckBtn(ActionEvent event) throws IOException {
        Parent p1= FXMLLoader.load(getClass().getResource("BuyPage.fxml"));
        Scene ps1=new Scene(p1);
        Stage ap1=(Stage) ((Node) event.getSource()).getScene().getWindow();
        ap1.setScene(ps1);
        ap1.show();
    }
}
