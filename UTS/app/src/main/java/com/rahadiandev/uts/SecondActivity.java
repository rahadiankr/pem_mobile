package com.rahadiandev.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.CaseMap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    ImageView gambar_detail;
    TextView judul, deskripsi_pjg;

    String data1, data4;
    int gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        gambar_detail = findViewById(R.id.gambar_detail);
        judul = findViewById(R.id.judul);
        deskripsi_pjg = findViewById(R.id.deskripsi_pjg);

        getData();
        setData();
    }

    private void getData(){
        if (getIntent().hasExtra("gambar") && getIntent().hasExtra("data1") &&
        getIntent().hasExtra("data4")) {

            data1 = getIntent().getStringExtra("data1");
            data4 = getIntent().getStringExtra("data4");
            gambar = getIntent().getIntExtra("gambar", 1);

        }else {
            Toast.makeText(this, "Data Tidak Tersedia", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        judul.setText(data1);
        deskripsi_pjg.setText(data4);
        gambar_detail.setImageResource(gambar);
    }
}