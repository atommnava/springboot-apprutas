package com.informaticonfig.spring.apprutas.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;

public class RestController {
    @GetMapping("/info")
    
    public Map<String, Object> detalles_info2() {
        Map<String, Object> respuesta = new HashMap<>(); 
        respuesta.put("Titulo", "Servidor en línea");
        respuesta.put("Servidor", "informaticonfig");
        respuesta.put("Ip", "192.168.100.4");  
        return respuesta;
    }
}
