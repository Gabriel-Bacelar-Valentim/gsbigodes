package br.com.fiap.sprint4bigodes;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fiap.sprint4bigodes.model.PrescricoesMedicas;
import br.com.fiap.sprint4bigodes.service.PrescricoesMedicasService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

import java.util.List;

@Path("/prescricoesmedicas")
public class PrescricoesMedicasResource {

    private final PrescricoesMedicasService prescricoesMedicasService = new PrescricoesMedicasService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PrescricoesMedicas> listarPrescricoesMedicas() {
        return prescricoesMedicasService.listarPrescricoesMedicas();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PrescricoesMedicas consultarPrescricaoMedica(@PathParam("id") Long id) {
        return prescricoesMedicasService.consultarPrescricoesMedicas(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarPrescricaoMedica(PrescricoesMedicas prescricaoMedica) {
        prescricoesMedicasService.cadastrarPrescricoesMedicas(prescricaoMedica);
        return Response.status(Response.Status.CREATED).build();
    }

    @PATCH
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarPrescricaoMedica(@PathParam("id") Long id, PrescricoesMedicas prescricaoMedica) {
        prescricaoMedica.setPrescricaoId(id);
        prescricoesMedicasService.atualizarPrescricoesMedicas(prescricaoMedica);
    }

    @DELETE
    @Path("/{id}")
    public void deletarPrescricaoMedica(@PathParam("id") Long id) {
        prescricoesMedicasService.deletarPrescricoesMedicas(id);
    }
}
