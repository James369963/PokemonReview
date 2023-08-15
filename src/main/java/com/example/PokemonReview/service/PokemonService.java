package com.example.PokemonReview.service;

import com.example.PokemonReview.entity.Pokemon;

import java.util.List;

public interface PokemonService {
    void createPokemon(Pokemon pokemon);
    List<Pokemon> getAllPokemon();
    Pokemon getPokemonById(int id);
    Pokemon updatePokemon(Pokemon pokemonDto, int id);
    void deletePokemonId(int id);
}
