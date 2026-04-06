package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@Controller
public class DemoController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("mensaje", "Hola desde Spring Boot");
        model.addAttribute("nombres", List.of("Ana", "Luis", "Pedro","Domingo"));  
        model.addAttribute("edad", 17 );
        return "index";
    }

    @GetMapping("/contacto")
    public String contacto(Model model) {
        return "contacto";
    }
    //ruta ESPECÍFICA
    @GetMapping("/ciclos/nuevo")
    public String nuevoCiclo() {
        return "nuevo";
    }
    //Ruta dinámica general
    @GetMapping("/ciclos/{id}")
    public String ciclo(@PathVariable String id, Model model) {
        model.addAttribute("ciclo", id);
        return "ciclo";
    }
    // @GetMapping("/productos/{id}")
    // public String ciclo(@PathVariable int id, Model model) {
    //     model.addAttribute("numero", id);
    //     return "productos";
    // }
}