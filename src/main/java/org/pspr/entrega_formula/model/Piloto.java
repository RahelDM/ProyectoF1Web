package org.pspr.entrega_formula.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pilotos")
@NoArgsConstructor
@Getter
@Setter
public class Piloto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pilotoId;

    @Column
    private int numero;
    @Column
    private String equipo;
    @Column
    private String foto;
    @Column
    private String nombre;

    @OneToMany(mappedBy = "piloto")
    private Set<Resultado> resultados = new HashSet<>();
    public void setPilotoId(Long pilotoId) {
        this.pilotoId = pilotoId;
    }

    public Long getPilotoId() {
        return pilotoId;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
