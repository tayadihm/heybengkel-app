package com.example.heybengkel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BengkelActivity extends AppCompatActivity {

    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<Bengkel> list;
    AdapterBengkel adapter;
    ImageView icon_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bengkel);

        reference = FirebaseDatabase.getInstance().getReference().child("bengkel");
        reference.keepSynced(true);

        recyclerView = findViewById(R.id.list_bengkel);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        list = new ArrayList<Bengkel>();
        setupToolbar();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Bengkel b = dataSnapshot1.getValue(Bengkel.class);
                    list.add(b);
                }
                adapter = new AdapterBengkel(BengkelActivity.this, list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(BengkelActivity.this, "Oops Something went Wrong", Toast.LENGTH_SHORT).show();
            }

        });
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

}