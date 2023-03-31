/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.cuidador;

/**
 *
 * @author daian
 */
public class Medico {
    private int idMedico;
    private String numeroTelefono;
    private Persona persona;

    public Medico() {
    }

    public Medico(String numeroTelefono, Persona persona) {
        this.numeroTelefono = numeroTelefono;
        this.persona = persona;
    }

    public Medico(int idMedico, String numeroTelefono, Persona persona) {
        this.idMedico = idMedico;
        this.numeroTelefono = numeroTelefono;
        this.persona = persona;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
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
        return "Medico{" + "idMedico=" + idMedico + ", numeroTelefono=" + numeroTelefono + ", persona=" + persona.toString() + '}';
    }
    
    
}
