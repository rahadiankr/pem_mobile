package com.example.uas_ppb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class singup extends AppCompatActivity {

    private EditText singupusername, singupemail, singuppassword;
    private Button singup;
    private TextView backlogin;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        getSupportActionBar().hide();

        singupusername=findViewById(R.id.singupusername);
        singupemail=findViewById(R.id.singupemail);
        singuppassword=findViewById(R.id.singuppassword);
        singup=findViewById(R.id.singup);
        backlogin=findViewById(R.id.backlogin);

        firebaseAuth=firebaseAuth.getInstance();

        backlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(singup.this,MainActivity.class);
                startActivity(intent);
            }
        });


        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user=singupusername.getText().toString().trim();
                String mail=singupemail.getText().toString().trim();
                String password=singuppassword.getText().toString().trim();

                if (user.isEmpty() || mail.isEmpty() || password.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Lengkapi data", Toast.LENGTH_SHORT).show();
                }
                else if (password.length()<8){
                    Toast.makeText(getApplicationContext(), "Harus lebih dari 8 karakter", Toast.LENGTH_SHORT).show();
                }

                else {
                    //regis to firebase.

                    firebaseAuth.createUserWithEmailAndPassword( mail , password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getApplicationContext(), "Registrasi Sukses!", Toast.LENGTH_SHORT).show();
                                emailVerivication();
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "Registrasi Gagal!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }

        }

        );
    }

    //Email Verivikasi
    private void emailVerivication(){
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if (firebaseUser!=null){
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Toast.makeText(getApplicationContext(), "Email verivikasi terkirim, silahkan verivikasi dan masuk kembali!", Toast.LENGTH_SHORT).show();
                    firebaseAuth.signOut();
                    finish();
                    startActivity(new Intent(singup.this,MainActivity.class));

                }
            });
        }
        else{
            Toast.makeText(getApplicationContext(), "Terjadi Kesalahan!", Toast.LENGTH_SHORT).show();
        }
    }


}