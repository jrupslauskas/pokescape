package com.rup.pokescape.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Integer id;
    private Integer pokedexEntry;
    private String name;
    private String type;

    public Pokemon() {};

    public Pokemon(Integer pokedexEntry, String name, String type) {
        this.pokedexEntry = pokedexEntry;
        this.name = name;
        this.type = type;
    }

    public Integer getPokedexEntry() {
        return pokedexEntry;
    }

    public void setPokedexEntry(Integer pokedexEntry) {
        this.pokedexEntry = pokedexEntry;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
