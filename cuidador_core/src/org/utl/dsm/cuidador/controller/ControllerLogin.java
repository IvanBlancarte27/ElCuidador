/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.cuidador.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.utl.dsm.cuidador.Cuidador;
import org.utl.dsm.cuidador.Persona;
import org.utl.dsm.cuidador.Usuario;
import org.utl.dsm.db.ConexionMySQL;

/**
 *
 * @author ivandejesusblancarteaguayo
 */
public class ControllerLogin {
    
        public Cuidador accederCuidador(Usuario u) throws SQLException{
        String query= "SELECT * FROM v_cuidador WHERE nombreUsuario='"+u.getNombreUsuario()+"' AND contrasenia='"+u.getContrasenia()+"'";
        
        ConexionMySQL mySQL = new ConexionMySQL();
        Connection coon= mySQL.open();
        
        Statement stmn= coon.createStatement();
        ResultSet rs = stmn.executeQuery(query);
        
        Cuidador cuidador = null;
        
        if (rs.next()) {
            cuidador=fillCuidador(rs);
        }
        rs.close();
        stmn.close();
        coon.close();
        mySQL.close();
        
        return cuidador;
    }

        private Cuidador fillCuidador(ResultSet rs) throws SQLException {
        //Creamos un Objeto de Tipo empleado
        Persona persona = new Persona();
        Usuario usuario = new Usuario();
        Cuidador cuidador =  new Cuidador();

        persona.setIdPersona(rs.getInt("idPersona"));
        persona.setNombre(rs.getString("nombre"));
        persona.setPrimerApellido(rs.getString("primerApellido"));
        persona.setSegundoApellido(rs.getString("segundoApellido"));
        persona.setGenero(rs.getString("genero"));
        
        usuario.setIdUsuario(rs.getInt("idUsuario"));
        usuario.setNombreUsuario(rs.getString("nombreUsuario"));
        usuario.setContrasenia(rs.getString("contrasenia"));
        usuario.setRol(rs.getString("rol"));
        
        cuidador.setUsuario(usuario);
        cuidador.setPersona(persona);

        cuidador.setIdCuidador(rs.getInt("idCuidador"));
        cuidador.setNumeroUnico(rs.getString("numeroUnico"));
        cuidador.setFotografiaIne(rs.getString("fotoINE"));
        cuidador.setCartaRecomendacion(rs.getString("cartaRecomendacion"));
        cuidador.setCartaAntecedentesPenales(rs.getString("cartaAntecedentesPenales"));
        cuidador.setComprobanteDomicilio(rs.getString("comprobanteDomicilio"));
        cuidador.setRfc(rs.getString("rfc"));
        cuidador.setFechaNacimiento(rs.getString("fechaNac"));
        cuidador.setNumTelefonoMovil(rs.getString("telefonoMovil"));
        cuidador.setNumTelefonoCasa(rs.getString("telefonoCasa"));
        cuidador.setCorreo(rs.getString("correo"));
        cuidador.setFotografia(rs.getString("fortografia"));

        

        return cuidador;
    }
}
