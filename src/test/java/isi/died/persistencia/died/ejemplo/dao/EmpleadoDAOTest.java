/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.persistencia.died.ejemplo.dao;

import com.google.gson.reflect.TypeToken;
import isi.died.persistencia.died.GestorTest;
import isi.died.persistencia.died.ejemplo.modelo.Empleado;
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
import sun.security.pkcs11.Secmod;

/**
 *
 * @author mdominguez
 */
public class EmpleadoDAOTest {

    private List<Empleado> datos;
    private SimpleDateFormat sdf;
    private EmpleadoDao empleadoDAO;
    public EmpleadoDAOTest() {
    }

    @Before
    public void setUp() {
        empleadoDAO = new EmpleadoDao();
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

        } catch (ParseException ex) {
            Logger.getLogger(GestorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @After
    public void tearDown() {
    }


    /**
     * Test of cargarLista method, of class EmpleadoDao.
     */
    @Test
    public void testCargarLista() {
        try {
            empleadoDAO.guardarLista(this.datos);
            List<Empleado> testRes = empleadoDAO.cargarLista();
            System.out.println(testRes);
            assertEquals(10, testRes.size());
            assertEquals(sdf.parse("20/08/2017"), testRes.get(9).getFechaContratacion());
        } catch (ParseException ex) {
            Logger.getLogger(GestorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
