package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.PokemonResponse;
import com.example.demo.model.Pokemon;

@Service
public class PokemonService {

    private final String URL = "https://pokeapi.co/api/v2/pokemon/";
    private final RestTemplate restTemplate = new RestTemplate();

    public Pokemon obtenerPokemon(int id) {
        try {
            // Consumir la API y mapear a DTO
            PokemonResponse response = restTemplate.getForObject(URL + id, PokemonResponse.class);

            if (response == null) {
                throw new RuntimeException("No se recibió respuesta de la API");
            }

            // Crear el modelo Pokemon
            return new Pokemon(response);

        } catch (Exception e) {
            System.err.println("Error al obtener el Pokemon: " + e.getMessage());
            return null;
        }
    }
}