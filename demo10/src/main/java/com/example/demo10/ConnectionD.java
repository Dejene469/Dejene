package com.example.demo10;

import javafx.scene.control.Alert;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionD {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "Mars";
    private static final String PASSWORD = "9999";
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    Connection conn = null;
    Alert alert=new Alert(Alert.AlertType.INFORMATION);
    public Connection connMethod() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            if(conn!=null)
                alert.setContentText("connected");
            else
                alert.setContentText("not connected");
        } catch (ClassNotFoundException | SQLException e) {
            alert.setContentText(e.toString());
            e.printStackTrace();
        }

        return conn;
    }


}
