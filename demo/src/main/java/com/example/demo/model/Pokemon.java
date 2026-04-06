package com.example.demo.model;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dto.PokemonResponse;


public class Pokemon {
    private int numero;
    private String nombre;
    private String imagen;
    private int hp;
    private int ataque;
    private int defensa;
    private List<String> tipos;  // puede tener varios tipos el Pokemon

    public Pokemon() {}

    public Pokemon(PokemonResponse response) {
        this.numero = response.getId();
        this.nombre = response.getName();
        this.imagen = response.getSprites().getFront_default();

        // stats: 0=hp, 1=ataque, 2=defensa
        this.hp = response.getStats().get(0).getBase_stat();
        this.ataque = response.getStats().get(1).getBase_stat();
        this.defensa = response.getStats().get(2).getBase_stat();

        // convertir lista de TypeSlot a lista de nombres de tipos
        this.tipos = response.getTypes().stream().map(typeSlot -> typeSlot.getType().getName()).collect(Collectors.toList());
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public List<String> getTipos() {
        return tipos;
    }

    public void setTipos(List<String> tipos) {
        this.tipos = tipos;
    }
    
}