package br.com.fiap.sprint4bigodes.service;

import java.util.List;

import br.com.fiap.sprint4bigodes.data.PrescricoesMedicasDao;
import br.com.fiap.sprint4bigodes.model.PrescricoesMedicas;

public class PrescricoesMedicasService {

    private final PrescricoesMedicasDao prescricoesMedicasDao = new PrescricoesMedicasDao();

    public void cadastrarPrescricoesMedicas(PrescricoesMedicas prescricoesMedicas) {
        prescricoesMedicasDao.cadastrarPrescricoesMedicas(prescricoesMedicas);
    }

    public PrescricoesMedicas consultarPrescricoesMedicas(Long id) {
        return prescricoesMedicasDao.consultarPrescricoesMedicas(id);
    }

    public List<PrescricoesMedicas> listarPrescricoesMedicas() {
        return prescricoesMedicasDao.listarPrescricoesMedicas();
    }

    public void atualizarPrescricoesMedicas(PrescricoesMedicas prescricoesMedicas) {
        prescricoesMedicasDao.atualizarPrescricoesMedicas(prescricoesMedicas);
    }

    public void deletarPrescricoesMedicas(Long id) {
        prescricoesMedicasDao.deletarPrescricoesMedicas(id);
    }
}
