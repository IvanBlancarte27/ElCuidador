package org.utl.dsm.cuidador;

/**
 *
 *      Nombre: Daiana Guadalupe Ulloa Mendoza
 *      Fecha : 12 de marzo del 2023
 * Descripcion: Creación de la clase AdultoMayor, clase que formara parte del modelaado de la Aplicacion
 */
public class AdultoMayor {
    
    //Declaracion de variables
    private int idAdultoMayor;
    private String numeroUnico;
    private String fotografia;
    private String fechaNacimiento;
    private FamiliarCargo familiarCargo;
    private Medico medico;
    private Persona persona;
    private Usuario usuario;

    public AdultoMayor() {
    }

    public AdultoMayor(String numeroUnico, String fotografia, String fechaNacimiento, FamiliarCargo familiarCargo, Medico medico, Persona persona, Usuario usuario) {
        this.numeroUnico = numeroUnico;
        this.fotografia = fotografia;
        this.fechaNacimiento = fechaNacimiento;
        this.familiarCargo = familiarCargo;
        this.medico = medico;
        this.persona = persona;
        this.usuario = usuario;
    }

    public AdultoMayor(int idAdultoMayor, String numeroUnico, String fotografia, String fechaNacimiento, FamiliarCargo familiarCargo, Medico medico, Persona persona, Usuario usuario) {
        this.idAdultoMayor = idAdultoMayor;
        this.numeroUnico = numeroUnico;
        this.fotografia = fotografia;
        this.fechaNacimiento = fechaNacimiento;
        this.familiarCargo = familiarCargo;
        this.medico = medico;
        this.persona = persona;
        this.usuario = usuario;
    }

    public int getIdAdultoMayor() {
        return idAdultoMayor;
    }

    public void setIdAdultoMayor(int idAdultoMayor) {
        this.idAdultoMayor = idAdultoMayor;
    }

    public String getNumeroUnico() {
        return numeroUnico;
    }

    public void setNumeroUnico(String numeroUnico) {
        this.numeroUnico = numeroUnico;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

    @Override
    public String toString() {
        return "AdultoMayor{" + "idAdultoMayor=" + idAdultoMayor + ", numeroUnico=" + numeroUnico + ", fotografia=" + fotografia + ", fechaNacimiento=" + fechaNacimiento + ", familiarCargo=" + familiarCargo.toString() + ", medico=" + medico.toString() + ", persona=" + persona.toString() + ", usuario=" + usuario.toString() + '}';
    }
    

    
    
}
