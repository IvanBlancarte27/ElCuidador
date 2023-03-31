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
    private String numeroTelefono;
    private Persona persona;

    public FamiliarCargo() {
    }

    public FamiliarCargo(int idFamiliarCargo, String numeroTelefono, Persona persona) {
        this.idFamiliarCargo = idFamiliarCargo;
        this.numeroTelefono = numeroTelefono;
        this.persona = persona;
    }

    public FamiliarCargo(String numeroTelefono, Persona persona) {
        this.numeroTelefono = numeroTelefono;
        this.persona = persona;
    }

    public int getIdFamiliarCargo() {
        return idFamiliarCargo;
    }

    public void setIdFamiliarCargo(int idFamiliarCargo) {
        this.idFamiliarCargo = idFamiliarCargo;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "FamiliarCargo{" + "idFamiliarCargo=" + idFamiliarCargo + ", numeroTelefono=" + numeroTelefono + ", persona=" + persona.toString() + '}';
    }
    
    
    

}
