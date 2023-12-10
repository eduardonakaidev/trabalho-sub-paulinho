package com.example.trabalho_sub_paulinho.controller;

import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.trabalho_sub_paulinho.dto.PaisDTO;
import com.example.trabalho_sub_paulinho.response.PaisesResponse;
import com.example.trabalho_sub_paulinho.retrofit.RetrofitConfig;

import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaisController {
    public static void getAllPais( List<PaisDTO> pais){
        try{
            Call<PaisesResponse> call = new RetrofitConfig()
                    .PaisService().getAllPaises();

            call.enqueue(new Callback<PaisesResponse>() {
                @Override
                public void onResponse(Call<PaisesResponse> call, Response<PaisesResponse> response) {
                   PaisesResponse paisDTO = response.body();
                    pais.addAll((Collection<? extends PaisDTO>) paisDTO);
                }

                @Override
                public void onFailure(Call<PaisesResponse> call, Throwable t) {

                }
            });

        }catch (Exception ex){}

    }
}
