/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import prueba3.MethodConnection.ConnectionUtil;

/**
 *
 * @author USER
 */
public class ArchivoController2 implements Initializable{
    
      private double xOffset = 0;
    private double yOffset = 0;
    
    
    //variables fx
  
/*
    @FXML
    private TextField txtIdArchivo;

    @FXML
    private TextField txtnArchivo;

    @FXML
    private TextField txtIdInforme;

    @FXML
    private TextField txtInAsunto;

    @FXML
    private TextField txtInDocumento;

    @FXML
    private TextField txtInFecha;

    @FXML
    private TextField txtInFechRecep;

    @FXML
    private TextField txtInIdArch;

    @FXML
    private TextField txtInNArch;

    @FXML
    private TextField txtInRemitente;

    @FXML
    private TextField txtInAreaDerivar;

    @FXML
    private JFXButton btnRarchivo;

    @FXML
    private JFXButton btnRinforme;

    @FXML
    private JFXButton btnNfolio;
    
    */
    
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
