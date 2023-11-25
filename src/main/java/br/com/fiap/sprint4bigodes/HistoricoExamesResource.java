package br.com.fiap.sprint4bigodes;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fiap.sprint4bigodes.model.HistoricoExames;
import br.com.fiap.sprint4bigodes.service.HistoricoExamesService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
 
import java.util.List;
 
@Path("/historicoexames")
public class HistoricoExamesResource {
 
    private final HistoricoExamesService historicoExamesService = new HistoricoExamesService();
 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<HistoricoExames> listarHistoricoExames() {
        return historicoExamesService.listarExames();
    }
 
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public HistoricoExames consultarHistoricoExames(@PathParam("id") Long id) {
        return historicoExamesService.consultarExames(id);
    }
 
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarHistoricoExames(HistoricoExames historicoExames) {
        historicoExamesService.cadastrarExames(historicoExames);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarHistoricoExames(@PathParam("id") Long id, HistoricoExames historicoExames) {
        historicoExames.setExameId(id);
        historicoExamesService.atualizarExames(historicoExames);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletarHistoricoExames(@PathParam("id") Long id) {
        historicoExamesService.deletarExames(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
