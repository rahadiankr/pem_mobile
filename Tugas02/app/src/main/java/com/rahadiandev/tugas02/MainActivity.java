package com.rahadiandev.tugas02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView angkaKounter;
    int angka= 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        angkaKounter=findViewById(R.id.kounter);
    }

    public void toastklik(View view) {
        Toast.makeText(this, "ini adalah toast", Toast.LENGTH_LONG).show();
    }

    public void tblkounter(View view) {
        angka=angka+1;
        angkaKounter.setText(Integer.toString(angka));
    }

    public void tblkountermin(View view) {
        angka=angka-1;
        angkaKounter.setText(Integer.toString(angka));
    }

    public void tblrest(View view) {
        angka=0;
        angkaKounter.setText(Integer.toString(angka));
    }
}