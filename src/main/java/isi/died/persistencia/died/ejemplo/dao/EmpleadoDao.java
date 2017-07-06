/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.persistencia.died.ejemplo.dao;

import isi.died.persistencia.died.ejemplo.modelo.Empleado;
import isi.died.persistencia.died.GenericDaoJSON;
import java.util.List;

/**
 *
 * @author mdominguez
 */
public class EmpleadoDao {
    private GenericDaoJSON db;
    
    public EmpleadoDao(){
        db = new GenericDaoJSON("empleado.json");
    }
    
    public void guardarLista(List<Empleado> empleados){
        db.guardar(empleados);
    }

    public List<Empleado> cargarLista(){
        return db.cargar(new com.google.gson.reflect.TypeToken<List<Empleado>>(){}.getType());
    }

    
}
