/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.cuidador.controller;

import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import org.utl.dsm.cuidador.AdultoMayor;
import org.utl.dsm.cuidador.Cuidador;
import org.utl.dsm.cuidador.FamiliarCargo;
import org.utl.dsm.cuidador.Medico;
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
        
        public AdultoMayor accederAdultoMayors(Usuario u) throws SQLException {

        String sql = "SELECT * FROM v_adultomayor WHERE nombreUsuario='" + u.getNombreUsuario() + "' AND contrasenia='" + u.getContrasenia() + "'";

        ConexionMySQL connMySQL = new ConexionMySQL();

        Connection conn = connMySQL.open();

        PreparedStatement pstmt = conn.prepareStatement(sql);

        ResultSet rs = pstmt.executeQuery();
        AdultoMayor lisA = null;

        while (rs.next()) {
            lisA = fill(rs);
        }
        rs.close();
        pstmt.close();
        connMySQL.close();
        return lisA;
    }

   
        
        public String buscar(Usuario u) throws SQLException {
        String qry = "SELECT*FROM usuario WHERE nombreUsuario = '" + u.getNombreUsuario() + "' and contrasenia = '" + u.getContrasenia() + "' ;";

        System.out.println(qry);

        ConexionMySQL conexionMySQL = new ConexionMySQL();

        Connection con = conexionMySQL.open();

        Statement stmnt = con.createStatement();

        ResultSet rs = stmnt.executeQuery(qry);

        String contrasenia = "";
        String nomUsuario = "";
        String rol = "";
        if (rs.next()) {
            contrasenia = rs.getString("contrasenia");
            nomUsuario = rs.getString("nombreUsuario");
            rol = rs.getString("rol");
            
            System.out.println(contrasenia +" "+ nomUsuario +" "+ rol);
        }

        String out = seleccionarVista(contrasenia, nomUsuario, rol);
        System.out.println(out);
        
        return out;
    }

    public String seleccionarVista(String con, String user, String rol) throws SQLException {

        String out = "";
        
        switch (rol) {
            case "Adulto Mayor":
                Gson gson = new Gson();
                Usuario u = new Usuario();
                u.setContrasenia(con);
                u.setNombreUsuario(user);

                AdultoMayor a = accederAdultoMayors(u);
                
                out = gson.toJson(a);
                break;
            case "Cuidador":
                Gson gson2 = new Gson();
                Usuario us = new Usuario();
                us.setContrasenia(con);
                us.setNombreUsuario(user);

                Cuidador c = accederCuidador(us);
                
                out = gson2.toJson(c);
                break;
        }
        
        return out;
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
        
        private AdultoMayor fill(ResultSet rs) throws SQLException {

        AdultoMayor a = new AdultoMayor();
        Persona persona = new Persona();

        persona.setSegundoApellido(rs.getString("segundoApellidoAdulto"));
        persona.setPrimerApellido(rs.getString("primerApellidoAdulto"));
        persona.setNombre(rs.getString("nombreAdulto"));
        persona.setGenero(rs.getString("generoAdulto"));

        a.setPersona(persona);

        a.setFotografia(rs.getString("fortografia"));
        a.setNumeroUnico(rs.getString("numeroUnico"));
        a.setFechaNacimiento(rs.getString("fechaNac"));
        a.setIdAdultoMayor(rs.getInt("idAdultoMayor"));

        //Forma de meter datos declarando el objeto dentro del empleado
        a.setUsuario(new Usuario());
        a.getUsuario().setContrasenia(rs.getString("contrasenia"));
        a.getUsuario().setIdUsuario(rs.getInt("idUsuario"));
        a.getUsuario().setNombreUsuario(rs.getString("nombreUsuario"));
        a.getUsuario().setRol(rs.getString("rol"));

        a.setMedico(new Medico());
        a.getMedico().setPersona(new Persona());
        a.getMedico().setNumeroTelefono(rs.getString("mumeroMedi"));
        a.getMedico().getPersona().setNombre(rs.getString("nombreMedico"));
        a.getMedico().getPersona().setPrimerApellido(rs.getString("primerApellidoMedico"));
        a.getMedico().getPersona().setSegundoApellido(rs.getString("segundoApellidoMedico"));
        a.getMedico().getPersona().setGenero(rs.getString("generoMedico"));
        a.getMedico().getPersona().setIdPersona(rs.getInt("idPersonaMedico"));
        a.getMedico().setIdMedico(rs.getInt("idMedico"));

        a.setFamiliarCargo(new FamiliarCargo());
        a.getFamiliarCargo().setPersona(new Persona());
        a.getFamiliarCargo().setNumeroTelefono(rs.getString("numTelefono"));
        a.getFamiliarCargo().getPersona().setNombre(rs.getString("nombreFami"));
        a.getFamiliarCargo().getPersona().setPrimerApellido(rs.getString("primerApeFami"));
        a.getFamiliarCargo().getPersona().setSegundoApellido(rs.getString("segundoApeFami"));
        a.getFamiliarCargo().getPersona().setGenero(rs.getString("generoFami"));
        a.getFamiliarCargo().getPersona().setIdPersona(rs.getInt("idPersonaFami"));
        a.getFamiliarCargo().setIdFamiliarCargo(rs.getInt("idFamiliarACargo"));

        return a;
    }
}
