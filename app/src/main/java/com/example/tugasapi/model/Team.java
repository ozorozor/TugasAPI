package com.example.tugasapi.model;

import com.google.gson.annotations.SerializedName;

public class Team {
    @SerializedName("idTeam")
    private String idTeam;
    @SerializedName("strTeam")
    private String strTeam;
    @SerializedName("strBadge")
    private String strBadge;

    public String getIdTeam() {
        return idTeam;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public String getStrTeamBadge() {
        return strBadge;
    }

    public static class TeamsResponse {
    }
}