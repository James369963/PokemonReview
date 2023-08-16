package com.example.PokemonReview.controller;

import com.example.PokemonReview.dto.response.APIResponse;
import com.example.PokemonReview.entity.Pokemon;
import com.example.PokemonReview.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    @Autowired
    private PokemonService pokemonService;
    /*create a pokemon*/
    @PostMapping("/create")
    public ResponseEntity<APIResponse> createPokemon(@RequestBody Pokemon pokemon){
        pokemonService.createPokemon(pokemon);
        APIResponse apiResponse = APIResponse.builder()
                .statusCode(HttpStatus.CREATED.value())
                .message("create success!!!")
                .build();
        return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
    }

    /*get all pokemons*/
    @GetMapping
    public ResponseEntity<APIResponse> getAllPokemon(){
        APIResponse apiResponse = APIResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .message("List Pokemon!!!")
                .data(pokemonService.getAllPokemon())
                .build();
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    /*get pokemon by id*/
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getPokemonById(@PathVariable int id){
        APIResponse apiResponse = APIResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Pokemon " + id + ":")
                .data(pokemonService.getPokemonById(id))
                .build();
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    /*update pokemon by id*/
    @PutMapping("/update/{id}")
    public ResponseEntity<APIResponse> updatePokemonById(@RequestBody Pokemon pokemon, @PathVariable int id){
        pokemonService.updatePokemon(pokemon,id);
        APIResponse apiResponse = APIResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Pokemon " + id + " update success!!!")
                .build();
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    /*delete pokemon by id*/
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<APIResponse> deletePokemonById(@PathVariable int id){
        pokemonService.deletePokemonId(id);
        APIResponse apiResponse = APIResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Pokemon " + id + " delete success!!!")
                .build();
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }
}
