package com.rup.pokescape.controller;

import com.rup.pokescape.PokeRepository;
import com.rup.pokescape.model.Pokemon;
import com.rup.pokescape.service.PokemonServiceImpl;
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

    @Autowired
    private PokemonServiceImpl pokemonServiceImpl;

    @GetMapping("")
    public @ResponseBody
    String index() {
        return "Data Index";
    }

    // Get list of all pokemon
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Pokemon> getAllPokemon() {
        return pokemonServiceImpl.getAllPokemon();
    }

    // Get individual pokemon by pokedexId
    @GetMapping(path="/pokedexId/{pokedexId}")
    @ResponseBody
    public Pokemon getSinglePokemonByPokedexId (@PathVariable String pokedexId ) {
        return pokemonServiceImpl.getPokemonById(Integer.parseInt(pokedexId));
    }

    // Get all pokemon of type
    @GetMapping(path="/type/{type}")
    @ResponseBody
    public List<Pokemon> getPokemonByType (@PathVariable String type) {
        return pokemonServiceImpl.getPokemonByType(type);
    }

    // Add a single pokemon
    @PostMapping(path="/add")
    public @ResponseBody String addNewPokemon (
            @RequestParam Integer pokedexEntry,
            @RequestParam String name,
            @RequestParam String type) {

        pokemonServiceImpl.addPokemon(pokedexEntry, name, type);

        return "Saved!";
    }

    // Service level services tutorial https://java-design-patterns.com/patterns/service-layer/

    // Service level handles any logic for retrieving data from db. Controller class
    // should be able to just call service methods to retrieve what each endpoint needs

}
