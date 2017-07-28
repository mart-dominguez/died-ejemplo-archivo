/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.persistencia.died.ejemplo.modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author martdominguez
 */
public class Permanente extends Empleado{
    protected String baz;

    public Permanente(){
        super.type="permanente";
    }
    
    public Permanente(Integer id, String nombre, Double precio, Boolean flag, Date fecha,String baz) {
        super(id, nombre, precio, flag, fecha);
        super.type="permanente";
        this.baz = baz;
    }
    
    public String getBaz() {
        return baz;
    }

    public void setBaz(String baz) {
        this.baz = baz;
    }
    
    
}
