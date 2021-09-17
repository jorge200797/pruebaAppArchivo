/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author USER
 */
public class Archivo {
     private final IntegerProperty id= new SimpleIntegerProperty();
     private StringProperty nombre=  new SimpleStringProperty();

       public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }
    
    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }
    
     
     
    public StringProperty getNombre1() {
        return nombre;
    }

    public void setNombre1(StringProperty nombre) {
        this.nombre = nombre;
    }

    
}
