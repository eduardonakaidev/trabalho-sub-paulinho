package com.example.trabalho_sub_paulinho.service;

import com.example.trabalho_sub_paulinho.dto.PaisDTO;
import com.example.trabalho_sub_paulinho.response.PaisesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IPaisService {
    @GET("paises")
    Call<PaisesResponse> getAllPaises();
}
