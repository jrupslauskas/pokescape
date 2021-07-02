package com.rup.pokescape;

import com.rup.pokescape.model.Pokemon;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface PokeRepository extends CrudRepository<Pokemon, Integer> {

    List<Pokemon> findAll();
}
