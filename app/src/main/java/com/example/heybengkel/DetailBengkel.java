package com.example.heybengkel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class DetailBengkel extends Activity {

    TextView vnama, valamat, vkontak;
    Button arah_bengkel;
    String nama, alamat, kontak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_bengkel);

        vnama = findViewById(R.id.vnama);
        valamat = findViewById(R.id.valamat);
        vkontak = findViewById(R.id.vkontak);

        nama = getIntent().getStringExtra("nama");
        alamat = getIntent().getStringExtra("alamat");
        kontak = getIntent().getStringExtra("kontak");

        vnama.setText(nama);
        valamat.setText(alamat);
        vkontak.setText(kontak);

        arah_bengkel = findViewById(R.id.arah_bengkel);
        arah_bengkel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DetailBengkel.this, MapsActivity.class);
                startActivity(i);
            }
        });

    }
}
