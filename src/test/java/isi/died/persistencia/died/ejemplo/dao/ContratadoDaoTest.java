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
public class ContratadoDaoTest {

    private List<Contratado> datosHijo;
    private List<Sueldos> datosDetalle;
    private SimpleDateFormat sdf;
    private ContratadoDao contratadoDAO;

    public ContratadoDaoTest() {
    }

    @Before
    public void setUp() {
        contratadoDAO = new ContratadoDao();
        try {
            sdf = new SimpleDateFormat("dd/MM/yyyy");
            datosDetalle = new ArrayList<>();
            datosDetalle.add(new Sueldos(200, "UUU", "Bnnn", 33.36));
            datosDetalle.add(new Sueldos(201, "NVA", "UNDFn", 534.23));
            datosDetalle.add(new Sueldos(202, "PCA", "GCFA", 11.68));
            datosDetalle.add(new Sueldos(203, "ARA", "COAE", 81.34));
            datosDetalle.add(new Sueldos(204, "ICY", "CYAF", 234.52));

            datosHijo = new ArrayList<>();
            datosHijo.add(new Contratado(100, "ABC", 55.55, false, sdf.parse("01/01/2017"), "XYZ", 345));
            datosHijo.add(new Contratado(101, "KICe", 4582.83, true, sdf.parse("01/03/2017"), "aFDe", 258));
            datosHijo.add(new Contratado(102, "PYXT", 2756.14, false, sdf.parse("11/10/2017"), "gdfg", 753));
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
     * Test of cargarLista method, of class ContratadoDao.
     */
    @Test
    public void testCargarLista() {
        contratadoDAO.guardarLista(datosHijo);
        List<Contratado> testRes = contratadoDAO.cargarLista();
        assertEquals(202, testRes.get(0).getLiquidaciones().get(2).getId().intValue());
    }

}
