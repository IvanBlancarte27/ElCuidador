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
import org.utl.dsm.cuidador.Cuidador;
import org.utl.dsm.cuidador.controller.ControllerCuidador;

@Path("cuidador")
public class CuidadorREST extends Application {

    @Path("insertCuidador")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertCuidador(@FormParam("datos") @DefaultValue("") String datos) {
        Gson gson = new Gson();
        String out = "";

        Cuidador cuidador = new Cuidador();
        cuidador = gson.fromJson(datos, Cuidador.class);
        ControllerCuidador cc = new ControllerCuidador();

        try {
            cc.insertarCuidador(cuidador);
            out = gson.toJson(cuidador);
        } catch (JsonParseException json) {
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

            ControllerCuidador ctCuidador = new ControllerCuidador();
            List<Cuidador> lente_contactos = ctCuidador.getAllCuidador();
            Gson gson = new Gson();
            out = gson.toJson(lente_contactos);
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
        Cuidador a = new Cuidador();
        //El punto class es la especificacion que contiene la clase
        a = gson.fromJson(datos, Cuidador.class);
        String out = "";
        ControllerCuidador mayor = new ControllerCuidador();
        try {
            mayor.actualizarCuidador(a);
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
