package org.pspr.entrega_formula.serviceImpl;

import org.pspr.entrega_formula.model.Resultado;
import org.pspr.entrega_formula.repository.ResultadoRepository;
import org.pspr.entrega_formula.service.ResultadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultadoServiceImpl implements ResultadoService {

    @Autowired
    private ResultadoRepository resultadoRepository;
    @Override
    public List<Resultado> findAllResultados() {
        return this.resultadoRepository.findAllResultadosOrdenados();
    }

    @Override
    public List<Resultado> findResultadosByWord(String cadena) {
       return this.resultadoRepository.findResultadosByWord(cadena);
    }
}
