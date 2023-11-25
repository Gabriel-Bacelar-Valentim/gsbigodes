package br.com.fiap.sprint4bigodes.service;

import java.util.List;

import br.com.fiap.sprint4bigodes.data.LoginDao;
import br.com.fiap.sprint4bigodes.model.Login;

public class LoginService {

    private final LoginDao loginDao = new LoginDao();

    public boolean cadastrarLogin(Login login) {
        if (!validar(login)) return false;

        loginDao.cadastrarLogin(login);
        return true;
    }

    private boolean validar(Login login) {
        if (login.getNomeLogin() == null || login.getNomeLogin().isEmpty()) return false;
        if (login.getEmail() == null || login.getEmail().isEmpty()) return false;
        if (login.getSenha() == null || login.getSenha().isEmpty()) return false;

        return true;
    }

    public Login consultarLogin(String nomeLogin) {
        return loginDao.consultarLogin(nomeLogin);
    }

    public List<Login> listarLogins() {
        return loginDao.listarLogins();
    }

    public void atualizarLogin(Login login) {
        loginDao.atualizarLogin(login);
    }

    public void deletarLogin(String nomeLogin) {
        loginDao.deletarLogin(nomeLogin);
    }
}
