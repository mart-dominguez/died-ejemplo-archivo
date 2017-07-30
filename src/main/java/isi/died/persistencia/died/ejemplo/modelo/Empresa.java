/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.persistencia.died.ejemplo.modelo;

import isi.died.persistencia.died.ejemplo.modelo.Empleado;
import java.util.List;

/**
 *
 * @author martdominguez
 */
public class Empresa {
    private String nombre;
    private List<Empleado> empleado;

    public Empresa() {
    }

    public Empresa(String nombre, List<Empleado> empleado) {
        this.nombre = nombre;
        this.empleado = empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empleado> getEmpleado() {
        return empleado;
    }

    public void setEmpleado(List<Empleado> empleado) {
        this.empleado = empleado;
    }
    
    
    
}
