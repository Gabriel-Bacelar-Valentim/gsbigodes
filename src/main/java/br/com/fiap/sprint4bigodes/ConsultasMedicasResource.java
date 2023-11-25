package br.com.fiap.sprint4bigodes;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fiap.sprint4bigodes.model.ConsultasMedicas;
import br.com.fiap.sprint4bigodes.service.ConsultasMedicasService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import java.util.List;

@Path("/consultasmedicas")
public class ConsultasMedicasResource {

    private final ConsultasMedicasService consultasMedicasService = new ConsultasMedicasService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ConsultasMedicas> listarConsultasMedicas() {
        return consultasMedicasService.listarConsultasMedicas();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ConsultasMedicas consultarConsultaMedica(@PathParam("id") Long id) {
        return consultasMedicasService.consultarConsultaMedica(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarConsultaMedica(ConsultasMedicas consultaMedica) {
        consultasMedicasService.criarConsultasMedicas(consultaMedica);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarConsultaMedica(@PathParam("id") Long id, ConsultasMedicas consultaMedica) {
        consultaMedica.setConsultaId(id);
        consultasMedicasService.atualizarConsultasMedicas(consultaMedica);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletarConsultaMedica(@PathParam("id") Long id) {
        consultasMedicasService.deletarConsultasMedicas(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
