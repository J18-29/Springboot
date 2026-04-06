package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Pokemon;
import com.example.demo.service.PokemonService;

@Controller
public class PokemonController {

    @Autowired
    private PokemonService service;

    
    @GetMapping({"/", "/pokemon"})
    public String mostrarPokemon(Model model) {
        return obtenerListaAleatoria(1, 1010, model);
    }

    
    @GetMapping("/generacion/{gen}")
    public String mostrarPorGeneracion(@PathVariable int gen, Model model) {
       
        if (gen == 3) {
            return "404"; 
        }

        int minId, maxId;
        if (gen == 1) {
            minId = 1; maxId = 151;
        } else if (gen == 2) {
            minId = 152; maxId = 251;
        } else {
            return "redirect:/pokemon";
        }

        return obtenerListaAleatoria(minId, maxId, model);
    }

    
    private String obtenerListaAleatoria(int min, int max, Model model) {
        Random r = new Random();
        Set<Integer> idsSeleccionados = new HashSet<>();
        ArrayList<Pokemon> pokemons = new ArrayList<>();

       
        while (idsSeleccionados.size() < 10) {
            int randomId = r.nextInt((max - min) + 1) + min;
            
           
            if (idsSeleccionados.add(randomId)) {
                Pokemon p = service.obtenerPokemon(randomId);
                if (p != null) {
                    p.setImagen("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/" + randomId + ".png");
                    pokemons.add(p);
                }
            }
        }

        model.addAttribute("pokemons", pokemons);
        return "pokemon"; 
    }

   
    @GetMapping("/pokemon/{id}")
    public String mostrarDetalle(@PathVariable Integer id, Model model) {
        Pokemon pokemon = service.obtenerPokemon(id);
        if (pokemon == null) {
            model.addAttribute("error", "No se pudo obtener el Pokémon");
            return "404";
        }
        
        pokemon.setImagen("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/" + id + ".png");
        model.addAttribute("pokemon", pokemon);
        model.addAttribute("id", id); 
        return "pokemonDetalle";
    }
}