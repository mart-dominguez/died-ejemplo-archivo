/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.persistencia.died.ejemplo.modelo;

import isi.died.persistencia.died.*;

/**
 *
 * @author mdominguez
 */
public class Sueldos {
    private Integer id;
    private String codigo;
    private String detalle;
    private Double monto;

    public Sueldos() {
    }

    public Sueldos(Integer id, String dato1, String dato2, Double dato3) {
        this.id = id;
        this.codigo = dato1;
        this.detalle = dato2;
        this.monto = dato3;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
    
    
}
