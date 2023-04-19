/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.cuidador.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import org.utl.dsm.cuidador.AdultoMayor;
import org.utl.dsm.db.ConexionMySQL;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import org.utl.dsm.cuidador.FamiliarCargo;
import org.utl.dsm.cuidador.Medico;
import org.utl.dsm.cuidador.Persona;
import org.utl.dsm.cuidador.Usuario;

/**
 *
 * @author ivandejesusblancarteaguayo
 */
public class ControllerAdultoMayor {

    public int insertAdultoMayor(AdultoMayor adultoMayor) throws SQLException {
        //1. Generar la consulta que vamos a enviar a la base de datos
        String query = "call insertAdultoMayor(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        //2. Preparamos las variables para recibir los valores de retorno
        int idPersonaOut = 0;
        int idPersonaFamOut = 0;
        int idPersonaMedOut = 0;
        int idUsuarioOut = 0;
        int idFamiliarOut = 0;
        int idMedicoOut = 0;
        int idAdultoMayorOut = 0;
        String numeroUnicoOut = "";

        //3. Conectarse a la base de Datos
        ConexionMySQL objConexionMySQL = new ConexionMySQL();
        Connection conn = objConexionMySQL.open();

        //4. Generar el objeto que va a invocar el Store Procedure
        CallableStatement cstmt = conn.prepareCall(query);

        //5.Asignar cada uno de los valores que se requiere
        cstmt.setString(1, adultoMayor.getPersona().getNombre());
        cstmt.setString(2, adultoMayor.getPersona().getPrimerApellido());
        cstmt.setString(3, adultoMayor.getPersona().getSegundoApellido());
        cstmt.setString(4, adultoMayor.getPersona().getGenero());
        cstmt.setString(5, adultoMayor.getUsuario().getNombreUsuario());
        cstmt.setString(6, adultoMayor.getUsuario().getContrasenia());
        cstmt.setString(7, adultoMayor.getFamiliarCargo().getPersona().getNombre());
        cstmt.setString(8, adultoMayor.getFamiliarCargo().getPersona().getPrimerApellido());
        cstmt.setString(9, adultoMayor.getFamiliarCargo().getPersona().getSegundoApellido());
        cstmt.setString(10, adultoMayor.getFamiliarCargo().getPersona().getGenero());
        cstmt.setString(11, adultoMayor.getFamiliarCargo().getNumeroTelefono());
        cstmt.setString(12, adultoMayor.getMedico().getPersona().getNombre());
        cstmt.setString(13, adultoMayor.getMedico().getPersona().getPrimerApellido());
        cstmt.setString(14, adultoMayor.getMedico().getPersona().getSegundoApellido());
        cstmt.setString(15, adultoMayor.getMedico().getPersona().getGenero());
        cstmt.setString(16, adultoMayor.getMedico().getNumeroTelefono());
        cstmt.setString(17, adultoMayor.getFechaNacimiento());
        cstmt.setString(18, adultoMayor.getFotografia());

        cstmt.registerOutParameter(19, Types.INTEGER);
        cstmt.registerOutParameter(20, Types.INTEGER);
        cstmt.registerOutParameter(21, Types.INTEGER);
        cstmt.registerOutParameter(22, Types.INTEGER);
        cstmt.registerOutParameter(23, Types.INTEGER);
        cstmt.registerOutParameter(24, Types.INTEGER);
        cstmt.registerOutParameter(25, Types.INTEGER);
        cstmt.registerOutParameter(26, Types.VARCHAR);

        //6. Ejecutar la sentencia
        cstmt.executeUpdate();

        //7.Recuperar los parametros de rotorno
        idPersonaOut = cstmt.getInt(19);
        idPersonaFamOut = cstmt.getInt(20);
        idPersonaMedOut = cstmt.getInt(21);
        idUsuarioOut = cstmt.getInt(22);
        idFamiliarOut = cstmt.getInt(23);
        idMedicoOut = cstmt.getInt(24);
        idAdultoMayorOut = cstmt.getInt(25);
        numeroUnicoOut = cstmt.getString(26);

        //8. Colocar los valores recuperados dentro del objeto
        adultoMayor.getPersona().setIdPersona(idPersonaOut);
        adultoMayor.getFamiliarCargo().getPersona().setIdPersona(idPersonaFamOut);
        adultoMayor.getMedico().getPersona().setIdPersona(idPersonaMedOut);
        adultoMayor.getUsuario().setIdUsuario(idUsuarioOut);
        adultoMayor.getFamiliarCargo().setIdFamiliarCargo(idFamiliarOut);
        adultoMayor.getMedico().setIdMedico(idMedicoOut);
        adultoMayor.setIdAdultoMayor(idAdultoMayorOut);
        adultoMayor.setNumeroUnico(numeroUnicoOut);

        //9. Cerrar los objetos de uso de BD
        cstmt.close();
        conn.close();
        objConexionMySQL.close();

        //10. Devolver el id que se genero
        return idAdultoMayorOut;

    }

    public List<AdultoMayor> getAll() throws SQLException {

        String sql = "SELECT * FROM v_adultomayor " + ";";

        ConexionMySQL connMySQL = new ConexionMySQL();

        Connection conn = connMySQL.open();

        PreparedStatement pstmt = conn.prepareStatement(sql);

        ResultSet rs = pstmt.executeQuery();
        List<AdultoMayor> lisA = new ArrayList<>();

        while (rs.next()) {
            lisA.add(fill(rs));
        }
        rs.close();
        pstmt.close();
        connMySQL.close();
        return lisA;
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
