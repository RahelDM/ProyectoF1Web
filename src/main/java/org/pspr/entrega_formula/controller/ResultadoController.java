package org.pspr.entrega_formula.controller;

import org.pspr.entrega_formula.dto.PilotoDTO;
import org.pspr.entrega_formula.dto.ResultadoDTO;
import org.pspr.entrega_formula.model.Piloto;
import org.pspr.entrega_formula.model.Resultado;
import org.pspr.entrega_formula.service.PilotoService;
import org.pspr.entrega_formula.service.ResultadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/resultados")
public class ResultadoController {

    @Autowired
    ResultadoService resultadoService;

    @Autowired
    PilotoService pilotoService;

    @GetMapping("")
    public String getResultados(Model model) {
        List<Resultado> resultadoList = resultadoService.findAllResultados();
        model.addAttribute("resultados", resultadoList);
        return "resultado/resultados";
    }


    @GetMapping("/buscar/")
    public String getResultadosFiltro(Model model, @RequestParam("cadena") String cadena) {
        List<Resultado> resultadoList = resultadoService.findResultadosByWord(cadena);
        model.addAttribute("resultados", resultadoList);
        return "resultado/resultados";
    }


    @GetMapping("/pilotos")
    public String getPilotosClasificacion(Model model) {
        List<ResultadoDTO> resultados = resultadoService.findPilotosPuntos();
        model.addAttribute("resultados", resultados);
        PilotoDTO pilotoMasVictorias = pilotoService.findPilotoMasVictorias();
        model.addAttribute("pilotoMasVictorias", pilotoMasVictorias);
        return "resultado/clasificacionPilotos";
    }

    @GetMapping("/equipos")
    public String getEquiposClasificacion(Model model) {
        List<ResultadoDTO> resultados = resultadoService.findEquiposPuntos();
        model.addAttribute("resultados", resultados);
        return "resultado/clasificacionEquipos";
    }

}
