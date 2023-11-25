package br.com.fiap.sprint4bigodes;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fiap.sprint4bigodes.model.Medicamentos;
import br.com.fiap.sprint4bigodes.service.MedicamentosService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import java.util.List;

@Path("/medicamentos")
public class MedicamentosResource {

    private final MedicamentosService medicamentosService = new MedicamentosService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Medicamentos> listarMedicamentos() {
        return medicamentosService.listarMedicamentos();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Medicamentos consultarMedicamento(@PathParam("id") Long id) {
        return medicamentosService.consultarMedicamento(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarMedicamento(Medicamentos medicamento) {
        medicamentosService.cadastrarMedicamento(medicamento);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarMedicamento(@PathParam("id") Long id, Medicamentos medicamento) {
        medicamento.setMedicamentoId(id);
        medicamentosService.atualizarMedicamento(medicamento);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletarMedicamento(@PathParam("id") Long id) {
        medicamentosService.deletarMedicamento(id);
        return Response.ok().build();
    }
}
