package com.example.heybengkel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CardView btn_pencarian, btn_tips, btn_keluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_pencarian = findViewById(R.id.btn_pencarian);
        btn_pencarian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, FormActivity.class);
                startActivity(i);
            }
        });

        btn_tips = findViewById(R.id.btn_tips);
        btn_tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, TipsActivity.class);
                startActivity(i);
            }
        });

        btn_keluar = findViewById(R.id.btn_keluar);
        btn_keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
                finish();
                System.exit(0);
            }
        });

    }
}
