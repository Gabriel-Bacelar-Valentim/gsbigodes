package br.com.fiap.sprint4bigodes.service;

import java.util.List;

import br.com.fiap.sprint4bigodes.data.PacientesDao;
import br.com.fiap.sprint4bigodes.model.Pacientes;
 
public class PacientesService {
 
    private final PacientesDao pacientesDao = new PacientesDao();
 
    public void cadastrarPaciente(Pacientes paciente) {
        pacientesDao.cadastrarPaciente(paciente);
    }
    
    private boolean validar (Pacientes pacientes) {
    	if (pacientes.pacienteId == null) return false;
    	if (pacientes.nome == null) return false;
    	
    	return true;
    }
 
    public Pacientes consultarPaciente(Long id) {
        return pacientesDao.consultarPaciente(id);
    }
 
    public List<Pacientes> listarPacientes() {
        return pacientesDao.listarPacientes();
    }
    
    public void atualizarPaciente(Pacientes paciente) {
        pacientesDao.atualizarPaciente(paciente);
    }

    public void deletarPaciente(Long id) {
        pacientesDao.deletarPaciente(id);
    }
}
