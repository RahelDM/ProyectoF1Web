package org.pspr.entrega_formula.controller;

import org.pspr.entrega_formula.model.Piloto;
import org.pspr.entrega_formula.model.Resultado;
import org.pspr.entrega_formula.service.ResultadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/resultados")
public class ResultadoController {

    @Autowired
    ResultadoService resultadoService;
    @GetMapping("")
    public String getPilotos(Model model) {
        List<Resultado> resultadoList = resultadoService.findAllResultados();
        model.addAttribute("resultados", resultadoList);
        return "resultado/resultados";
    }


    @GetMapping("/buscar/")
    public String getPilotosFiltro(Model model, @RequestParam("cadena") String cadena) {
        List<Resultado> resultadoList = resultadoService.findResultadosByWord(cadena);
        model.addAttribute("resultados", resultadoList);
        return "resultado/resultados";
    }
}
