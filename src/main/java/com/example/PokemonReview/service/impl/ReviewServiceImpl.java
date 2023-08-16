package com.example.PokemonReview.service.impl;

import com.example.PokemonReview.entity.Pokemon;
import com.example.PokemonReview.entity.Review;
import com.example.PokemonReview.exceptions.PokemonNotFoundException;
import com.example.PokemonReview.exceptions.ReviewNotFoundException;
import com.example.PokemonReview.repository.PokemonRepository;
import com.example.PokemonReview.repository.ReviewRepository;
import com.example.PokemonReview.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private PokemonRepository pokemonRepository;
    @Override
    public void createReview(int pokemonId, Review review) {
        Pokemon pokemon = pokemonRepository.findById(pokemonId).orElseThrow(
                ()-> new PokemonNotFoundException("don't have that pokemon"));
        if (review != null){
            review.setPokemon(pokemon);
            reviewRepository.save(review);
        }
    }

    @Override
    public List<Review> getReviewsByPokemonId(int id) {
        List<Review> reviews = reviewRepository.findByPokemonId(id);
        return reviews.stream().toList();
    }

    @Override
    public Review getReviewById(int reviewId, int pokemonId) {
        Pokemon pokemon = pokemonRepository.findById(pokemonId).orElseThrow(
                ()-> new PokemonNotFoundException("don't have that pokemon"));
        Review review = reviewRepository.findById(reviewId).orElseThrow(
                ()-> new ReviewNotFoundException("don't have that review"));
        if (review.getPokemon().getId() != pokemon.getId()){
            throw new ReviewNotFoundException("This review does not belond to a pokemon");
        }
        else
            return review;
    }

    @Override
    public void updateReview(int pokemonId, int reviewId, Review review) {
        Pokemon pokemon = pokemonRepository.findById(pokemonId).orElseThrow(
                ()-> new PokemonNotFoundException("don't have that pokemon"));
        Review existreview = reviewRepository.findById(reviewId).orElseThrow(
                ()-> new ReviewNotFoundException("don't have that review"));
        if (existreview.getPokemon().getId() != pokemon.getId()){
            throw new ReviewNotFoundException("This review does not belond to a pokemon");
        }
        else{
            existreview.setContent(review.getContent());
            existreview.setTitle(review.getTitle());
            existreview.setStars(review.getStars());

        }
        reviewRepository.save(existreview);
    }

    @Override
    public void deleteReview(int pokemonId, int reviewId) {
        Pokemon pokemon = pokemonRepository.findById(pokemonId).orElseThrow(
                ()-> new PokemonNotFoundException("don't have that pokemon"));
        Review existreview = reviewRepository.findById(reviewId).orElseThrow(
                ()-> new ReviewNotFoundException("don't have that review"));
        if (existreview.getPokemon().getId() != pokemon.getId()){
            throw new ReviewNotFoundException("This review does not belond to a pokemon");
        }
        else{
            reviewRepository.delete(existreview);

        }
    }
}
