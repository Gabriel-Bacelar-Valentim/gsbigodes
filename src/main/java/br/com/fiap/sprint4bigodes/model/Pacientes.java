package br.com.fiap.sprint4bigodes.model;

public class Pacientes {
    
    public Long pacienteId;
    public String nome;
    private Long idade;
    private String sexo;
    private String cpf;
    
    public Pacientes() {
        super();
    }
    
    public Pacientes(Long pacienteId, String nome, Long idade, String sexo, String cpf) {
        super();
        this.pacienteId = pacienteId;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.cpf = cpf;
    }
    
    public Long getPacienteId() {
        return pacienteId;
    }
    
    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Long getIdade() {
        return idade;
    }
    
    public void setIdade(Long idade) {
        this.idade = idade;
    }
    
    public String getSexo() {
        return sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

	public Object pacienteId() {
		
		return null;
	}
}
