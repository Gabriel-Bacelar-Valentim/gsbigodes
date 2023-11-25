package br.com.fiap.sprint4bigodes.model;

public class Login {
	 
    private String nomeLogin;
    private String email;
    private String senha;
 
    public Login() {
        super();
    }
 
    public Login(String nomeLogin, String email, String senha) {
        super();
        this.nomeLogin = nomeLogin;
        this.email = email;
        this.senha = senha;
    }
 
    public String getNomeLogin() {
        return nomeLogin;
    }
 
    public void setNomeLogin(String nomeLogin) {
        this.nomeLogin = nomeLogin;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getSenha() {
        return senha;
    }
 
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
