/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import prueba3.MethodConnection.ConnectionUtil;

/**
 *
 * @author USER
 */
public class ArchivoController2 implements Initializable{
    
      private double xOffset = 0;
    private double yOffset = 0;
    
    
    //variables fx
    
    //
     java.sql.ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;

    java.sql.ResultSet resultSetC = null;
    PreparedStatement preparedStatementC = null;
    
    public ArchivoController2(){
    ConnectionUtil connectionUtil = new ConnectionUtil();
        connection = (Connection) connectionUtil.getConnection();
    
    
    }
    Connection connection;
    
   
       @Override
    public void initialize(URL url, ResourceBundle rb) {
        //colocarImagenBotones();

    }

   

}
