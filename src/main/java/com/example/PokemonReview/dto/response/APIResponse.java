package com.example.PokemonReview.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse {
    private int statusCode;
    private String message;
    private Object data;
}
