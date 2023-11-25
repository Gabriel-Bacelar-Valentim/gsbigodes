package br.com.fiap.sprint4bigodes;

import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fiap.sprint4bigodes.model.Doencas;
import br.com.fiap.sprint4bigodes.service.DoencasService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/doencas")
public class DoencasResource {
	 
    private final DoencasService doencasService = new DoencasService();
 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Doencas> listarDoencas() {
        return doencasService.listarDoencas();
    }
 
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Doencas consultarDoenca(@PathParam("id") Long id) {
        return doencasService.consultarDoenca(id);
    }
 
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarDoenca(Doencas doenca) {
        doencasService.cadastrarDoenca(doenca);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarDoenca(@PathParam("id") Long id, Doencas doenca) {
        doenca.setDoencaId(id);
        doencasService.atualizarDoenca(doenca);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletarDoenca(@PathParam("id") Long id) {
        doencasService.deletarDoenca(id);
        return Response.ok().build();
    }
}
