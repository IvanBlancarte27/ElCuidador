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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.utl.dsm.cuidador.Persona;
import org.utl.dsm.cuidador.Usuario;

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
    
    public List<Cuidador> getAllCuidador() throws SQLException{
        
        String qr = "SELECT * FROM v_cuidador;";
        
        ConexionMySQL connMySQL = new ConexionMySQL();
        //Abrimos la conexion con la Base de Datos:
        Connection conn = connMySQL.open();
        //Con este objeto ejecutaremos la consulta:
        PreparedStatement pstmt = conn.prepareStatement(qr);
        //Aqui Guardaremos los resultados de la consulta:
        ResultSet rs = pstmt.executeQuery();
        List<Cuidador> empleado = new ArrayList<>();

        //Cuando una condicion no lleva llavez 
        while (rs.next()) {
            empleado.add(fill(rs));
        }
        rs.close();
        pstmt.close();
        connMySQL.close();
        return empleado;
    }
    
    
    public void actualizarCuidador(Cuidador cuidador) throws SQLException {
       
        String query = "{call actualizarCuidador(?,?,?,?,?,?,?,?,?,?,?,?,?)}";

        //3. Conectarse a la base de Datos
        ConexionMySQL objConexionMySQL = new ConexionMySQL();
        Connection conn = objConexionMySQL.open();

       
        CallableStatement cstmt = conn.prepareCall(query);

        
        cstmt.setString(1,cuidador.getPersona().getNombre());
        cstmt.setString(2, cuidador.getPersona().getPrimerApellido());
        cstmt.setString(3, cuidador.getPersona().getSegundoApellido());       
        cstmt.setString(4,cuidador.getPersona().getGenero());
        
        
        cstmt.setString(5, cuidador.getUsuario().getNombreUsuario());
        cstmt.setString(6, cuidador.getUsuario().getContrasenia());
        
        
        cstmt.setString(7, cuidador.getRfc());
        cstmt.setString(8, cuidador.getNumTelefonoMovil());
        cstmt.setString(9, cuidador.getNumTelefonoCasa());
        cstmt.setString(10, cuidador.getCorreo());
        
        cstmt.setInt(11, cuidador.getPersona().getIdPersona());
        cstmt.setInt(12, cuidador.getIdCuidador());
        cstmt.setInt(13, cuidador.getUsuario().getIdUsuario());
       
       

        cstmt.executeUpdate();

       
        cstmt.close();
        conn.close();
        objConexionMySQL.close();

    }
    
    
    private Cuidador fill(ResultSet rs) throws SQLException {
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
