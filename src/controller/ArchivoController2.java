/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import org.controlsfx.control.spreadsheet.StringConverterWithFormat;
import prueba3.MethodConnection.ConnectionUtil;

/**
 *
 * @author USER
 */
public class ArchivoController2 implements Initializable {

    private double xOffset = 0;
    private double yOffset = 0;

    //variables fx
    @FXML
    private TextField txtIdArchivo;
    
    @FXML
    private JFXComboBox<String> txtInIdArchJco;

    @FXML
    private TextField txtnArchivo;

    @FXML
    private TextField txtIdInforme;

    @FXML
    private TextField txtInAsunto;

    @FXML
    private TextField txtInDocumento;

    @FXML
    private DatePicker txtInFechaJc;

    @FXML
    private DatePicker txtInFechRecepJc;

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

    //
    java.sql.ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;

    java.sql.ResultSet resultSetC = null;
    PreparedStatement preparedStatementC = null;
    private String combonombreArchivoSql;
    
    private int idGenerado;

    String validacionCampoVacio="Campo vacio";
     String validacionLongitud="Se requiere una longitud de 8";
       String validacionNumeros="Ingresar solo numeros";
    public ArchivoController2() {
        ConnectionUtil connectionUtil = new ConnectionUtil();
        connection = (Connection) connectionUtil.getConnection();

    }
    Connection connection;

    //
    @FXML

    private void añadirArchivo(ActionEvent event) throws SQLException {
        int id = 0;
        int idGenerado;

        try {
            ConnectionUtil connectionUtil = new ConnectionUtil();
            connection = (Connection) connectionUtil.getConnection();

            String sql = "INSERT INTO tb_archivo (nombreArchivo) VALUES " + "('" + ingresarNombreArchivo() + "')";
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                this.idGenerado = resultSet.getInt(1);
                System.out.println("ID Autogenerado:  " + this.idGenerado);

            }
            preparedStatement.executeUpdate();
            resultSet.close();

            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public String ingresarNombreArchivo() {
        String nomArchivo = txtnArchivo.getText();

        return nomArchivo;
    }

    //
  
    @FXML

    private void añadirInforme(ActionEvent event) throws SQLException {
        int id = 0;
        int idGenerado;

        try {
            ConnectionUtil connectionUtil = new ConnectionUtil();
            connection = (Connection) connectionUtil.getConnection();
              if(txtInNArch.getText().isEmpty()){
              
              }
            String sql = "INSERT INTO `tb_informe` (      `FECHA`, `DOCUMENTO`, `ASUNTO`, `REMITENTE`, `AREAADERIVAR`, `FECHADERECEPCCION`, `N°DEARCHIVADOR`, `idArchivo`) VALUES ("
                    + "'" + ingresaFecha() + "' "
                    + ",'" + ingresaDocumento() + "'"
                    + ",'" + ingresaAsunto() + "'"
                    + ",'" + ingresaRemitente() + "'"
                    + ",'" + ingresaAreaaderivar() + "'"
                    + ",'" + ingresaFechaderepccion() + "'"
                    + ",'" + ingresatNdearchivador() + "'"
                    + ",'" + idArchivo()+ "')";

            preparedStatement = (PreparedStatement) connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                this.idGenerado = resultSet.getInt(1);
                System.out.println("ID Autogenerado:  " + this.idGenerado);

            }
            preparedStatement.executeUpdate();
            resultSet.close();

            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();

        }

    }
    
