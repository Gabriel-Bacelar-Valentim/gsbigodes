package br.com.fiap.sprint4bigodes.model;

import java.util.Date;
import java.util.List;

public class ConsultasMedicas {
	
	    public Long consultaId;
	    private Date dataConsulta;
	    public String tratamento;
	    public Long pacienteId;
	    private Long doencaId;
	    
	    public ConsultasMedicas() {
	        super();
	    }
	    
	    public ConsultasMedicas(Long consultaId, Date dataConsulta, String tratamento, Long pacienteId, Long doencaId) {
	        super();
	        this.consultaId = consultaId;
	        this.dataConsulta = dataConsulta;
	        this.tratamento = tratamento;
	        this.pacienteId = pacienteId;
	        this.doencaId = doencaId;
	    }
	    
	    public Long getConsultaId() {
	        return consultaId;
	    }
	    
	    public void setConsultaId(Long consultaId) {
	        this.consultaId = consultaId;
	    }
	    
	    public Date getDataConsulta() {
	        return dataConsulta;
	    }
	    
	    public void setDataConsulta(Date dataConsulta) {
	        this.dataConsulta = dataConsulta;
	    }
	    
	    public String getTratamento() {
	        return tratamento;
	    }
	    
	    public void setTratamento(String tratamento) {
	        this.tratamento = tratamento;
	    }
	    
	    public Long getPacienteId() {
	        return pacienteId;
	    }
	    
	    public void setPacienteId(Long pacienteId) {
	        this.pacienteId = pacienteId;
	    }
	    
	    public Long getDoencaId() {
	        return doencaId;
	    }
	    
	    public void setDoencaId(Long doencaId) {
	        this.doencaId = doencaId;
	    }

		
	}
