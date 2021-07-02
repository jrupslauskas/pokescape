package com.rup.pokescape.controller;

import com.rup.pokescape.PokeRepository;
import com.rup.pokescape.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path="/data")
public class PokemonController {
    @Autowired
    private PokeRepository pokeRepository;

    @GetMapping("")
    public @ResponseBody
    String index() {
        return "<h1>PokeList</h1><ol><li>Bulbasaur</li><li>Ivysaur</li><li>Venasaur</li></ol>";
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
                .filter(pokemon -> pokemon.getPokedexEntry().equals(Integer.parseInt(pokedexId)))
                .findFirst()
                .orElseThrow(() -> new Exception());
    }

    // Get all pokemon of type
    @GetMapping(path="/type/{type}")
    @ResponseBody
    public List<Pokemon> getPokemonByType (@PathVariable String type) throws Exception {
        List<Pokemon> pokemonList = pokeRepository.findAll();

        return pokemonList.stream()
                .filter(pokemon -> pokemon.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
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
