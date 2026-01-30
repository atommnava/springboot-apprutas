package com.informaticonfig.spring.apprutas.springboot_apprutas.controllers;

import com.informaticonfig.spring.apprutas.springboot_apprutas.services.DijkstraService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RutaController {

    private final DijkstraService dijkstraService;

    public RutaController(DijkstraService dijkstraService) {
        this.dijkstraService = dijkstraService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/calcular")
    public String calcularRuta(
            @RequestParam String origen,
            @RequestParam String destino,
            Model model) {

        var resultado = dijkstraService.calcularRuta(origen, destino);

        model.addAttribute("ruta", resultado.getRuta());
        model.addAttribute("distancia", resultado.getDistancia());
        model.addAttribute("combustible", resultado.getCombustibleAhorrado());

        return "resultado";
    }
}
