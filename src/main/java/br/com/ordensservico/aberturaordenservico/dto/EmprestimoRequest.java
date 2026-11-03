package br.com.ordensservico.aberturaordenservico.dto;

public class EmprestimoRequest {
    
    private Integer equipamentoId;
    private Integer setorId;

    public EmprestimoRequest() {
    }

    public Integer getEquipamentoId() {
        return equipamentoId;
    }

    public void setEquipamentoId(Integer equipamentoId) {
        this.equipamentoId = equipamentoId;
    }

    public Integer getSetorId() {
        return setorId;
    }

    public void setSetorId(Integer setorId) {
        this.setorId = setorId;
    }
}
