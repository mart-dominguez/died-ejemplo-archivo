/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.persistencia.died.ejemplo.dao;

import com.google.gson.reflect.TypeToken;
import isi.died.persistencia.died.GenericDaoJSON;
import isi.died.persistencia.died.ejemplo.modelo.Empresa;
import java.util.List;

/**
 *
 * @author mdominguez
 */
public class EmpresaDao {
    private GenericDaoJSON db;
    
    public EmpresaDao(){
        db = new GenericDaoJSON("empresa.json");
    }
    
    public void guardar(List<Empresa> empresa){
        db.guardar(empresa);
    }

    public List<Empresa> cargar(){
        return db.cargar(new TypeToken<List<Empresa>>(){}.getType());
    }

    
}
