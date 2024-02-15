package org.pspr.entrega_formula.controller;

import org.pspr.entrega_formula.model.Piloto;
import org.pspr.entrega_formula.service.PilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Controller
@RequestMapping("/pilotos")
public class PilotoController {


    @Autowired
    private PilotoService pilotoService;

    @GetMapping("")
    public String getPilotos(Model model){
        List<Piloto> pilotoList = pilotoService.findAllPilotos();
        model.addAttribute("pilotos",pilotoList);
        return "piloto/pilotos";
    }

    @GetMapping("/{id}")
    public String getPilotoById(Model model, @PathVariable Long id){
        Optional<Piloto> pilotoOptional = pilotoService.findPilotoById(id);
        if(pilotoOptional.isPresent()){
            model.addAttribute("piloto",pilotoOptional.get());
        }else {
            model.addAttribute("msg","Sin pilotos con id: " + id);
        }
        return "piloto/piloto";
    }

}
