/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.cuidador.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import org.utl.dsm.cuidador.AdultoMayor;
import org.utl.dsm.db.ConexionMySQL;

/**
 *
 * @author ivandejesusblancarteaguayo
 */
public class ControllerAdultoMayor {
    
    public int insertAdultoMayor(AdultoMayor adultoMayor) throws SQLException{
        //1. Generar la consulta que vamos a enviar a la base de datos
        String query="call insertAdultoMayor(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        //2. Preparamos las variables para recibir los valores de retorno
        int idPersonaOut=0;
        int idPersonaFamOut=0;
        int idPersonaMedOut=0;
        int idUsuarioOut=0;
        int idFamiliarOut=0;
        int idMedicoOut=0;
        int idAdultoMayorOut=0;
        String numeroUnicoOut="";
        
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
        cstmt.setString(18, adultoMayor.getFechaNacimiento());
        
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
        idPersonaOut=cstmt.getInt(19);
        idPersonaFamOut=cstmt.getInt(20);
        idPersonaMedOut=cstmt.getInt(21);
        idUsuarioOut=cstmt.getInt(22);
        idFamiliarOut=cstmt.getInt(23);
        idMedicoOut=cstmt.getInt(24);
        idAdultoMayorOut=cstmt.getInt(25);
        numeroUnicoOut=cstmt.getString(26);
        
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
}