      public static void infoBox(String infoMessage, String titleBar, String headerMessage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }
      @FXML
     public void validaAñadirArchivo(ActionEvent event){
         
             if(txtnArchivo.getText().trim().isEmpty()){
              infoBox(validacionCampoVacio, "info", null);
              }
             else{
                 try {
                     añadirArchivo(event);
                 } catch (Exception e) {
                 }
                 
             }
             
           
   
   }
       @FXML
     public void validaAñadirIforme(ActionEvent event){
         
             
             
             if(txtInNArch.getText().trim().isEmpty()){
              infoBox(validacionCampoVacio, "info", null);
              }
             else{
                 try {
                     añadirInforme(event);
                 } catch (Exception e) {
                 }
                 
             }
               if(txtInAsunto.getText().trim().isEmpty()){
              infoBox(validacionCampoVacio, "info", null);
              }
             else{
                 try {
                     añadirInforme(event);
                 } catch (Exception e) {
                 }
                 
             }
                 if(txtInDocumento.getText().trim().isEmpty()){
              infoBox(validacionCampoVacio, "info", null);
              }
             else{
                 try {
                     añadirInforme(event);
                 } catch (Exception e) {
                 }
                 
             }
                 
                   if( txtInDocumento.getText().length()==8 ){
              infoBox(validacionLongitud, "info", null);
              }
             else{
                 try {
                     añadirInforme(event);
                 } catch (Exception e) {
                 }
                 
             }
                   String documento=txtInDocumento.getText().trim().toString();
                   
                   if(!(Pattern.matches("[0-9]+",documento))){
              infoBox(validacionNumeros, "info", null);
              }
             else{
                 try {
                     añadirInforme(event);
                 } catch (Exception e) {
                 }
                 
             }
                 
                 
                 
                  LocalDate date = txtInFechaJc.getValue();
      if(String.valueOf(date).isEmpty()){
              infoBox(validacionCampoVacio, "info", null);
              }
             else{
                 try {
                     añadirInforme(event);
                 } catch (Exception e) {
                 }
                 
             }
      
              LocalDate date1 = txtInFechRecepJc.getValue();
      if(String.valueOf(date1).isEmpty()){
              infoBox(validacionCampoVacio, "info", null);
              }
             else{
                 try {
                     añadirInforme(event);
                 } catch (Exception e) {
                 }
                 
             }
    if(txtInAreaDerivar.getText().isEmpty()){
              infoBox(validacionCampoVacio, "info", null);
              }
             else{
                 try {
                     añadirInforme(event);
                 } catch (Exception e) {
                 }
                 
             }
    
    
      if( filtro(txtInIdArchJco).isEmpty()){
              infoBox(validacionCampoVacio, "info", null);
              }
             else{
                 try {
                     añadirInforme(event);
                 } catch (Exception e) {
                 }
                 
             }
  
   }
     

    public String ingresaFecha() {
        LocalDate date = txtInFechaJc.getValue();
        String fechaRecepcion = String.valueOf(date);

        return fechaRecepcion;

    }

    public String ingresaDocumento() {
        String documento = txtInDocumento.getText();

        return documento;
    }

    public String ingresaAsunto() {
        String asunto = txtInAsunto.getText();

        return asunto;
    }

    public String ingresaRemitente() {
        String remitente = txtInRemitente.getText();

        return remitente;
    }

    public String ingresaAreaaderivar() {
        String areaAderivar = txtInAreaDerivar.getText();

        return areaAderivar;
    }

    public String ingresaFechaderepccion() {

        LocalDate date = txtInFechRecepJc.getValue();
        String fechaRecepcion = String.valueOf(date);

        return fechaRecepcion;

    }

    public String ingresatNdearchivador() {
        String ingresarNdearchivador = txtInNArch.getText();

        return ingresarNdearchivador;
    }

    public int ingresaIdArchivo() {
        int ingresarIdArchivo = Integer.parseInt(txtInIdArch.getText());
        
        return ingresarIdArchivo;
    }
     public void iteracionRapidaDcomboBoxes(ObservableList<String> observableList, JFXComboBox<String> comboBoxString) {
        for (int i = 0; i < observableList.size(); i++) {
            comboBoxString.getItems().add(observableList.get(i));
        }

    }
     
       public String filtro(JFXComboBox<String> comboBoxString) {

        String resultado = comboBoxString.getSelectionModel().getSelectedItem();

        return resultado;
    }
    public void obtenerArchivos(){
    try {
            ConnectionUtil connectionUtil = new ConnectionUtil();
            connection = (Connection) connectionUtil.getConnection();

            String sql = "SELECT nombreArchivo FROM `tb_archivo`";
            List<String> nombresArchivo= new ArrayList<>();
               resultSet = (java.sql.ResultSet) connection.createStatement().executeQuery(sql);
              while (resultSet.next()) {
                 nombresArchivo.add(resultSet.getString("nombreArchivo"));
                     
                  
              }
            
                        
             ObservableList<String> optionsNombreArchivo
            = FXCollections.observableArrayList(
               nombresArchivo    
            );
                iteracionRapidaDcomboBoxes(optionsNombreArchivo,txtInIdArchJco);
           
        } catch (Exception e) {
            e.printStackTrace();

        }
    
    }
    
    public int  idArchivo() throws Exception{
         int idBuscado=0;
        combonombreArchivoSql=filtro(txtInIdArchJco);
     
            ConnectionUtil connectionUtil = new ConnectionUtil();
            connection = (Connection) connectionUtil.getConnection();
      
          
            String sql = "SELECT id FROM `tb_archivo` WHERE nombreArchivo="+"'"+combonombreArchivoSql+"'";
           
               resultSet = (java.sql.ResultSet) connection.createStatement().executeQuery(sql);
                  resultSet.next();
                  idBuscado=resultSet.getInt("id");
                   System.out.println(""+idBuscado);   
                  return  idBuscado;
                 
                
              
    
      
              
      
      
    }
    @FXML
    public void selecionarIdArchivo() {
         try {
            idArchivo(); 
        } catch (Exception e) {
        }
      
    }
 
 
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //colocarImagenBotones();
        obtenerArchivos();
        
            //idArchivo();
     

               
    }

}
