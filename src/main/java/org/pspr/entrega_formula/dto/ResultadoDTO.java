package org.pspr.entrega_formula.dto;

import org.pspr.entrega_formula.model.Piloto;

public class ResultadoDTO {

    private Piloto piloto;

    private String equipo;

    private Long puntos;

    public ResultadoDTO(Piloto piloto, Long puntos) {
        this.piloto = piloto;
        this.puntos = puntos;
    }

    public ResultadoDTO(String equipo, Long puntos) {
        this.equipo = equipo;
        this.puntos = puntos;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public Long getPuntos() {
        return puntos;
    }

    public void setPuntos(Long puntos) {
        this.puntos = puntos;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
}
