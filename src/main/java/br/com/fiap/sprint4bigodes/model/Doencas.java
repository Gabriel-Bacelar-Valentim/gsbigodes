package br.com.fiap.sprint4bigodes.model;

public class Doencas {
	 
    private Long doencaId;
    private String nomeDoenca;
 
    public Doencas() {
        super();
    }
 
    public Doencas(Long doencaId, String nomeDoenca) {
        super();
        this.doencaId = doencaId;
        this.nomeDoenca = nomeDoenca;
    }
 
    public Long getDoencaId() {
        return doencaId;
    }
 
    public void setDoencaId(Long doencaId) {
        this.doencaId = doencaId;
    }
 
    public String getNomeDoenca() {
        return nomeDoenca;
    }
 
    public void setNomeDoenca(String nomeDoenca) {
        this.nomeDoenca = nomeDoenca;
    }
 
	
}
