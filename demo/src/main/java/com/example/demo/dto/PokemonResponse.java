package com.example.demo.dto;

import java.util.List;

public class PokemonResponse {

    private int id;
    private String name;
    private int height;
    private int weight;

    private List<Stat> stats;
    private List<TypeSlot> types;

    private Sprites sprites;

    public PokemonResponse() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }

    public List<Stat> getStats() { return stats; }
    public void setStats(List<Stat> stats) { this.stats = stats; }

    public List<TypeSlot> getTypes() { return types; }
    public void setTypes(List<TypeSlot> types) { this.types = types; }

    public Sprites getSprites() { return sprites; }
    public void setSprites(Sprites sprites) { this.sprites = sprites; }

public static class Stat {

    private int base_stat;
    private StatInfo stat;

    public Stat() {}

    public int getBase_stat() { return base_stat; }
    public void setBase_stat(int base_stat) { this.base_stat = base_stat; }

    public StatInfo getStat() { return stat; }
    public void setStat(StatInfo stat) { this.stat = stat; }
}
public static class StatInfo {

    private String name;
    private String url;

    public StatInfo() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
}
public static class TypeSlot {

    private int slot;
    private TypeInfo type;

    public TypeSlot() {}

    public int getSlot() { return slot; }
    public void setSlot(int slot) { this.slot = slot; }

    public TypeInfo getType() { return type; }
    public void setType(TypeInfo type) { this.type = type; }
}
public static class TypeInfo {

    private String name;
    private String url;

    public TypeInfo() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
}
public static class Sprites {

    private String front_default;

    public Sprites() {}

    public String getFront_default() { return front_default; }
    public void setFront_default(String front_default) { this.front_default = front_default; }
}
}