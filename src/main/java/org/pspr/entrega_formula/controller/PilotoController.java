package org.pspr.entrega_formula.controller;

import org.pspr.entrega_formula.model.Piloto;
import org.pspr.entrega_formula.service.PilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pilotos")
public class PilotoController {


    @Autowired
    private PilotoService pilotoService;

    @GetMapping("")
    public String getPilotos(Model model) {
        List<Piloto> pilotoList = pilotoService.findAllPilotos();
        model.addAttribute("pilotos", pilotoList);
        return "piloto/pilotos";
    }

    @GetMapping("/{id}")
    public String getPilotoById(Model model, @PathVariable Long id) {
        Optional<Piloto> pilotoOptional = pilotoService.findPilotoById(id);
        if (pilotoOptional.isPresent()) {
            model.addAttribute("piloto", pilotoOptional.get());
        } else {
            model.addAttribute("msg", "Sin pilotos con id: " + id);
        }
        return "piloto/piloto";
    }


    @GetMapping("/pilotoForm/{id}")
    public String updatePiloto(Model model, @PathVariable Long id) {
        Optional<Piloto> pilotoOptional = pilotoService.findPilotoById(id);
        if (pilotoOptional.isPresent()) { //el piloto a actualizar existe
            model.addAttribute("piloto", pilotoOptional.get()); //mandamos el piloto para actualizar
            model.addAttribute("nuevo", false);
            return "piloto/pilotoForm";
        } else {
            model.addAttribute("msg", "No hay un piloto con id: " + id);
        }
        return "redirect:/pilotos"; //si se produce algún error y no se accede al formulario...
    }

    @GetMapping("/piloto/add")
    public String savePiloto(Model model) {
        Piloto piloto = new Piloto();
        model.addAttribute("piloto", piloto);
        model.addAttribute("nuevo", true);
        return "piloto/pilotoForm";
    }


    @PostMapping("/piloto/save")
    public String savePiloto(@ModelAttribute(value = "pilotoFormulario") Piloto pilotoFormulario) {
        pilotoService.save(pilotoFormulario);
        return "redirect:/pilotos/" + pilotoFormulario.getPilotoId(); //si se produce algún error y no se accede al formulario...
    }

    @PutMapping("/piloto/save")
    public String updatePiloto(@ModelAttribute(value = "pilotoFormulario") Piloto pilotoFormulario) {
        pilotoService.save(pilotoFormulario);
        return "redirect:/pilotos/" + pilotoFormulario.getPilotoId(); //si se produce algún error y no se accede al formulario...
    }


}
