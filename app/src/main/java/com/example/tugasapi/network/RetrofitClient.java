package com.example.tugasapi.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "https://www.thesportsdb.com/api/v1/json/3/"; // Base URL API
    private static Retrofit retrofit;

    public static ApiService getApiService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) // Gunakan Gson untuk konversi JSON
                    .build();
        }
        return retrofit.create(ApiService.class); // Membuat implementasi interface ApiService
    }
}