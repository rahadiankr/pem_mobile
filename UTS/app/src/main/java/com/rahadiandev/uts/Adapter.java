package com.rahadiandev.uts;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    String data1[], data2[], data3[], data4[];
    int gambar[];
    Context context;

    public Adapter(Context ct, String[] s1, String[] s2, String[] s3, String[] s4, int[] img){
        context = ct;
        data1 = s1;
        data2 = s2;
        data3 = s3;
        data4 = s4;
        gambar = img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.daftar_menu.setText(data1[position]);
        holder.deskripsi.setText(data2[position]);
        holder.harga.setText(data3[position]);
        holder.gambar_makanan.setImageResource(gambar[position]);
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("data1", data1[position]);
                intent.putExtra("data2", data2[position]);
                intent.putExtra("data3", data3[position]);
                intent.putExtra("data4", data4[position]);
                intent.putExtra("gambar", gambar[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {return gambar.length;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView daftar_menu, deskripsi, harga, deskripsi_pjg, rating;
        ImageView gambar_makanan;
        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            daftar_menu = itemView.findViewById(R.id.daftar_menu);
            deskripsi = itemView.findViewById(R.id.deskripsi);
            harga = itemView.findViewById(R.id.harga);
            deskripsi_pjg = itemView.findViewById(R.id.deskripsi_pjg);
            gambar_makanan = itemView.findViewById(R.id.gambar_makanan);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
