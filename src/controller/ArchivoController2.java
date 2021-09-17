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
import domain.Informe;
import domain.Archivo;
import domain.RowData;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    private ImageView imgLogo;

    @FXML
    private TextField txtIdArchivo;

    @FXML
    private JFXComboBox<String> txtInIdArchJco;

    @FXML
    private TextField txtnArchivo;

    @FXML
    private TextField txtIdInforme;
    @FXML
    private TextArea txtInAsunto;
//    @FXML
//    private TextField txtInAsunto;
    @FXML
    private TextArea txtInDocumento;
//    @FXML
//    private TextField txtInDocumento;

    @FXML
    private DatePicker txtInFechaJc;

    @FXML
    private DatePicker txtInFechRecepJc;

    @FXML
    private TextField txtInIdArch;

    @FXML
    private TextField txtInNfolios;

    @FXML
    private TextArea txtInRemitente;
    @FXML
    private TextArea txtInAreaDerivar;

//    @FXML
//    private TextField txtInRemitente;
//    @FXML
//    private TextField txtInAreaDerivar;
    @FXML
    private JFXButton btnRarchivo;

    @FXML
    private JFXButton btnRinforme;

    @FXML
    private JFXButton btnRinformeSinTomo;

    @FXML
    private JFXButton btnNfolio;

    @FXML
    private TableView<Informe> tableC;

    @FXML
    private TableColumn<Informe, String> cFecha;

    @FXML
    private TableColumn<Informe, String> cDocumento;

    @FXML
    private TableColumn<Informe, String> cAsunto;

    @FXML
    private TableColumn<Informe, String> cRemitente;

    @FXML
    private TableColumn<Informe, String> cAreaAderivar;

    @FXML
    private TableColumn<Informe, String> cFechaDrecepcion;

    @FXML
    private TableColumn<Informe, String> cNfolios;

    @FXML
    private TableColumn<Archivo, String> cNarchivador;

    //
    java.sql.ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;

    java.sql.ResultSet resultSetC = null;
    PreparedStatement preparedStatementC = null;
    private String combonombreArchivoSql;
    private ObservableList<Informe> listInforme;
    private ObservableList<Archivo> listArchivo;
    private ObservableList<RowData> listRowData;
    private int idGenerado;

    String validacionCampoVacio = "Campo vacio";
    String validacionLongitud = "Se requiere una longitud de 8";
    String validacionNumeros = "Ingresar solo numeros";
    String ingresoArchivoCorrecto = "Se registro correctamente el archivo";
    String ingresoInformeCorrecto = "Se registro correctamente el informe";
    String ingresoInformeSinTomoCorrecto = "Se registro correctamente el informe sin tomo";
    Boolean esCorrecto;

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
        validaAñadirArchivo(event);

        if (esCorrecto == false) {
            //validaAñadirArchivo(event);
        } else {
            //esCorrecto=true;

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

                infoBox(ingresoArchivoCorrecto, "info", null);

            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }

    public String ingresarNombreArchivo() {
        String nomArchivo = txtnArchivo.getText();

        return nomArchivo;
    }

    //
    @FXML

    private void añadirInformeSinIdArchivo(ActionEvent event) throws SQLException {
        int id = 0;
        int idGenerado;
        //validaAñadirIforme(event);

        // esCorrecto=true;
        try {
            ConnectionUtil connectionUtil = new ConnectionUtil();
            connection = (Connection) connectionUtil.getConnection();

            String sql = "INSERT INTO `tb_informe_sinidarchivo` (      `FECHA`, `DOCUMENTO`, `ASUNTO`, `REMITENTE`, `AREAADERIVAR`, `FECHADERECEPCCION`, `N°DEFOLIOS`, `idArchivo`) VALUES ("
                    + "'" + ingresaFecha() + "' "
                    + ",'" + ingresaDocumento() + "'"
                    + ",'" + ingresaAsunto() + "'"
                    + ",'" + ingresaRemitente() + "'"
                    + ",'" + ingresaAreaaderivar() + "'"
                    + ",'" + ingresaFechaderepccion() + "'"
                    + ",'" + ingresatNdefolios() + "'," + 0 + ")";

            preparedStatement = (PreparedStatement) connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                this.idGenerado = resultSet.getInt(1);
                System.out.println("ID Autogenerado:  " + this.idGenerado);

            }
            preparedStatement.executeUpdate();
            resultSet.close();

            preparedStatement.close();
            infoBox(ingresoInformeSinTomoCorrecto, "info", null);
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    @FXML

    private void añadirInforme(ActionEvent event) throws SQLException {
        int id = 0;
        int idGenerado;
        validaAñadirIforme(event);
        if (esCorrecto == false) {
            esCorrecto = false;

        } else {
            // esCorrecto=true;
            esCorrecto = false;
            try {
                ConnectionUtil connectionUtil = new ConnectionUtil();
                connection = (Connection) connectionUtil.getConnection();

                String sql = "INSERT INTO `tb_informe` (      `FECHA`, `DOCUMENTO`, `ASUNTO`, `REMITENTE`, `AREAADERIVAR`, `FECHADERECEPCCION`, `N°DEFOLIOS`,) VALUES ("
                        + "'" + ingresaFecha() + "' "
                        + ",'" + ingresaDocumento() + "'"
                        + ",'" + ingresaAsunto() + "'"
                        + ",'" + ingresaRemitente() + "'"
                        + ",'" + ingresaAreaaderivar() + "'"
                        + ",'" + ingresaFechaderepccion() + "'"
                        + ",'" + ingresatNdefolios() + "'"
                        + ",'" + idArchivo() + "')";

                preparedStatement = (PreparedStatement) connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    this.idGenerado = resultSet.getInt(1);
                    System.out.println("ID Autogenerado:  " + this.idGenerado);

                }
                preparedStatement.executeUpdate();
                resultSet.close();

                preparedStatement.close();
                infoBox(ingresoInformeCorrecto, "info", null);
            } catch (Exception e) {
                e.printStackTrace();

            }
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
    public void validaAñadirArchivo(ActionEvent event) {

        if (txtnArchivo.getText().trim().isEmpty()) {
            esCorrecto = false;
            infoBox(validacionCampoVacio, "info", null);

        } else {
            esCorrecto = true;
//              
        }

    }

    @FXML
    public void validaAñadirIforme(ActionEvent event) {
        String documento = txtInDocumento.getText().trim().toString();
        int longitudDocumento = documento.length();
        System.out.println("validar + logitud documento=" + longitudDocumento);
        LocalDate date = txtInFechaJc.getValue();
        LocalDate date1 = txtInFechRecepJc.getValue();
        if (txtInNfolios.getText().trim().isEmpty()
                || txtInAsunto.getText().trim().isEmpty()
                || txtInDocumento.getText().trim().isEmpty()
                || String.valueOf(date).equals("null")
                || String.valueOf(date1).equals("null")
                || filtro(txtInIdArchJco).isEmpty()
                || txtInRemitente.getText().trim().isEmpty()) {

            esCorrecto = false;
            infoBox(validacionCampoVacio, "info", null);
        } else {

            esCorrecto = true;
        }

    }

    public String ingresaFecha() {
        LocalDate date = txtInFechaJc.getValue();
        String fechaRecepcion = String.valueOf(date);
        System.out.println(fechaRecepcion);
        return fechaRecepcion;

    }

    public String ingresaDocumento() {
        String documento = txtInDocumento.getText();
        System.out.println("longitud=" + documento.length());

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
        System.out.println(fechaRecepcion);

        return fechaRecepcion;

    }

    public String ingresatNdefolios() {
        String ingresarNdearchivador = txtInNfolios.getText();

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

    public void obtenerArchivos() {
        try {
            ConnectionUtil connectionUtil = new ConnectionUtil();
            connection = (Connection) connectionUtil.getConnection();

            String sql = "SELECT nombreArchivo FROM `tb_archivo`";
            List<String> nombresArchivo = new ArrayList<>();
            resultSet = (java.sql.ResultSet) connection.createStatement().executeQuery(sql);
            while (resultSet.next()) {
                nombresArchivo.add(resultSet.getString("nombreArchivo"));

            }

            ObservableList<String> optionsNombreArchivo
                    = FXCollections.observableArrayList(
                            nombresArchivo
                    );
            iteracionRapidaDcomboBoxes(optionsNombreArchivo, txtInIdArchJco);

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public int idArchivo() throws Exception {
        int idBuscado = 0;
        combonombreArchivoSql = filtro(txtInIdArchJco);

        ConnectionUtil connectionUtil = new ConnectionUtil();
        connection = (Connection) connectionUtil.getConnection();

        String sql = "SELECT id FROM `tb_archivo` WHERE nombreArchivo=" + "'" + combonombreArchivoSql + "'";

        resultSet = (java.sql.ResultSet) connection.createStatement().executeQuery(sql);
        resultSet.next();
        idBuscado = resultSet.getInt("id");
        System.out.println("" + idBuscado);
        return idBuscado;

    }

    @FXML
    public void selecionarIdArchivo() {
        try {
            idArchivo();
        } catch (Exception e) {
        }

    }
    String SQLtabla = "SELECT inf.FECHA,inf.DOCUMENTO,inf.ASUNTO,inf.REMITENTE,inf.AREAADERIVAR,inf.FECHADERECEPCCION,inf.N°DEFOLIOS,ar.nombreArchivo FROM `tb_informe` inf JOIN tb_archivo ar on inf.idArchivo=ar.id";
    String SQLtabla1 = "SELECT inf.FECHA,inf.DOCUMENTO,inf.ASUNTO,inf.REMITENTE,inf.AREAADERIVAR,inf.FECHADERECEPCCION,inf.N°DEFOLIOS FROM `tb_informe` inf";

    public void popullateTable() {
        listInforme = FXCollections.observableArrayList();
        //listArchivo = FXCollections.observableArrayList();
        //listRowData= FXCollections.observableArrayList();
        ConnectionUtil connectionUtil = new ConnectionUtil();
        connection = (Connection) connectionUtil.getConnection();
        try {
            resultSet = (java.sql.ResultSet) connection.createStatement().executeQuery(SQLtabla);
            while (resultSet.next()) {
                Archivo archivo = new Archivo();
                Informe informe = new Informe();
                //RowData rowData = new RowData(archivo, informe);
                informe.setFecha(resultSet.getString("FECHA"));
                //informe.setFecha1();
                informe.setDocumento(resultSet.getString("DOCUMENTO"));
                informe.setAsunto(resultSet.getString("ASUNTO"));
                informe.setRemitente(resultSet.getString("REMITENTE"));
                informe.setAreaaderivar(resultSet.getString("AREAADERIVAR"));
                informe.setFechaderepccion(resultSet.getString("FECHADERECEPCCION"));
                informe.setNdeFolios(resultSet.getString("N°DEFOLIOS"));
                informe.setNombre(resultSet.getString("nombreArchivo"));
                // rowData.setArchivo(archivo);
                //rowData.setInforme(informe);
//                Ranking ranking = new Ranking();
//                ranking.setEntidades(resultSet.getString("Entidades"));
//                ranking.setNroMenciones(resultSet.getInt("NMenciones"));
                //ranking.setId(resultSet.getInt("id"));
//                listRanking.add(ranking);
//                cEntidades.setCellValueFactory(new PropertyValueFactory<>("entidades"));
//                cNMenciones.setCellValueFactory(new PropertyValueFactory<>("nroMenciones"));
                //  cId.setCellValueFactory(new PropertyValueFactory<>("id"));

                // System.out.println("N°DEFOLIOS:"+resultSet.getString("N°DEFOLIOS"));
                listInforme.add(informe);
                //listArchivo.add(archivo);
                  //listRowData.add(new RowData(rowData.getArchivo(),rowData.getInforme()));
                  
                 
                  
                // listArchivo.add(archivo.toString());
              // cFecha.setCellValueFactory(f ->f.getValue().getFecha1());
                cFecha.setCellValueFactory(new PropertyValueFactory<Informe, String>("fecha"));
                cDocumento.setCellValueFactory(new PropertyValueFactory<Informe, String>("documento"));
                cAsunto.setCellValueFactory(new PropertyValueFactory<Informe, String>("asunto"));
                cRemitente.setCellValueFactory(new PropertyValueFactory<Informe, String>("remitente"));
                cAreaAderivar.setCellValueFactory(new PropertyValueFactory<Informe, String>("areaaderivar"));
                cFechaDrecepcion.setCellValueFactory(new PropertyValueFactory<Informe, String>("fechaderepccion"));
                cNfolios.setCellValueFactory(new PropertyValueFactory<Informe, String>("ndeFolios"));
                cNarchivador.setCellValueFactory(new PropertyValueFactory<Archivo,String>("nombre"));
                 //cNarchivador.setCellValueFactory(f ->f.getValue().getNombre1());

                //tableC.setItems(null);
                //  System.out.println("columnas:"+tableC.getColumns());
                tableC.setItems(listInforme);
              
                tableC.setVisible(true);
          

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void colocarImagen() {

        URL linkLogo = getClass().getResource("/img/logo.png");
        Image imageLogo = new Image(linkLogo.toString(), 200, 96, false, true);

        imgLogo.setImage(imageLogo);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //colocarImagenBotones();
        obtenerArchivos();
        colocarImagen();
        popullateTable();
        //idArchivo();
    }

}
