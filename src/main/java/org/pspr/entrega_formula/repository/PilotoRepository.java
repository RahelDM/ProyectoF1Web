package org.pspr.entrega_formula.repository;

import org.pspr.entrega_formula.model.Circuito;
import org.pspr.entrega_formula.model.Piloto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PilotoRepository  extends JpaRepository<Piloto, Long> {

    @Query("from Piloto where numero between :desde and :hasta")
    List<Piloto> findPilotosAlAzar(int desde, int hasta);



}
