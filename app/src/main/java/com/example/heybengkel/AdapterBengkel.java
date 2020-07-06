package com.example.heybengkel;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class AdapterBengkel extends RecyclerView.Adapter<AdapterBengkel.MyViewHolder> {

    Context context;
    ArrayList<Bengkel> bengkel;

    public AdapterBengkel(Context c , ArrayList<Bengkel> b) {
        context = c;
        bengkel = b;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_bengkel, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.vnama.setText(bengkel.get(position).getNama());
        holder.valamat.setText(bengkel.get(position).getAlamat());
        holder.vkontak.setText(bengkel.get(position).getKontak());

        holder.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail = new Intent(context.getApplicationContext(),
                        DetailBengkel.class);
                detail.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                detail.putExtra("nama", bengkel.get(position).getNama());
                detail.putExtra("alamat", bengkel.get(position).getAlamat());
                detail.putExtra("kontak", bengkel.get(position).getKontak());

                context.startActivity(detail);

            }
        });
    }

    @Override
    public int getItemCount() {
        return bengkel.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView vnama,valamat,vkontak;
        ImageView detail;

        public MyViewHolder(View itemView) {
            super(itemView);
            vnama = itemView.findViewById(R.id.vnama);
            valamat = itemView.findViewById(R.id.valamat);
            vkontak = itemView.findViewById(R.id.vkontak);
            detail = itemView.findViewById(R.id.detail);
        }

    }

}
