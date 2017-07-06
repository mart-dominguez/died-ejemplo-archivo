/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.persistencia.died;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author mdominguez
 */
public class GenericDaoJSON<T> {

    private String nombreArchivo;
    private String directorio;
    
    public GenericDaoJSON(String nombreArchivo){
        this.nombreArchivo = nombreArchivo;
    }
    
    private String getArchivo() {        
        if(directorio!=null){
            File f = new File(directorio);
            if( f.exists() && f.isDirectory()) return directorio+"/"+nombreArchivo;
        }
        Path currentRelativePath = Paths.get("");
        return currentRelativePath.toAbsolutePath().toString()+"/"+nombreArchivo;
    }

    public void guardar(List<T> t) {
        
        Gson gson = new Gson();

        try {
            FileWriter file = new FileWriter( getArchivo());
            file.write(gson.toJson(t));
            file.flush();
            file.close();
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public List<T> cargar(Type typeArgs) {
        Gson gson = new Gson();        
        List<T> models = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader( getArchivo()));
            models = gson.fromJson(br, typeArgs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return models;
    }

}
