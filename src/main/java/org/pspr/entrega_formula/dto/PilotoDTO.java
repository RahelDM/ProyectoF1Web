package org.pspr.entrega_formula.dto;

import lombok.Getter;
import org.pspr.entrega_formula.model.Piloto;

public class PilotoDTO {

    private Piloto piloto;
    private Long num;

    public PilotoDTO(Piloto piloto, Long num) {
        this.piloto = piloto;
        this.num = num;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }
}
