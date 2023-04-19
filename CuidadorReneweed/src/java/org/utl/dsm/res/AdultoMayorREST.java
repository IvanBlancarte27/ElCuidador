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
import java.util.List;
import org.utl.dsm.cuidador.AdultoMayor;
import org.utl.dsm.cuidador.controller.ControllerAdultoMayor;

@Path("adultoMayor")
public class AdultoMayorREST {

    @Path("insertAdulto")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertarAdultoMayor(@FormParam("datos") @DefaultValue("") String datos) {
        Gson gson = new Gson();
        AdultoMayor adultoMayor;
        adultoMayor = new AdultoMayor();
        String out = "";

        adultoMayor = gson.fromJson(datos, AdultoMayor.class);
        ControllerAdultoMayor controllerAdultoMayor = new ControllerAdultoMayor();

        try {

            controllerAdultoMayor.insertAdultoMayor(adultoMayor);
            out = gson.toJson(adultoMayor);
        } catch (JsonParseException jpe) {
            out = """
                   {"error": "Error de formato"}
                   """;
        } catch (SQLException ex) {
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }

        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("getAll")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        String out = "";
        try {
            ControllerAdultoMayor cmA = new ControllerAdultoMayor();
            List<AdultoMayor> adultos = cmA.getAll();
            Gson gs = new Gson();
            out = gs.toJson(adultos);
        } catch (Exception ex) {
            System.out.println(ex.toString());

            out = "{\"error\":\"" + ex.toString() + "\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("actualizar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(@FormParam("datos") @DefaultValue("") String datos) {
        Gson gson = new Gson();
        AdultoMayor a = new AdultoMayor();
        //El punto class es la especificacion que contiene la clase
        a = gson.fromJson(datos, AdultoMayor.class);
        String out = "";
        ControllerAdultoMayor mayor = new ControllerAdultoMayor();
        try {
            mayor.actualizarAdultoMayor(a);
            out = gson.toJson(a);
        } catch (JsonParseException jpe) {
            out = """
                   {"error": "Error de formato"}
                   """;
        } catch (SQLException ex) {

            out = "{\"error\":\"" + ex.toString() + "\"}";

        }

        return Response.status(Response.Status.OK).entity(out).build();
    }

}
