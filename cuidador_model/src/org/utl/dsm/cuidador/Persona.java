/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.cuidador;

/**
 *
 * @author daian
 */
public class Persona {
    private int idPersona;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoManterno;
    private String genero;
    private int edad;
    private String rfc;
    private String calle;
    private String colonia;
    private String numeroCasa;
    private String ciudad;
    private String pais;
    private int telefonoMovil;
    private int telefonoCasa;
    private String correo;
    private String fotoPersonal;

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoManterno() {
        return apellidoManterno;
    }

    public void setApellidoManterno(String apellidoManterno) {
        this.apellidoManterno = apellidoManterno;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(int telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public int getTelefonoCasa() {
        return telefonoCasa;
    }

    public void setTelefonoCasa(int telefonoCasa) {
        this.telefonoCasa = telefonoCasa;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFotoPersonal() {
        return fotoPersonal;
    }

    public void setFotoPersonal(String fotoPersonal) {
        this.fotoPersonal = fotoPersonal;
    }

    public Persona() {
    }

    public Persona(int idPersona, String nombre, String apellidoPaterno, String apellidoManterno, String genero, int edad, String rfc, String calle, String colonia, String numeroCasa, String ciudad, String pais, int telefonoMovil, int telefonoCasa, String correo, String fotoPersonal) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoManterno = apellidoManterno;
        this.genero = genero;
        this.edad = edad;
        this.rfc = rfc;
        this.calle = calle;
        this.colonia = colonia;
        this.numeroCasa = numeroCasa;
        this.ciudad = ciudad;
        this.pais = pais;
        this.telefonoMovil = telefonoMovil;
        this.telefonoCasa = telefonoCasa;
        this.correo = correo;
        this.fotoPersonal = fotoPersonal;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoManterno=" + apellidoManterno + ", genero=" + genero + ", edad=" + edad + ", rfc=" + rfc + ", calle=" + calle + ", colonia=" + colonia + ", numeroCasa=" + numeroCasa + ", ciudad=" + ciudad + ", pais=" + pais + ", telefonoMovil=" + telefonoMovil + ", telefonoCasa=" + telefonoCasa + ", correo=" + correo + ", fotoPersonal=" + fotoPersonal + '}';
    }
    
    
}
