/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.cuidador;

/**
 *
 * @author daian
 */
public class ServcioCuidador {
   private int idServicioCuidador;
   private Cuidador cuidador;
   private AdultoMayor adultomayor;
   private Usuario usuario;
   private Servicio servicio;

    

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

    public ServcioCuidador(int idServicioCuidador, Cuidador cuidador, AdultoMayor adultomayor, Usuario usuario, Servicio servicio) {
        this.idServicioCuidador = idServicioCuidador;
        this.cuidador = cuidador;
        this.adultomayor = adultomayor;
        this.usuario = usuario;
        this.servicio = servicio;
    }

    public ServcioCuidador() {
    }

    @Override
    public String toString() {
        return "ServcioCuidador{" + "idServicioCuidador=" + idServicioCuidador + ", cuidador=" + cuidador + ", adultomayor=" + adultomayor + ", usuario=" + usuario + ", servicio=" + servicio + '}';
    }

    public int getIdServicioCuidador() {
        return idServicioCuidador;
    }

    public void setIdServicioCuidador(int idServicioCuidador) {
        this.idServicioCuidador = idServicioCuidador;
    }
   
}
