package br.com.fiap.sprint4bigodes.model;

import java.util.Date;

public class HistoricoExames {
    
    public Long exameId;
    public Long pacienteId;
    private String tipoExame;
    public String resultado;
    private Date dataExame;
    
    public HistoricoExames() {
        super();
    }
    
    public HistoricoExames(Long exameId, Long pacienteId, String tipoExame, String resultado, Date dataExame) {
        super();
        this.exameId = exameId;
        this.pacienteId = pacienteId;
        this.tipoExame = tipoExame;
        this.resultado = resultado;
        this.dataExame = dataExame;
    }
    
    public Long getExameId() {
        return exameId;
    }
    
    public void setExameId(Long exameId) {
        this.exameId = exameId;
    }
    
    public Long getPacienteId() {
        return pacienteId;
    }
    
    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }
    
    public String getTipoExame() {
        return tipoExame;
    }
    
    public void setTipoExame(String tipoExame) {
        this.tipoExame = tipoExame;
    }
    
    public String getResultado() {
        return resultado;
    }
    
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    public Date getDataExame() {
        return dataExame;
    }
    
    public void setDataExame(Date dataExame) {
        this.dataExame = dataExame;
    }
}
