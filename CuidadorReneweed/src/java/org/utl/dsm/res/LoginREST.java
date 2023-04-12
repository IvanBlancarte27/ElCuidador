/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import org.utl.dsm.cuidador.Usuario;
import org.utl.dsm.cuidador.controller.ControllerLogin;

@Path("login")
public class LoginREST extends Application {

    @Path("loginCuidador")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginCuidador(@FormParam("usuario") @DefaultValue("") String user) {
        Gson gson = new Gson();
        String out = "";
        Usuario usuario = new Usuario();

        usuario = gson.fromJson(user, Usuario.class);

        ControllerLogin login = new ControllerLogin();
        try {
            Cuidador cui = login.accederCuidador(usuario);
            out = gson.toJson(cui);
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
