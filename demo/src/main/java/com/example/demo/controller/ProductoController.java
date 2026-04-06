package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Producto;

@Controller
public class ProductoController {
    String imagen="https://m.media-amazon.com/images/I/61qhqhlA14L._AC_SY300_SX300_QL70_ML2_.jpg";
    private final List<Producto> productos = List.of(
        new Producto("Producto 1", "Descripción del producto 1", imagen, 23.55, "A"),
        new Producto("Producto 2", "Descripción del producto 2", imagen, 15.99, "B"),
        new Producto("Producto 3", "Descripción del producto 3", imagen, 7, "A"),
        new Producto("Producto 4", "Descripción del producto 4", imagen, 315.20, "B"),
        new Producto("Producto 5", "Descripción del producto 5", imagen, 21.05, "C")
    );

    @GetMapping("/productos/")
    public String mostrarProductos(@RequestParam(value="categoria", required=false) String categoria, Model model) {
        List<Producto> listaFiltrada;
        if(categoria != null) {
            listaFiltrada = productos.stream()
                                    .filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
                                    .collect(Collectors.toList());
        } else {         listaFiltrada = productos;        }
        model.addAttribute("productos", listaFiltrada);
        model.addAttribute("categoria", categoria);
        return "productos";
    }
    @GetMapping("/productos/{id}")
    public String mostrarProductosCategoria(@PathVariable String id, Model model) {
        List<Producto> listaFiltrada;
        listaFiltrada = productos.stream()
                                    .filter(p -> p.getCategoria().equalsIgnoreCase(id))
                                    .collect(Collectors.toList());
        model.addAttribute("productos", listaFiltrada);
        model.addAttribute("categoria", id);
        return "productos";
    }
}