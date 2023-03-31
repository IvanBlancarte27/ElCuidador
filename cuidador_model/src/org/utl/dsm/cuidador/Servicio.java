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
    private int idPaquete;
    private String nombre;
    private String descripcion;
    private double precioPorHora;

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idServicio) {
        this.idPaquete = idServicio;
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

    public Servicio(int idPaquete, String nombre, String descripcion, double precioPorHora) {
        this.idPaquete = idPaquete;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioPorHora = precioPorHora;
    }

    public Servicio() {
    }

    @Override
    public String toString() {
        return "Servicio{" + "idServicio=" + idPaquete + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precioPorHora=" + precioPorHora + '}';
    }
    
}
