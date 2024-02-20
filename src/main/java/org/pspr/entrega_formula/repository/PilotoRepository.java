package org.pspr.entrega_formula.repository;

import org.pspr.entrega_formula.dto.PilotoDTO;
import org.pspr.entrega_formula.model.Piloto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PilotoRepository extends JpaRepository<Piloto, Long> {

    @Query("from Piloto where numero between :desde and :hasta")
    List<Piloto> findPilotosAlAzar(int desde, int hasta);

    @Query("""
            SELECT new org.pspr.entrega_formula.dto.PilotoDTO(r.piloto,count(r.piloto.pilotoId))
            FROM Resultado r where r.posicionLlegada=1 GROUP BY r.piloto.pilotoId ORDER BY count(r.piloto.pilotoId) DESC LIMIT 1
            """)
    PilotoDTO findPilotoMasVictorias();


}
