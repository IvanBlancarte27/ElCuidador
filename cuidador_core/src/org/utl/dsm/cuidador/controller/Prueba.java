
package org.utl.dsm.cuidador.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Prueba {

    
    public static void main(String[] args) throws SQLException {
        
        //probarConexion();
        //insertarAdultoMayor();
        insertarCuidador();

    }
    
    
     public static void probarConexion() {
        try {
            //Creamos un objeto de la clase creada
            ConexionMySQL objConexion = new ConexionMySQL();
            Connection conexion = objConexion.open();
            System.out.println(conexion.toString());
            conexion.close();

        } catch (SQLException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public static void insertarAdultoMayor() throws SQLException{
        Persona personaAd= new Persona("Juan", "Aguayo", "Zuñiga", "Hombre");
        Persona personaFam = new Persona("Ernesto", "Aguayo", "Zuñiga", "Hombre");
        Persona personaMedic= new Persona("Miguel", "Bustamante", "Araujo", "Hombre");
        
        Usuario usuario= new Usuario("JuanErnesto", "27UTL123", "");
        
        FamiliarCargo familiarCargo = new FamiliarCargo("4771189966", personaFam);
        Medico medico = new Medico("4778905432", personaMedic);
        AdultoMayor adultoMayor = new AdultoMayor("", "hjlokijusywhenm78w99djcn", "27/02/2020", familiarCargo, medico, personaAd, usuario);
        
        ControllerAdultoMayor controllerAdultoMayor = new ControllerAdultoMayor();
        
        controllerAdultoMayor.insertAdultoMayor(adultoMayor);
        
        System.out.println(adultoMayor.toString());
    
    }
    
    public static void insertarCuidador() throws SQLException{
        Persona persona = new Persona("Juan de Dios", "Arellano", "Segura", "Hombre");
        Usuario usuario= new Usuario("JuanAre098", "12340987y", "");
        
        Cuidador cuidador= new Cuidador("", "12pincndjh67hd36d", "12pincndjh67hd36d", "12pincndjh67hd36d", 
                                        "12pincndjh67hd36d", "ABC76HJ", "4771189966", "4778904356", "JuanCorel@gmail.com", "12pincndjh67hd36d", persona, usuario, "09/03/2020");
        
        ControllerCuidador cc= new ControllerCuidador();
        
        System.out.println(cc.insertarCuidador(cuidador));
    
    }
    
}
