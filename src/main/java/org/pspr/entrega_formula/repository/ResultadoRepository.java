package org.pspr.entrega_formula.repository;

import org.pspr.entrega_formula.model.Circuito;
import org.pspr.entrega_formula.model.Resultado;
import org.pspr.entrega_formula.model.ResultadoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResultadoRepository  extends JpaRepository<Resultado, ResultadoId> {

     @Query("FROM Resultado r ORDER BY r.circuito.nombre ASC, r.posicionLlegada ASC")
     List<Resultado> findAllResultadosOrdenados();
}
