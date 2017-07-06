/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.persistencia.died.ejemplo.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mdominguez
 */
public class Contratado extends Empleado{
    private String cbuCuentaBancaria;
    private Integer horasSemanales;
    private List<Sueldos> liquidaciones;

    public Contratado() {
        this.liquidaciones= new ArrayList<>();
    }

    public Contratado(Integer id, String nombre, Double precio, Boolean flag, Date fecha,String dato88, Integer dato99) {
        super(id, nombre, precio, flag, fecha);
        this.liquidaciones= new ArrayList<>();
        this.cbuCuentaBancaria = dato88;
        this.horasSemanales = dato99;
    }

    public String getCbuCuentaBancaria() {
        return cbuCuentaBancaria;
    }

    public void setCbuCuentaBancaria(String cbuCuentaBancaria) {
        this.cbuCuentaBancaria = cbuCuentaBancaria;
    }

    public Integer getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(Integer horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    public List<Sueldos> getLiquidaciones() {
        return liquidaciones;
    }

    public void setLiquidaciones(List<Sueldos> liquidaciones) {
        this.liquidaciones = liquidaciones;
    }
    
    public void addSueldo(Sueldos dato){
        this.liquidaciones.add(dato);
    }
    
}
