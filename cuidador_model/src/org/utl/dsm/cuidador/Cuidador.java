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
    private String numeroUnico;
    private String fotografiaIne;
    private String cartaRecomendacion;
    private String cartaAntecedentesPenales;
    private String comprobanteDomicilio;
    private String rfc;
    private String numTelefonoMovil;
    private String numTelefonoCasa;
    private String correo;
    private String fotografia;
    private Persona persona;
    private Usuario usuario;
    private String fechaNacimiento;

    public Cuidador() {
    }

    public Cuidador(String numeroUnico, String fotografiaIne, String cartaRecomendacion, String cartaAntecedentesPenales, String comprobanteDomicilio, String rfc, String numTelefonoMovil, String numTelefonoCasa, String correo, String fotografia, Persona persona, Usuario usuario, String fechaNacimiento) {
        this.numeroUnico = numeroUnico;
        this.fotografiaIne = fotografiaIne;
        this.cartaRecomendacion = cartaRecomendacion;
        this.cartaAntecedentesPenales = cartaAntecedentesPenales;
        this.comprobanteDomicilio = comprobanteDomicilio;
        this.rfc = rfc;
        this.numTelefonoMovil = numTelefonoMovil;
        this.numTelefonoCasa = numTelefonoCasa;
        this.correo = correo;
        this.fotografia = fotografia;
        this.persona = persona;
        this.usuario = usuario;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Cuidador(int idCuidador, String numeroUnico, String fotografiaIne, String cartaRecomendacion, String cartaAntecedentesPenales, String comprobanteDomicilio, String rfc, String numTelefonoMovil, String numTelefonoCasa, String correo, String fotografia, Persona persona, Usuario usuario, String fechaNacimiento) {
        this.idCuidador = idCuidador;
        this.numeroUnico = numeroUnico;
        this.fotografiaIne = fotografiaIne;
        this.cartaRecomendacion = cartaRecomendacion;
        this.cartaAntecedentesPenales = cartaAntecedentesPenales;
        this.comprobanteDomicilio = comprobanteDomicilio;
        this.rfc = rfc;
        this.numTelefonoMovil = numTelefonoMovil;
        this.numTelefonoCasa = numTelefonoCasa;
        this.correo = correo;
        this.fotografia = fotografia;
        this.persona = persona;
        this.usuario = usuario;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getIdCuidador() {
        return idCuidador;
    }

    public void setIdCuidador(int idCuidador) {
        this.idCuidador = idCuidador;
    }

    public String getNumeroUnico() {
        return numeroUnico;
    }

    public void setNumeroUnico(String numeroUnico) {
        this.numeroUnico = numeroUnico;
    }

    public String getFotografiaIne() {
        return fotografiaIne;
    }

    public void setFotografiaIne(String fotografiaIne) {
        this.fotografiaIne = fotografiaIne;
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

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNumTelefonoMovil() {
        return numTelefonoMovil;
    }

    public void setNumTelefonoMovil(String numTelefonoMovil) {
        this.numTelefonoMovil = numTelefonoMovil;
    }

    public String getNumTelefonoCasa() {
        return numTelefonoCasa;
    }

    public void setNumTelefonoCasa(String numTelefonoCasa) {
        this.numTelefonoCasa = numTelefonoCasa;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Cuidador{" + "idCuidador=" + idCuidador + ", numeroUnico=" + numeroUnico + ", fotografiaIne=" + fotografiaIne + ", cartaRecomendacion=" + cartaRecomendacion + ", cartaAntecedentesPenales=" + cartaAntecedentesPenales + ", comprobanteDomicilio=" + comprobanteDomicilio + ", rfc=" + rfc + ", numTelefonoMovil=" + numTelefonoMovil + ", numTelefonoCasa=" + numTelefonoCasa + ", correo=" + correo + ", fotografia=" + fotografia + ", persona=" + persona.toString() + ", usuario=" + usuario.toString() + ", fechaNacimiento=" + fechaNacimiento + '}';
    }

    
    
    
    
}
