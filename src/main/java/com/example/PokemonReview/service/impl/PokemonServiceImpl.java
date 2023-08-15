package com.example.PokemonReview.service.impl;

import com.example.PokemonReview.entity.Pokemon;
import com.example.PokemonReview.exceptions.PokemonNotFoundException;
import com.example.PokemonReview.repository.PokemonRepository;
import com.example.PokemonReview.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PokemonServiceImpl implements PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;
    @Override
    public void createPokemon(Pokemon pokemon) {
        if (pokemon != null){
            pokemonRepository.save(pokemon);
        }
    }

    @Override
    public List<Pokemon> getAllPokemon() {
        return pokemonRepository.findAll();
    }

    @Override
    public Pokemon getPokemonById(int id) {
        return pokemonRepository.findById(id).orElseThrow(
                ()-> new PokemonNotFoundException("don't have that pokemon"));
    }

    @Override
    public Pokemon updatePokemon(Pokemon pokemonDto, int id) {
        return null;
    }

    @Override
    public void deletePokemonId(int id) {

    }
}
