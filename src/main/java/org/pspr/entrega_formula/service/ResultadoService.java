package org.pspr.entrega_formula.service;

import org.pspr.entrega_formula.model.Resultado;

import java.util.List;

public interface ResultadoService {
    List<Resultado> findAllResultados();

    List<Resultado> findResultadosByWord(String cadena);

}
