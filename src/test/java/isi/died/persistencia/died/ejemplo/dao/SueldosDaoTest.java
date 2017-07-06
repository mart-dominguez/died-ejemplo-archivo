/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.persistencia.died.ejemplo.dao;

import com.google.gson.reflect.TypeToken;
import isi.died.persistencia.died.GestorTest;
import isi.died.persistencia.died.ejemplo.modelo.Contratado;
import isi.died.persistencia.died.ejemplo.modelo.Sueldos;
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
public class SueldosDaoTest {

    private List<Sueldos> datosDetalle;
    private SimpleDateFormat sdf;
    private SueldosDao sueldosDAO;

    public SueldosDaoTest() {
    }

    @Before
    public void setUp() {
        sueldosDAO = new SueldosDao();
        datosDetalle = new ArrayList<>();
        datosDetalle.add(new Sueldos(200, "UUU", "Bnnn", 33.36));
        datosDetalle.add(new Sueldos(201, "NVA", "UNDFn", 534.23));
        datosDetalle.add(new Sueldos(202, "PCA", "GCFA", 11.68));
        datosDetalle.add(new Sueldos(203, "ARA", "COAE", 81.34));
        datosDetalle.add(new Sueldos(204, "ICY", "CYAF", 234.52));
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of guardarLista method, of class SueldosDao.
     */
    @Test
    public void testGuardarLista() {
    }

    /**
     * Test of cargarLista method, of class SueldosDao.
     */
    @Test
    public void testCargarLista() {
        sueldosDAO.guardarLista(datosDetalle);
        List<Sueldos> testRes = sueldosDAO.cargarLista();
        assertEquals(200, testRes.get(0).getId().intValue());
        assertEquals(201, testRes.get(1).getId().intValue());
        assertEquals(202, testRes.get(2).getId().intValue());
        assertEquals(203, testRes.get(3).getId().intValue());
        assertEquals(204, testRes.get(4).getId().intValue());        
    }

}
