package com.example.project8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText nimsiswa, namasiswa;
    Button btnSave, btnView;
    DatabaseReference refrence;
    Mahasiswa mahasiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nimsiswa=findViewById(R.id.nimmhs);
        namasiswa=findViewById(R.id.nmmhs);
        btnSave=findViewById(R.id.tombolSave);
        btnView=findViewById(R.id.tombolView);
        mahasiswa=new Mahasiswa();

        refrence= FirebaseDatabase.getInstance().getReference().child("Siswa");

        btnSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mahasiswa.setNim(nimsiswa.getText().toString().trim());
                mahasiswa.setNama(namasiswa.getText().toString().trim());
                refrence.push().setValue(mahasiswa);
                Toast.makeText(MainActivity.this, "Data Tersimpan", Toast.LENGTH_LONG).show();
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TampilSemuaData.class);
                startActivity(intent);
            }
        });
    }
}