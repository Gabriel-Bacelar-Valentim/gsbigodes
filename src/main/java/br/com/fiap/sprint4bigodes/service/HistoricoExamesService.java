package br.com.fiap.sprint4bigodes.service;

import java.util.List;

import br.com.fiap.sprint4bigodes.data.HistoricoExamesDao;
import br.com.fiap.sprint4bigodes.model.HistoricoExames;
 
public class HistoricoExamesService {
 
    private final HistoricoExamesDao historicoExamesDao = new HistoricoExamesDao();
 
    public void cadastrarExames(HistoricoExames historicoExames) {
    	
    	
    	
        historicoExamesDao.cadastrarExame(historicoExames);
    }
 
    public boolean validar (HistoricoExames historicoExames) {
    	if(historicoExames.exameId == null) return false;
    	if(historicoExames.pacienteId == null) return false;
    	if(historicoExames.resultado == null) return false;

    	return true;
    }
    public HistoricoExames consultarExames(Long id) {
        return historicoExamesDao.consultarExame(id);
    }
 
    public List<HistoricoExames> listarExames() {
        return historicoExamesDao.listarExames();
    }

    public void atualizarExames(HistoricoExames historicoExames) {
        historicoExamesDao.atualizarExame(historicoExames);
    }

    public void deletarExames(Long id) {
        historicoExamesDao.deletarExame(id);
    }
}
