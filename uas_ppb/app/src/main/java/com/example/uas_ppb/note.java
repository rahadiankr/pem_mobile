package com.example.uas_ppb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class note extends AppCompatActivity {

    private EditText createtitlenote, createcontentnote;
    private FloatingActionButton savenote;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseFirestore firebaseFirestore;

    FloatingActionButton btnkal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note2);

        savenote=findViewById(R.id.savenote);
        createcontentnote=findViewById(R.id.createcontentnote);
        createtitlenote=findViewById(R.id.createtitlenote);
        btnkal=findViewById(R.id.kalku);

        Toolbar toolbar=findViewById(R.id.toolbarcreatenote);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();
        firebaseUser=FirebaseAuth.getInstance().getCurrentUser();

        savenote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=createtitlenote.getText().toString();
                String content=createcontentnote.getText().toString();
                if (title.isEmpty()||content.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Catatan masih kosong", Toast.LENGTH_SHORT).show();
                }
                else {
                    DocumentReference documentReference=firebaseFirestore.collection("notes").document(firebaseUser.getUid()).collection("Catatanku").document();
                    Map<String, Object> note= new HashMap<>();
                    note.put("title",title);
                    note.put("content",content);

                    documentReference.set(note).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(getApplicationContext(), "Catatan berhasil dibuat", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(note.this,noteActivity.class));

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), "Gagal membuat catatan", Toast.LENGTH_SHORT).show();
                            //startActivity(new Intent(note.this,noteActivity.class));
                        }
                    });



                }
            }

        });

    }




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==android.R.id.home)
        {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}