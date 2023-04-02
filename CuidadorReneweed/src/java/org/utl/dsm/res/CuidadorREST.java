
package org.utl.dsm.res;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.SQLException;
import org.utl.dsm.cuidador.Cuidador;
import org.utl.dsm.cuidador.controller.ControllerCuidador;


@Path("cuidador")
public class CuidadorREST extends Application{
    
    @Path("insertCuidador")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertCuidador(@FormParam("datos") @DefaultValue("") String datos){
        Gson gson= new Gson();
        String out="";
        
        Cuidador cuidador = new Cuidador();
        cuidador=gson.fromJson(datos, Cuidador.class);
        ControllerCuidador cc = new ControllerCuidador();
 
        try {
            cc.insertarCuidador(cuidador);
            out=gson.toJson(cuidador);
        } catch (JsonParseException json) {
            out = """
                   {"error": "Error de formato"}
                   """;
        }catch(SQLException ex){
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }
        
        return  Response.status(Response.Status.OK).entity(out).build();
    
    }
}
