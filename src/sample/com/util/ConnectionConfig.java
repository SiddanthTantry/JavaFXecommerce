package sample.com.util;

import sample.Controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfig {
    public static Connection getConnection(){
        Connection connection = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/dbmsproj_ECOMMERCE", "root", "asd");


        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;

    }

}
