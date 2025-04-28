package com.example.tugasapi.network;

import com.example.tugasapi.model.TeamsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("search_all_teams.php") // Endpoint API yang akan dipanggil
    Call<TeamsResponse> getAllTeams(@Query("l") String league); // Parameter query untuk liga
}