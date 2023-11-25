package br.com.fiap.sprint4bigodes.model;

public class PrescricoesMedicas {
    
    private Long prescricaoId;
    private Long consultaId;
    private Long medicamentoId;
    private String dosagem;
    
    public PrescricoesMedicas() {
        super();
    }
    
    public PrescricoesMedicas(Long prescricaoId, Long consultaId, Long medicamentoId, String dosagem) {
        super();
        this.prescricaoId = prescricaoId;
        this.consultaId = consultaId;
        this.medicamentoId = medicamentoId;
        this.dosagem = dosagem;
    }
    
    public Long getPrescricaoId() {
        return prescricaoId;
    }
    
    public void setPrescricaoId(Long prescricaoId) {
        this.prescricaoId = prescricaoId;
    }
    
    public Long getConsultaId() {
        return consultaId;
    }
    
    public void setConsultaId(Long consultaId) {
        this.consultaId = consultaId;
    }
    
    public Long getMedicamentoId() {
        return medicamentoId;
    }
    
    public void setMedicamentoId(Long medicamentoId) {
        this.medicamentoId = medicamentoId;
    }
    
    public String getDosagem() {
        return dosagem;
    }
    
    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }
}
