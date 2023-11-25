package br.com.fiap.sprint4bigodes.service;

import java.util.List;

import br.com.fiap.sprint4bigodes.data.ConsultasMedicasDao;
import br.com.fiap.sprint4bigodes.model.ConsultasMedicas;

public class ConsultasMedicasService {

    private final ConsultasMedicasDao consultasMedicasDao = new ConsultasMedicasDao();

    public boolean criarConsultasMedicas(ConsultasMedicas consultaMedica) {
    	if (!validar(consultaMedica)) return false;
		
			consultasMedicasDao.criarConsultasMedicas(consultaMedica);
			return true;
    	
    }
  
    
    private boolean validar (ConsultasMedicas consultamedica) {
    	if (consultamedica.consultaId <= 0) return false;
    	if (consultamedica.pacienteId <= 0) return false;
    	if (consultamedica.tratamento == null) return false;
    	
    	return true;
    }

    public ConsultasMedicas consultarConsultaMedica(Long id) {
        return consultasMedicasDao.consultarConsultasMedicas(id);
    }

    public List<ConsultasMedicas> listarConsultasMedicas() {
        return consultasMedicasDao.listarConsultasMedicas();
    }

    public void atualizarConsultasMedicas(ConsultasMedicas consultaMedica) {
        consultasMedicasDao.atualizarConsultasMedicas(consultaMedica);
    }

    public void deletarConsultasMedicas(Long id) {
        consultasMedicasDao.deletarConsultasMedicas(id);
    }
}
