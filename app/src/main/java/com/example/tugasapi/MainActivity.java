package com.example.tugasapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import com.example.tugasapi.adapter.TeamAdapter;
import com.example.tugasapi.model.Team;
import com.example.tugasapi.model.TeamsResponse;
import com.example.tugasapi.network.ApiService;
import com.example.tugasapi.network.RetrofitClient;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TeamAdapter teamAdapter;
    private List<Team> teamList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewTeams);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        teamAdapter = new TeamAdapter(teamList);
        recyclerView.setAdapter(teamAdapter);

        fetchTeams();
    }

    private void fetchTeams() {
        ApiService apiService = RetrofitClient.getApiService();
        Call<TeamsResponse> call = apiService.getAllTeams("English Premier League");

        call.enqueue(new Callback<TeamsResponse>() {
            @Override
            public void onResponse(Call<TeamsResponse> call, Response<TeamsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    TeamsResponse teamsResponse = response.body();
                    List<Team> teams = teamsResponse.getTeams();
                    if (teams != null && !teams.isEmpty()) {
                        teamList.clear();
                        teamList.addAll(teams);
                        teamAdapter.setTeams(teams);
                    } else {
                        Log.d("API_RESPONSE", "List tim kosong");
                    }
                } else {
                    Log.e("API_ERROR", "Gagal mendapatkan data: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<TeamsResponse> call, Throwable t) {
                Log.e("API_ERROR", "Kesalahan jaringan: " + t.getMessage());
            }
        });
    }
}