/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import javafx.beans.property.ObjectProperty;
import domain.Archivo;
import domain.Informe;
import javafx.beans.property.SimpleObjectProperty;


/**
 *
 * @author USER
 */
public class RowData {
    
    //private Archivo archivo;
     private final ObjectProperty<Archivo> archivo1 = new SimpleObjectProperty<>();
    //private Informe informe;
      private final ObjectProperty<Informe> informe1 = new SimpleObjectProperty<>();

    public RowData(Archivo archivo, Informe informe) {
       this.archivo1.set(archivo);
       this.informe1.set(informe);
    }
    
//    public void setArchivo(Archivo archivo){ return archivo; }
//    
//    public void setInforme(Informe informe){  return informe;}

    public Archivo getArchivo() {
        return archivo1.get();
    }

    public void setArchivo(Archivo archivo) {
        this.archivo1.set(archivo);
    }
//
    public Informe getInforme() {
        return informe1.get();
    }
//
    public void setInforme(Informe informe) {
        this.informe1.set(informe);
    }

    public ObjectProperty<Archivo> getArchivo1() {
        return archivo1;
    }

    public ObjectProperty<Informe> getInforme1() {
        return informe1;
    }
    
    
    
    
    
}
