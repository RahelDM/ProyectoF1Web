package org.pspr.entrega_formula.controller;

import org.pspr.entrega_formula.model.Piloto;
import org.pspr.entrega_formula.service.PilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Random;

@Controller
public class AppController {

    public static final int MAX = 21;
    public static final int MIN = 1;
    public static final int NEXT = 2;

    @Autowired
    private PilotoService pilotoService;

    @GetMapping("/")
    public  String iniciar(Model model){
        this.getPilotosAlAzar(model);
        return "index";
    }

    public void getPilotosAlAzar(Model model){
        int desde = generarNumAleatorio(MAX, MIN);
        List<Piloto> pilotoList = pilotoService.findPilotosAlAzar(desde, desde+ NEXT);
        model.addAttribute("pilotosAzar",pilotoList); //cargamos la lista de pilotos al azar
    }
    private int generarNumAleatorio(int max, int min){
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
