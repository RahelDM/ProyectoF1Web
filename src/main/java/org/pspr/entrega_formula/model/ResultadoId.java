package org.pspr.entrega_formula.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@Getter
@Setter
public class ResultadoId implements Serializable {
    //Referencia a la PK de circuito
    private Long circuitoId;
    //Referencia a la PK de piloto
    private Long pilotoId;


}
