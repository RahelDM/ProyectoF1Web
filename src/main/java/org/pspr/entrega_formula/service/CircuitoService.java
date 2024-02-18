package org.pspr.entrega_formula.service;

import org.pspr.entrega_formula.model.Circuito;

import java.util.List;
import java.util.Optional;

public interface CircuitoService {

    List<Circuito> findAllCircuitos();

    Optional<Circuito> findCircuitoById(Long id);

    void save(Circuito circuito);
}
