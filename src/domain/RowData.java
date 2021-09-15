/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author USER
 */
public class RowData {
    
    private Archivo archivo;
    private Informe informe;

    public RowData(Archivo archivo, Informe informe) {
        this.archivo = archivo;
        this.informe = informe;
    }
    public Archivo getArchivo(){return archivo; }
    
    public Informe getInforme(){ return  informe;}
//    public void setArchivo(Archivo archivo){ archivo; }
//    
//    public void setInforme(Informe informe){  this.informe.set;}
}
