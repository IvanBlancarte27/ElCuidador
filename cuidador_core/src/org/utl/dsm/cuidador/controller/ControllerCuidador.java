/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.cuidador.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.sql.SQLException;
import org.utl.dsm.cuidador.Cuidador;
import org.utl.dsm.db.ConexionMySQL;

/**
 *
 * @author ivandejesusblancarteaguayo
 */
public class ControllerCuidador {

    public int insertarCuidador(Cuidador cuidador) throws SQLException {
        //1. Generar la consulta que vamos a enviar a la base de datos
        String query = "call insertarCuidador(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        //2. Preparamos las variables para recibir los valores de retorno
        int idPersonaOut = 0;
        int idUsuarioOut = 0;
        String numeroUnico = "";
        int idCuidadorOut = 0;
        //3. Conectarse a la base de Datos
        ConexionMySQL objConexionMySQL = new ConexionMySQL();
        Connection conn = objConexionMySQL.open();

        //4. Generar el objeto que va a invocar el Store Procedure
        CallableStatement cstmt = conn.prepareCall(query);
        
        //5.Asignar cada uno de los valores que se requiere
        cstmt.setString(1, cuidador.getPersona().getNombre());
        cstmt.setString(2, cuidador.getPersona().getPrimerApellido());
        cstmt.setString(3, cuidador.getPersona().getSegundoApellido());
        cstmt.setString(4, cuidador.getPersona().getGenero());
        cstmt.setString(5, cuidador.getUsuario().getNombreUsuario());
        cstmt.setString(6, cuidador.getUsuario().getContrasenia());
        cstmt.setString(7, cuidador.getFotografiaIne());
        cstmt.setString(8, cuidador.getFotografiaIne());
        cstmt.setString(9, cuidador.getCartaRecomendacion());
        cstmt.setString(10, cuidador.getCartaAntecedentesPenales());
        cstmt.setString(11, cuidador.getComprobanteDomicilio());
        cstmt.setString(12, cuidador.getRfc());
        cstmt.setString(13, cuidador.getFechaNacimiento());
        cstmt.setString(14, cuidador.getNumTelefonoMovil());
        cstmt.setString(15, cuidador.getNumTelefonoCasa());
        cstmt.setString(16, cuidador.getCorreo());
        
        cstmt.registerOutParameter(17, Types.INTEGER);
        cstmt.registerOutParameter(18, Types.INTEGER);
        cstmt.registerOutParameter(19, Types.VARCHAR);
        cstmt.registerOutParameter(20, Types.INTEGER);
        
        //6. Ejecutar la sentencia
        cstmt.executeUpdate();
        
        //7.Recuperar los parametros de rotorno
        idPersonaOut=cstmt.getInt(17);
        idUsuarioOut=cstmt.getInt(18);
        numeroUnico=cstmt.getString(19);
        idCuidadorOut=cstmt.getInt(20);
        
        //8. Colocar los valores recuperados dentro del objeto
        cuidador.getPersona().setIdPersona(idPersonaOut);
        cuidador.getUsuario().setIdUsuario(idUsuarioOut);
        cuidador.setNumeroUnico(numeroUnico);
        cuidador.setIdCuidador(idCuidadorOut);
        
        //9. Cerrar los objetos de uso de BD
        cstmt.close();
        conn.close();
        objConexionMySQL.close();
        
        //10. Devolver el id que se genero
        return idCuidadorOut;
        
    }
}
