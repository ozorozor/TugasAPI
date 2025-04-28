package com.example.tugasapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TeamsResponse {
    @SerializedName("teams") // Anotasi ini mencocokkan nama kunci JSON dengan nama field Java
    private List<Team> teams;

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}