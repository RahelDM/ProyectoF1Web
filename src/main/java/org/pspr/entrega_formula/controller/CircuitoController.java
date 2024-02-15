package org.pspr.entrega_formula.controller;

import org.pspr.entrega_formula.model.Circuito;
import org.pspr.entrega_formula.service.CircuitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/circuitos")
public class CircuitoController {

    @Autowired
    private CircuitoService circuitoService;

    @GetMapping()
    public String getCircuitos(Model model){
        List<Circuito> circuitos = this.circuitoService.findAllCircuitos();
        model.addAttribute("circuitos", circuitos);
        return "circuito/circuitos";
    }


    @GetMapping("/circuito/{id}")
    public String getCircuitoById(Model model, @PathVariable Long id){
        Optional<Circuito> circuitoOptional = this.circuitoService.findCircuitoById(id);
        if(circuitoOptional.isPresent()){
            model.addAttribute("circuitoADetallar", circuitoOptional.get());
        }else{
            model.addAttribute("msg", "No existe el circuito con id " + id);
        }
        return "circuito/circuito";
    }
}
