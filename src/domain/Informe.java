/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import impl.org.controlsfx.i18n.SimpleLocalizedStringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author USER
 */
public class Informe {

   

    private final IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty fecha = new SimpleStringProperty();
    private StringProperty documento = new SimpleStringProperty();
    private StringProperty asunto = new SimpleStringProperty();
    private StringProperty remitente = new SimpleStringProperty();
    private StringProperty areaaderivar = new SimpleStringProperty();
    private StringProperty fechaderepccion = new SimpleStringProperty();
    private StringProperty ndeFolios = new SimpleStringProperty();
     private final IntegerProperty idArchivo = new SimpleIntegerProperty();
      private StringProperty nombre=  new SimpleStringProperty();
     
// public Informe(String fecha) {
//     this.fecha=new SimpleLocalizedStringProperty(fecha); 
//     
//    }
 public Informe() {
     
     
    }

    public StringProperty getFecha1() {
        return fecha;
    }

    public void setFecha1(StringProperty fecha) {
        this.fecha = fecha;
    }

    public StringProperty getDocumento1() {
        return documento;
    }

    public void setDocumento1(StringProperty documento) {
        this.documento = documento;
    }

    public StringProperty getAsunto1() {
        return asunto;
    }

    public void setAsunto1(StringProperty asunto) {
        this.asunto = asunto;
    }

    public StringProperty getRemitente1() {
        return remitente;
    }

    public void setRemitente1(StringProperty remitente) {
        this.remitente = remitente;
    }

    public StringProperty getAreaaderivar1() {
        return areaaderivar;
    }

    public void setAreaaderivar1(StringProperty areaaderivar) {
        this.areaaderivar = areaaderivar;
    }

    public StringProperty getFechaderepccion1() {
        return fechaderepccion;
    }

    public void setFechaderepccion1(StringProperty fechaderepccion) {
        this.fechaderepccion = fechaderepccion;
    }

    public StringProperty getNdeFolios1() {
        return ndeFolios;
    }

    public void setNdeFolios1(StringProperty ndeFolios) {
        this.ndeFolios = ndeFolios;
    }
 
 
 
    public int getId() {
        return id.get();
    }



    public void setId(int id) {
        this.id.set(id);
    }

    public String getFecha() {
        return fecha.get();
    }
    
    
      public void setFecha(String fecha) {
        this.fecha.set(fecha);
    }
    
      public String getDocumento() {
        return documento.get();
    }
        public void setDocumento(String documento) {
        this.documento.set(documento);
    }
           public String getAsunto() {
        return asunto.get();
    }
           public void setAsunto(String asunto) {
        this.asunto.set(asunto);
    }
              public String getRemitente() {
        return remitente.get();
    }
 public void setRemitente(String remitente) {
        this.remitente.set(remitente);
    }
       public String getAreaaderivar() {
        return areaaderivar.get();
    }
       public void setAreaaderivar(String areaaderivar) {
        this.areaaderivar.set(areaaderivar);
    }
  public String getFechaderepccion() {
        return fechaderepccion.get();
    }
  public void setFechaderepccion(String fechaderepccion) {
        this.fechaderepccion.set(fechaderepccion);
    }

   public String getNdeFolios() {
        return ndeFolios.get();
    }
  public void setNdeFolios(String nDeFolios) {
        this.ndeFolios.set(nDeFolios);
    }
  
  
  public int getIdArchivo() {
        return idArchivo.get();
    }
  public void setIdArchivo(int idArchivo) {
        this.idArchivo.set(idArchivo);
 
}
 

 public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }
    


 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
}
