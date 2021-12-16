package com.rup.pokescape.service;

import com.rup.pokescape.model.Pokemon;

import java.util.List;

public interface PokemonService {

        void addPokemon(Integer pokedexEntry, String name, String type);
        void updatePokemon(Integer id, Pokemon pokemon);
        void deletePokemon(Integer id);
        List<Pokemon> getAllPokemon();
        Pokemon getPokemonById(Integer id);
        List<Pokemon> getPokemonByType(String type);

        // Add some kind of query that return data based on interactions between more than one entity
        // Add type table to database
        // Return pokemon of a type

}
