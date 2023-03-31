
package org.utl.dsm.cuidador.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.utl.dsm.cuidador.AdultoMayor;
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
    
}
