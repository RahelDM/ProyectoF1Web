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

    @GetMapping("/circuitoForm/{id}")
    public String updateCircuito(Model model, @PathVariable Long id){
        Optional<Circuito> circuitoOptional = this.circuitoService.findCircuitoById(id);
        if(circuitoOptional.isPresent()){
            model.addAttribute("circuitoFormulario", circuitoOptional.get());
            model.addAttribute("nuevo", false); //vamos a actualizar el circuito, no crearlo
        }else{
            model.addAttribute("msg", "No existe el circuito con id " + id);
        }
        return "circuito/circuitoForm";
    }
    @GetMapping("/circuito/add")
    public String addCircuito(Model model){
        Circuito circuito = new Circuito();
        model.addAttribute("circuitoFormulario", circuito); //el que recibirá el formulario
        model.addAttribute("nuevo", true); //vamos a añadir el circuito, no actualizarlo
        return "circuito/circuitoForm";
    }

    @PostMapping("/circuito/save") // /circuitos/circuito/save
    public String saveCircuito(Model model, @ModelAttribute(value = "circuitoFormulario") Circuito circuito){
        this.circuitoService.save(circuito);
        return "redirect:/circuitos/circuito/"+circuito.getCircuitoId();
    }

    @PutMapping("/circuito/save") // /circuitos/circuito/save
    public String updateCircuito(Model model, @ModelAttribute(value = "circuitoFormulario") Circuito circuito){
        this.circuitoService.save(circuito);
        return "redirect:/circuitos/circuito/"+circuito.getCircuitoId();
    }
}
