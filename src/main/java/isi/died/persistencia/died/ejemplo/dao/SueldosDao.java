/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.persistencia.died.ejemplo.dao;

import com.google.gson.reflect.TypeToken;
import isi.died.persistencia.died.GenericDaoJSON;
import isi.died.persistencia.died.ejemplo.modelo.Sueldos;
import java.util.List;

/**
 *
 * @author mdominguez
 */
public class SueldosDao {
    private GenericDaoJSON db;
    
    public SueldosDao(){
        db = new GenericDaoJSON("sueldo.json");
    }
    
    public void guardarLista(List<Sueldos> sueldos){
        db.guardar(sueldos);
    }

    public List<Sueldos> cargarLista(){
        return db.cargar(new TypeToken<List<Sueldos>>(){}.getType());
    }
}
