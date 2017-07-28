/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.persistencia.died.ejemplo.modelo;

import isi.died.persistencia.died.*;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author mdominguez
 */
public abstract class Empleado {
    private Integer id;
    private String nombre;
    private Double costoHora;
    private Boolean esJefe;
    private Date fechaContratacion;
    protected String type;

    public Empleado() {
    }

    public Empleado(Integer id, String nombre, Double precio, Boolean flag, Date fecha) {
        this.id = id;
        this.nombre = nombre;
        this.costoHora = precio;
        this.esJefe = flag;
        this.fechaContratacion = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

     
    
    @Override
    public String toString() {
        return "DatosPrueba{" + "id=" + id + ", nombre=" + nombre + ", precio=" + costoHora + ", flag=" + esJefe + ", fecha=" + fechaContratacion + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCostoHora() {
        return costoHora;
    }

    public void setCostoHora(Double costoHora) {
        this.costoHora = costoHora;
    }

    public Boolean getEsJefe() {
        return esJefe;
    }

    public void setEsJefe(Boolean esJefe) {
        this.esJefe = esJefe;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }
    
    
    
}
