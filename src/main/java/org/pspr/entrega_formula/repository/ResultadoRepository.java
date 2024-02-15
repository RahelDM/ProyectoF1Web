package org.pspr.entrega_formula.repository;

import org.pspr.entrega_formula.model.Circuito;
import org.pspr.entrega_formula.model.Resultado;
import org.pspr.entrega_formula.model.ResultadoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultadoRepository  extends JpaRepository<Resultado, ResultadoId> {
}
