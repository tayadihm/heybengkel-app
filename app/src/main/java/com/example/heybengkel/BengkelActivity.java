package com.example.heybengkel;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bengkel);

        recyclerView = findViewById(R.id.list_bengkel);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        list = new ArrayList<Bengkel>();

        reference = FirebaseDatabase.getInstance().getReference().child("bengkel");
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
}