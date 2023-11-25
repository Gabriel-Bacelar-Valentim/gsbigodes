package br.com.fiap.sprint4bigodes.service;

import java.util.List;

import br.com.fiap.sprint4bigodes.data.MedicamentosDao;
import br.com.fiap.sprint4bigodes.model.Medicamentos;

public class MedicamentosService {

    private final MedicamentosDao medicamentosDao = new MedicamentosDao();

    public void cadastrarMedicamento(Medicamentos medicamento) {
        medicamentosDao.cadastrarMedicamento(medicamento);
    }

    public Medicamentos consultarMedicamento(Long id) {
        return medicamentosDao.consultarMedicamento(id);
    }

    public List<Medicamentos> listarMedicamentos() {
        return medicamentosDao.listarMedicamentos();
    }

    public void atualizarMedicamento(Medicamentos medicamento) {
        medicamentosDao.atualizarMedicamento(medicamento);
    }

    public void deletarMedicamento(Long id) {
        medicamentosDao.deletarMedicamento(id);
    }
}
