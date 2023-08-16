package com.example.PokemonReview.controller;

import com.example.PokemonReview.dto.response.APIResponse;
import com.example.PokemonReview.entity.Review;
import com.example.PokemonReview.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/create/{pokemonId}")
    public ResponseEntity<APIResponse> createReview(@PathVariable int pokemonId, @RequestBody Review review){
        reviewService.createReview(pokemonId,review);
        APIResponse apiResponse = APIResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Review " + " create success!!!")
                .build();
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    @GetMapping("/pokemon/{pokemonId}/reviews")
    public ResponseEntity<APIResponse> getReviewByPokemonId(@PathVariable int pokemonId){
        APIResponse apiResponse = APIResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Reviews " + "by pokemon "+pokemonId+" success!!!")
                .data(reviewService.getReviewsByPokemonId(pokemonId))
                .build();
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    @GetMapping("/pokemon/{pokemonId}/reviews/{reviewId}")
    public ResponseEntity<APIResponse> getReviewByPokemonId(@PathVariable int reviewId,@PathVariable int pokemonId){
        APIResponse apiResponse = APIResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Reviews "+ reviewId + " by pokemon "+pokemonId+" success!!!")
                .data(reviewService.getReviewById(reviewId,pokemonId))
                .build();
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    @PutMapping("/update/pokemon/{pokemonId}/reviews/{reviewId}")
    public ResponseEntity<APIResponse> updateReviewByPokemonId(@PathVariable int reviewId,@PathVariable int pokemonId, @RequestBody Review review){
        reviewService.updateReview(pokemonId,reviewId,review);
        APIResponse apiResponse = APIResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Update reviews "+ reviewId +" success!!!")
                .build();
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    @DeleteMapping("/delete/pokemon/{pokemonId}/reviews/{reviewId}")
    public ResponseEntity<APIResponse> deleteReviewByPokemonId(@PathVariable int reviewId,@PathVariable int pokemonId){
        reviewService.deleteReview(pokemonId,reviewId);
        APIResponse apiResponse = APIResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Delete reviews "+ reviewId +" success!!!")
                .build();
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }
}
