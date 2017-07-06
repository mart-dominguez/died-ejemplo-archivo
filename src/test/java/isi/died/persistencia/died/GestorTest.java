/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.persistencia.died;

import isi.died.persistencia.died.ejemplo.modelo.Empleado;
import isi.died.persistencia.died.ejemplo.modelo.Contratado;
import isi.died.persistencia.died.ejemplo.modelo.Sueldos;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mdominguez
 */
public class GestorTest {

    private SimpleDateFormat sdf;
    
    private List<Empleado> datos;
    private List<Contratado> datosHijo;
    private List<Sueldos> datosDetalle;

    private GenericDaoJSON<Empleado> gestorPrueba;
    private GenericDaoJSON<Sueldos> gestorDetalle;
    private GenericDaoJSON<Contratado> gestorHijo;
    
    @Before
    public void setUp() {
        gestorPrueba = new GenericDaoJSON("prueba01.json");
        gestorDetalle = new GenericDaoJSON("detalle01.json");
        gestorHijo = new GenericDaoJSON("hijo01.json");
        try {
            sdf = new SimpleDateFormat("dd/MM/yyyy");
            datos = new ArrayList<>();
            datos.add(new Empleado(1, "risus hendrerit risus sollicitudin ", 99.99, true, sdf.parse("01/01/2017")));
            datos.add(new Empleado(2, "uctor nunc. Mauris consectetur p", 100.48, false, sdf.parse("04/01/2017")));
            datos.add(new Empleado(3, "Curabitur sit amet nisi nibh", 99.99, true, sdf.parse("11/03/2017")));
            datos.add(new Empleado(4, "nisl tellus sodales nibh, ", 99.99, true, sdf.parse("15/08/2017")));
            datos.add(new Empleado(5, "Maecenas hendrerit elit sit amet ex suscipi 1", 99.99, true, sdf.parse("31/01/2017")));
            datos.add(new Empleado(6, "Integer pulvinar diam in erat molestie blandit.1", 99.99, true, sdf.parse("01/08/2017")));
            datos.add(new Empleado(7, "Nam dui felis, ", 99.99, true, sdf.parse("01/01/2017")));
            datos.add(new Empleado(8, "consectetur nec velit", 99.99, true, sdf.parse("01/01/2017")));
            datos.add(new Empleado(9, "laoreet vel consequat sed", 99.99, true, sdf.parse("01/01/2017")));
            datos.add(new Empleado(10, "Vestibulum at tincidunt tortor, eu ultricies lectus", 99.99, true, sdf.parse("20/08/2017")));
            
            datosDetalle= new ArrayList<>();
            datosDetalle.add(new Sueldos(200, "UUU", "Bnnn", 33.36));
            datosDetalle.add(new Sueldos(201, "NVA", "UNDFn", 534.23));
            datosDetalle.add(new Sueldos(202, "PCA", "GCFA", 11.68));
            datosDetalle.add(new Sueldos(203, "ARA", "COAE", 81.34));
            datosDetalle.add(new Sueldos(204, "ICY", "CYAF", 234.52));
            
            datosHijo= new ArrayList<>();
            datosHijo.add(new Contratado(100,"ABC",55.55,false,sdf.parse("01/01/2017"),"XYZ",345));
            datosHijo.add(new Contratado(101,"KICe",4582.83,true,sdf.parse("01/03/2017"),"aFDe",258));
            datosHijo.add(new Contratado(102,"PYXT",2756.14,false,sdf.parse("11/10/2017"),"gdfg",753));
            datosHijo.get(0).addSueldo(datosDetalle.get(0));
            datosHijo.get(0).addSueldo(datosDetalle.get(1));
            datosHijo.get(0).addSueldo(datosDetalle.get(2));
            
            datosHijo.get(1).addSueldo(datosDetalle.get(2));
            datosHijo.get(1).addSueldo(datosDetalle.get(4));
            
            datosHijo.get(2).addSueldo(datosDetalle.get(3));
            datosHijo.get(2).addSueldo(datosDetalle.get(4));
            datosHijo.get(2).addSueldo(datosDetalle.get(0));
            
            
            
            
        } catch (ParseException ex) {
            Logger.getLogger(GestorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of guardar method, of class Gestor.
     */
    @Test
    public void testGuardarPrueba() {
        try {
            gestorPrueba.guardar(datos);
            List<Empleado> testRes = gestorPrueba.cargar(new TypeToken<List<Empleado>>(){}.getType());
            System.out.println(testRes);
            assertEquals(10, testRes.size());
            assertEquals(sdf.parse("20/08/2017"), testRes.get(9).getFechaContratacion());
        } catch (ParseException ex) {
            Logger.getLogger(GestorTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Test of cargar method, of class Gestor.
     */
    @Test
    public void testGuardarDetalle() {
        gestorDetalle.guardar(datosDetalle);
        List<Sueldos> testRes = gestorDetalle.cargar(new TypeToken<List<Sueldos>>(){}.getType());
        assertEquals(200, testRes.get(0).getId().intValue());
        assertEquals(201, testRes.get(1).getId().intValue());
        assertEquals(202, testRes.get(2).getId().intValue());
        assertEquals(203, testRes.get(3).getId().intValue());
        assertEquals(204, testRes.get(4).getId().intValue());        
    }
    
    @Test
    public void testGuardarHijo() {
        gestorHijo.guardar(datosHijo);
        List<Contratado> testRes = gestorHijo.cargar(new TypeToken<List<Contratado>>(){}.getType());
        assertEquals(202, testRes.get(0).getLiquidaciones().get(2).getId().intValue());
    }
}
