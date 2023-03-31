

package org.utl.dsm.rest;

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
import org.utl.dsm.cuidador.AdultoMayor;
import org.utl.dsm.cuidador.controller.ControllerAdultoMayor;


@Path("adultoMayor")
public class AdultoMayorREST extends Application{
    
    @Path("insertAdulto")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertarAdultoMayor(@FormParam("datos") @DefaultValue("") String datos){
        Gson gson = new Gson();
        AdultoMayor adultoMayor= new AdultoMayor();
        String out="";
        
        adultoMayor=gson.fromJson(datos, AdultoMayor.class);
        ControllerAdultoMayor controllerAdultoMayor = new ControllerAdultoMayor();
        
        try {
            controllerAdultoMayor.insertAdultoMayor(adultoMayor);
            out=gson.toJson(adultoMayor);
        } catch (JsonParseException jpe) {
            out = """
                   {"error": "Error de formato"}
                   """;
        }catch(SQLException ex){
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }
        
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
}
