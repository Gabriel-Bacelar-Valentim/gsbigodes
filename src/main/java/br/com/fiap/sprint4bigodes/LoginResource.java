package br.com.fiap.sprint4bigodes;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fiap.sprint4bigodes.model.Login;
import br.com.fiap.sprint4bigodes.service.LoginService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import java.util.List;

@Path("/login")
public class LoginResource {

    private final LoginService loginService = new LoginService();

    @GET
    @Path("/{nomeLogin}")
    @Produces(MediaType.APPLICATION_JSON)
    public Login consultarLogin(@PathParam("nomeLogin") String nomeLogin) {
        return loginService.consultarLogin(nomeLogin);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Login> listarLogins() {
        return loginService.listarLogins();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarLogin(Login login) {
        loginService.cadastrarLogin(login);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{nomeLogin}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarLogin(@PathParam("nomeLogin") String nomeLogin, Login login) {
        login.setNomeLogin(nomeLogin);
        loginService.atualizarLogin(login);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{nomeLogin}")
    public Response deletarLogin(@PathParam("nomeLogin") String nomeLogin) {
        loginService.deletarLogin(nomeLogin);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
