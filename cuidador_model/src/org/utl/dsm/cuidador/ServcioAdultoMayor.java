/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.cuidador;

/**
 *
 * @author daian
 */
public class ServcioAdultoMayor {
    private int idServicioAdultoMayor;
   private Cuidador cuidador;
   private AdultoMayor adultomayor;
   private Usuario usuario;
   private Servicio servicio;

    public ServcioAdultoMayor(int idServicioAdultoMayor, Cuidador cuidador, AdultoMayor adultomayor, Usuario usuario, Servicio servicio) {
        this.idServicioAdultoMayor = idServicioAdultoMayor;
        this.cuidador = cuidador;
        this.adultomayor = adultomayor;
        this.usuario = usuario;
        this.servicio = servicio;
    }

    public ServcioAdultoMayor() {
    }

    public int getIdServicioAdultoMayor() {
        return idServicioAdultoMayor;
    }

    public void setIdServicioAdultoMayor(int idServicioAdultoMayor) {
        this.idServicioAdultoMayor = idServicioAdultoMayor;
    }

    public Cuidador getCuidador() {
        return cuidador;
    }

    public void setCuidador(Cuidador cuidador) {
        this.cuidador = cuidador;
    }

    public AdultoMayor getAdultomayor() {
        return adultomayor;
    }

    public void setAdultomayor(AdultoMayor adultomayor) {
        this.adultomayor = adultomayor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    @Override
    public String toString() {
        return "ServcioAdultoMayor{" + "idServicioAdultoMayor=" + idServicioAdultoMayor + ", cuidador=" + cuidador + ", adultomayor=" + adultomayor + ", usuario=" + usuario + ", servicio=" + servicio + '}';
    }
   
}
