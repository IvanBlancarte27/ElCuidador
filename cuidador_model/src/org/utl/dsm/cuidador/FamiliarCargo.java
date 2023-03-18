/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.cuidador;

/**
 *
 * @author daian
 */
public class FamiliarCargo {
    private int idFamiliarCargo;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String telefono;

    public int getIdFamiliarCargo() {
        return idFamiliarCargo;
    }

    public void setIdFamiliarCargo(int idFamiliarCargo) {
        this.idFamiliarCargo = idFamiliarCargo;
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

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public FamiliarCargo(int idFamiliarCargo, String nombre, String apellidoPaterno, String apellidoMaterno, String telefono) {
        this.idFamiliarCargo = idFamiliarCargo;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
    }

    public FamiliarCargo() {
    }

    @Override
    public String toString() {
        return "familiarCargo{" + "idFamiliarCargo=" + idFamiliarCargo + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", telefono=" + telefono + '}';
    }
    
}
