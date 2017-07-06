/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.persistencia.died.ejemplo.dao;

import com.google.gson.reflect.TypeToken;
import isi.died.persistencia.died.GenericDaoJSON;
import isi.died.persistencia.died.ejemplo.modelo.Contratado;
import java.util.List;

/**
 *
 * @author mdominguez
 */
public class ContratadoDao {
    private GenericDaoJSON db;
    
    public ContratadoDao(){
        db = new GenericDaoJSON("empleado.json");
    }
    
    public void guardarLista(List<Contratado> contratado){
        db.guardar(contratado);
    }

    public List<Contratado> cargarLista(){
        return db.cargar(new TypeToken<List<Contratado>>(){}.getType());
    }

    
}
