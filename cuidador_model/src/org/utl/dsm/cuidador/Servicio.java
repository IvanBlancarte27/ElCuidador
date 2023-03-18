/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.cuidador;

/**
 *
 * @author daian
 */
public class Servicio {
    private int idServicio;
    private String nombre;
    private String descripcion;
    private double precioPorHora;

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioPorHora() {
        return precioPorHora;
    }

    public void setPrecioPorHora(double precioPorHora) {
        this.precioPorHora = precioPorHora;
    }

    public Servicio(int idServicio, String nombre, String descripcion, double precioPorHora) {
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioPorHora = precioPorHora;
    }

    public Servicio() {
    }

    @Override
    public String toString() {
        return "Servicio{" + "idServicio=" + idServicio + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precioPorHora=" + precioPorHora + '}';
    }
    
}
