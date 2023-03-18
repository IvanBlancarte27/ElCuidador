/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.cuidador;

/**
 *
 * @author daian
 */
public class AdultoMayor {
    private int idAdultoMayor;
    private String telefonoEmergencia;
    private String numeroUnico;
    private FamiliarCargo familiarCargo;
    private Medico medico;
    private Persona persona;
    private Usuario usuario;

    public int getIdAdultoMayor() {
        return idAdultoMayor;
    }

    public void setIdAdultoMayor(int idAdultoMayor) {
        this.idAdultoMayor = idAdultoMayor;
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

    public FamiliarCargo getFamiliarCargo() {
        return familiarCargo;
    }

    public void setFamiliarCargo(FamiliarCargo familiarCargo) {
        this.familiarCargo = familiarCargo;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
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

    public AdultoMayor(int idAdultoMayor, String telefonoEmergencia, String numeroUnico, FamiliarCargo familiarCargo, Medico medico, Persona persona, Usuario usuario) {
        this.idAdultoMayor = idAdultoMayor;
        this.telefonoEmergencia = telefonoEmergencia;
        this.numeroUnico = numeroUnico;
        this.familiarCargo = familiarCargo;
        this.medico = medico;
        this.persona = persona;
        this.usuario = usuario;
    }

    public AdultoMayor() {
    }

    @Override
    public String toString() {
        return "AdultoMayor{" + "idAdultoMayor=" + idAdultoMayor + ", telefonoEmergencia=" + telefonoEmergencia + ", numeroUnico=" + numeroUnico + ", familiarCargo=" + familiarCargo + ", medico=" + medico + ", persona=" + persona + ", usuario=" + usuario + '}';
    }
    
}
