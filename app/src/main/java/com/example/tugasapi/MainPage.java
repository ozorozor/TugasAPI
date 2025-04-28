package com.example.tugasapi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnPremierLeague = findViewById(R.id.btnPremierLeague);
        btnPremierLeague.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainPage", "Mengklik tombol English League");
                Intent intent = new Intent(MainPage.this, MainActivity.class);
                intent.putExtra("league", "English Premier League");
                startActivity(intent);
            }
        });

        Button btnSpanish = findViewById(R.id.btnSpanish);
        btnSpanish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("LigaSpanyol", "Mengklik tombol Spanish League");
                Intent intent = new Intent(MainPage.this, LigaSpanyol.class);
                intent.putExtra("league", "Soccer&c=Spain"); // Parameter yang benar untuk API Spanyol
                startActivity(intent);
            }
        });
    }
}