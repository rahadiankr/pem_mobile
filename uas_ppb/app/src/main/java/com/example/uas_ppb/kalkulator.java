package com.example.uas_ppb;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class kalkulator extends AppCompatActivity {

    EditText angk1, angk2;
    TextView hasilnya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator);

        angk1 = (EditText) findViewById(R.id.angka1);
        angk2 = (EditText) findViewById(R.id.angka2);
        hasilnya = (TextView) findViewById(R.id.hasil);
    }

    public void tambah(View view) {
        int a1 = Integer.parseInt(angk1.getText().toString());
        int a2 = Integer.parseInt(angk2.getText().toString());
        Integer hasil= a1+a2;
        hasilnya.setText(hasil.toString());
    }

    public void kurang(View view) {
        int a1 = Integer.parseInt(angk1.getText().toString());
        int a2 = Integer.parseInt(angk2.getText().toString());
        Integer hasil= a1-a2;
        hasilnya.setText(hasil.toString());
    }

    public void kali(View view) {
        int a1 = Integer.parseInt(angk1.getText().toString());
        int a2 = Integer.parseInt(angk2.getText().toString());
        Integer hasil= a1*a2;
        hasilnya.setText(hasil.toString());
    }

    public void bagi(View view) {
        Double a1=Double.parseDouble(angk1.getText().toString());
        Double a2=Double.parseDouble(angk2.getText().toString());
        Double hasil=a1/a2;
        hasilnya.setText(hasil.toString());
    }
}