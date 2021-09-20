/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba3.MethodConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.Alert;

/**
 *
 * @author USER
 */
public class ConnectionUtil {
     public Connection connection;

    public Connection getConnection() {
        String jdbcDriver = "com.mysql.cj.jdbc.Driver";
        String serverUrl = "jdbc:mysql://localhost/?useUnicode=true&amp;amp;amp;useJDBCCompliantTimezoneShift=true&amp;amp;amp;useLegacyDatetimeCode=false&amp;amp;amp;serverTimezone=UTC";

        //String jdbcUrl = "jdbc:mysql://localhost/dataConsejo";
        String dbName = "archivoinforme";
        String userName = "root";
        String password = "";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        boolean dbFound = false;

       try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/archivoinforme", "root", "");
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("ConnectionUtil : "+ex.getMessage());
            infoBox("conecte la base datos o prenda el xampp, Apache y Mysql","error" , null);
         
        }

        return conn;
    }
    public static void infoBox(String infoMessage, String titleBar, String headerMessage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }
    public static void main(String[] args) {
        ConnectionUtil a = new ConnectionUtil();
        a.getConnection();

    }
}
