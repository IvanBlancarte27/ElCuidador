/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.cuidador;

/**
 *
 * @author daian
 */
public class Cuidador {
    private int idCuidador;
    private String telefonoEmergencia;
    private String numeroUnico;
    private String fotoINE;
    private String cartaRecomendacion;
    private String cartaAntecedentesPenales;
    private String comprobanteDomicilio;
    private Persona persona;
    private Usuario usuario;

    public int getIdCuidador() {
        return idCuidador;
    }

    public void setIdCuidador(int idCuidador) {
        this.idCuidador = idCuidador;
    }

    public String getTelefonoEmergencia() {
        return telefonoEmergencia;
    }

    public void setTelefonoEmergencia(String telefonoEmergencia) {
        this.telefonoEmergencia = telefonoEmergencia;
    }

    public String getNumeroUnico() {
        return numeroUnico;
    }

    public void setNumeroUnico(String numeroUnico) {
        this.numeroUnico = numeroUnico;
    }

    public String getFotoINE() {
        return fotoINE;
    }

    public void setFotoINE(String fotoINE) {
        this.fotoINE = fotoINE;
    }

    public String getCartaRecomendacion() {
        return cartaRecomendacion;
    }

    public void setCartaRecomendacion(String cartaRecomendacion) {
        this.cartaRecomendacion = cartaRecomendacion;
    }

    public String getCartaAntecedentesPenales() {
        return cartaAntecedentesPenales;
    }

    public void setCartaAntecedentesPenales(String cartaAntecedentesPenales) {
        this.cartaAntecedentesPenales = cartaAntecedentesPenales;
    }

    public String getComprobanteDomicilio() {
        return comprobanteDomicilio;
    }

    public void setComprobanteDomicilio(String comprobanteDomicilio) {
        this.comprobanteDomicilio = comprobanteDomicilio;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cuidador(int idCuidador, String telefonoEmergencia, String numeroUnico, String fotoINE, String cartaRecomendacion, String cartaAntecedentesPenales, String comprobanteDomicilio, Persona persona, Usuario usuario) {
        this.idCuidador = idCuidador;
        this.telefonoEmergencia = telefonoEmergencia;
        this.numeroUnico = numeroUnico;
        this.fotoINE = fotoINE;
        this.cartaRecomendacion = cartaRecomendacion;
        this.cartaAntecedentesPenales = cartaAntecedentesPenales;
        this.comprobanteDomicilio = comprobanteDomicilio;
        this.persona = persona;
        this.usuario = usuario;
    }

    public Cuidador() {
    }

    @Override
    public String toString() {
        return "Cuidador{" + "idCuidador=" + idCuidador + ", telefonoEmergencia=" + telefonoEmergencia + ", numeroUnico=" + numeroUnico + ", fotoINE=" + fotoINE + ", cartaRecomendacion=" + cartaRecomendacion + ", cartaAntecedentesPenales=" + cartaAntecedentesPenales + ", comprobanteDomicilio=" + comprobanteDomicilio + ", persona=" + persona + ", usuario=" + usuario + '}';
    }
    
    
}
