package br.com.fiap.sprint4bigodes.model;

public class Medicamentos {
    
    private Long medicamentoId;
    private String nomeMedicamento;
    private String tipoMedicamento;
    private String indicacoes;
    
    public Medicamentos() {
        super();
    }
    
    public Medicamentos(Long medicamentoId, String nomeMedicamento, String tipoMedicamento, String indicacoes) {
        super();
        this.medicamentoId = medicamentoId;
        this.nomeMedicamento = nomeMedicamento;
        this.tipoMedicamento = tipoMedicamento;
        this.indicacoes = indicacoes;
    }
    
    public Long getMedicamentoId() {
        return medicamentoId;
    }
    
    public void setMedicamentoId(Long medicamentoId) {
        this.medicamentoId = medicamentoId;
    }
    
    public String getNomeMedicamento() {
        return nomeMedicamento;
    }
    
    public void setNomeMedicamento(String nomeMedicamento) {
        this.nomeMedicamento = nomeMedicamento;
    }
    
    public String getTipoMedicamento() {
        return tipoMedicamento;
    }
    
    public void setTipoMedicamento(String tipoMedicamento) {
        this.tipoMedicamento = tipoMedicamento;
    }
    
    public String getIndicacoes() {
        return indicacoes;
    }
    
    public void setIndicacoes(String indicacoes) {
        this.indicacoes = indicacoes;
    }
}
