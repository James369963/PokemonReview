package com.example.PokemonReview.service;

import com.example.PokemonReview.entity.Review;

import java.util.List;

public interface ReviewService {
    void createReview(int pokemonId, Review reviewDto);
    List<Review> getReviewsByPokemonId(int id);
    Review getReviewById(int reviewId, int pokemonId);
    void updateReview(int pokemonId, int reviewId, Review review);
    void deleteReview(int pokemonId, int reviewId);
}
