package org.pspr.entrega_formula.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.print.attribute.standard.MediaSize;

@Entity
@Table(name = "resultados")
@NoArgsConstructor
@Getter
@Setter
public class Resultado {

    @EmbeddedId
    private ResultadoId resultadoId;

    @Column
    private int posicionSalida;
    @Column
    private int posicionLlegada;

    @ManyToOne
    @MapsId("pilotoId")
    @JoinColumn(name = "pilotoId")
    private Piloto piloto;

    @ManyToOne
    @MapsId("circuitoId")
    @JoinColumn(name = "circuitoId")
    private Circuito circuito;
}
