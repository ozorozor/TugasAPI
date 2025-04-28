package com.example.tugasapi.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tugasapi.R;
import com.example.tugasapi.model.Team;
import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {

    private List<Team> teamList;

    public TeamAdapter(List<Team> teamList) {
        this.teamList = teamList;
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_team, parent, false); // Inflate layout item_team.xml
        return new TeamViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        Team team = teamList.get(position);
        holder.teamNameTextView.setText(team.getStrTeam());

        Glide.with(holder.itemView.getContext())
                .load(team.getStrTeamBadge()) // Load URL gambar
                .apply(new RequestOptions().placeholder(R.drawable.ic_launcher_foreground)) // Placeholder jika gambar gagal dimuat
                .into(holder.teamBadgeImageView); // Tampilkan gambar di ImageView
    }

    @Override
    public int getItemCount() {
        return teamList.size(); // Mengembalikan jumlah item dalam daftar
    }

    public static class TeamViewHolder extends RecyclerView.ViewHolder {
        public TextView teamNameTextView;
        public ImageView teamBadgeImageView;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            teamNameTextView = itemView.findViewById(R.id.textViewTeamName); // Inisialisasi TextView
            teamBadgeImageView = itemView.findViewById(R.id.imageViewTeamBadge); // Inisialisasi ImageView
        }
    }

    // Metode untuk memperbarui data di adapter
    public void setTeams(List<Team> teams) {
        this.teamList = teams;
        notifyDataSetChanged(); // Memberi tahu RecyclerView bahwa dataset telah berubah
    }
}