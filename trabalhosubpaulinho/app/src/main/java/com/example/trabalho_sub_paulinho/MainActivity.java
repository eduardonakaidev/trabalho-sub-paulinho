package com.example.trabalho_sub_paulinho;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabalho_sub_paulinho.Adapter.PaisAdapter;
import com.example.trabalho_sub_paulinho.dto.PaisDTO;
import com.example.trabalho_sub_paulinho.response.PaisesResponse;
import com.example.trabalho_sub_paulinho.retrofit.RetrofitConfig;
import com.example.trabalho_sub_paulinho.service.IPaisService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    
        IPaisService iPaisService = new RetrofitConfig().PaisService();
        Call<PaisesResponse> call = iPaisService.getAllPaises();
        call.enqueue(new Callback<List<PaisDTO>>() {
            @Override
            public void onResponse(Call<List<PaisDTO>> call, Response<List<PaisDTO>> response) {
                if (response.isSuccessful()) {
                    List<PaisDTO> paises = response.body();
                    //erro desconhecido , não estou conseguindo fazer com q a variavel sera criada local e da um erro de uma aplicação inteira
                    paisAdapter = new PaisAdapter(paises);
                    recyclerView.setAdapter(paisAdapter);
                } else {
                    // falta Tratar erros
                }
            }

            @Override
            public void onFailure(Call<List<PaisDTO>> call, Throwable t) {
                // falta Tratar falhas
            }
        });




      

    }
}