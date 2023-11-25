package br.com.fiap.sprint4bigodes.service;

import java.util.List;

import br.com.fiap.sprint4bigodes.data.DoencasDao;
import br.com.fiap.sprint4bigodes.model.Doencas;

public class DoencasService {

    private final DoencasDao doencasDao = new DoencasDao();

    public void cadastrarDoenca(Doencas doenca) {
        
    	
    	doencasDao.cadastrarDoenca(doenca);
    }

    public Doencas consultarDoenca(Long id) {
        return doencasDao.consultarDoenca(id);
    }

    public List<Doencas> listarDoencas() {
        return doencasDao.listarDoencas();
    }

    public void atualizarDoenca(Doencas doenca) {
        doencasDao.atualizarDoenca(doenca);
    }

    public void deletarDoenca(Long id) {
        doencasDao.deletarDoenca(id);
    }
}
