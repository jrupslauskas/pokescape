package com.rup.pokescape.service;

import com.rup.pokescape.PokeRepository;
import com.rup.pokescape.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PokemonServiceImpl implements PokemonService {
    @Autowired
    private PokeRepository pokeRepository;

    @Override
    public void addPokemon(Integer pokedexEntry, String name, String type) {

        Pokemon pokemon = new Pokemon();
        pokemon.setPokedexEntry(pokedexEntry);
        pokemon.setName(name);
        pokemon.setType(type);
        pokeRepository.save(pokemon);
    }

    @Override
    public void updatePokemon(Integer id, Pokemon pokemon) {

    }

    @Override
    public void deletePokemon(Integer id) {

    }

    @Override
    public List<Pokemon> getAllPokemon() {

        return pokeRepository.findAll();
    }

    @Override
    public Pokemon getPokemonById(Integer pokedexId) {
        List<Pokemon> pokemonList = pokeRepository.findAll();
            return pokemonList.stream()
                    .filter(pokemon -> pokemon.getPokedexEntry().equals(pokedexId))
                    .findFirst()
                    .orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Pokemon> getPokemonByType(String type) {
        List<Pokemon> pokemonList = pokeRepository.findAll();

        return pokemonList.stream()
                .filter(pokemon -> pokemon.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }
}
