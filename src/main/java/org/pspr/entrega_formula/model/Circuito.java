package org.pspr.entrega_formula.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "circuitos")
@NoArgsConstructor
@Getter
@Setter
public class Circuito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long circuitoId;
    @Column
    private double longitud;
    @Column
    private int numeroCurvas;
    @Column
    private int numeroVueltas;
    @Column
    private String foto;
    @Column
    private String nombre;
    @Column
    private String pais;

    @OneToMany(mappedBy = "circuito")
    private Set<Resultado> resultados = new HashSet<>();


}
