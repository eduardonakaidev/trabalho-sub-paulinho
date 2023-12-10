package com.example.trabalho_sub_paulinho.retrofit;


import com.example.trabalho_sub_paulinho.service.IPaisService;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
public class RetrofitConfig {
    private Retrofit retrofit;
    private static final String BASE_URL = "https://falabr.cgu.gov.br/api/";

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

    }

    public IPaisService PaisService(){
        return this.retrofit.create(IPaisService.class);
    }
}
