package org.pspr.entrega_formula.service;

import org.pspr.entrega_formula.model.Piloto;

import java.util.List;
import java.util.Optional;

public interface PilotoService  {
    List<Piloto> findAllPilotos();

    List<Piloto> findPilotosAlAzar(int desde, int hasta);

    Optional<Piloto> findPilotoById(Long id);

    Piloto save(Piloto piloto);

}
