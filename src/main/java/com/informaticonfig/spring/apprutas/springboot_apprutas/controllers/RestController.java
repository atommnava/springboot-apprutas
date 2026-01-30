package com.informaticonfig.spring.apprutas.springboot_apprutas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class RestController {
    @GetMapping("/info")
    
    public String info(Model model) {
        model.addAttribute("titulo", "Servidor en línea");
        model.addAttribute("servidor", "informaticonfig");
        model.addAttribute("ip", "192.168.100.4");
        
        return "info";
    }
}