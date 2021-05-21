package com.rup.pokescape;

import com.rup.pokescape.model.Pokemon;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.stream.Stream;

public interface PokeRepository extends CrudRepository<Pokemon, Integer> {

    List<Pokemon> findAll();
}
