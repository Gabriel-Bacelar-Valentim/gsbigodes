package br.com.fiap.sprint4bigodes;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fiap.sprint4bigodes.model.Pacientes;
import br.com.fiap.sprint4bigodes.service.PacientesService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
 
import java.util.List;

@Path("/pacientes")
public class PacientesResource {
 
    private final PacientesService pacientesService = new PacientesService();
 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pacientes> listarPacientes() {
        return pacientesService.listarPacientes();
    }
 
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pacientes consultarPaciente(@PathParam("id") Long id) {
        return pacientesService.consultarPaciente(id);
    }
 
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarPaciente(Pacientes paciente) {
        pacientesService.cadastrarPaciente(paciente);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarPaciente(@PathParam("id") Long id, Pacientes paciente) {
        paciente.setPacienteId(id);
        pacientesService.atualizarPaciente(paciente);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletarPaciente(@PathParam("id") Long id) {
        pacientesService.deletarPaciente(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
