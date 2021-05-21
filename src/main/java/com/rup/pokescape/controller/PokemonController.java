package com.rup.pokescape.controller;

import com.rup.pokescape.PokeRepository;
import com.rup.pokescape.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/pokemon")
public class PokemonController {
    @Autowired
    private PokeRepository pokeRepository;

    @GetMapping("/")
    public @ResponseBody String index() {
        return "Welcome to Pokescape!";
    }

    // Get list of all pokemon
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Pokemon> getAllPokemon() {
        return pokeRepository.findAll();
    }

    // Get individual pokemon by pokedexId
    @GetMapping(path="/pokedexId/{pokedexId}")
    @ResponseBody
    public Pokemon getSinglePokemonByPokedexId (@PathVariable String pokedexId ) throws Exception {
        List<Pokemon> pokemonList = pokeRepository.findAll();
        // Put inside try catch
        return pokemonList.stream()
                .filter(pokemon -> pokemon.getPokedexEntry() == Integer.parseInt(pokedexId))
                .findFirst()
                .orElseThrow(() -> new Exception());
            }

    // Add a single pokemon
    @PostMapping(path="/add")
    public @ResponseBody String addNewPokemon (
            @RequestParam Integer pokedexEntry,
            @RequestParam String name,
            @RequestParam String type) {
        Pokemon pokemon = new Pokemon();
        pokemon.setPokedexEntry(pokedexEntry);
        pokemon.setName(name);
        pokemon.setType(type);
        pokeRepository.save(pokemon);
        return "Saved!";
    }

}
