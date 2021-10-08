package com.rahadiandev.tugas03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText input1, input2;
    TextView hasilhitung;
    Button btnTambah,btnKurang,btnKali,btnBagi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1=(EditText)findViewById(R.id.input1);
        input2=(EditText)findViewById(R.id.input2);
        hasilhitung=(TextView)findViewById(R.id.ouput);
        btnTambah=(Button)findViewById(R.id.btnTambah);
        btnKurang=(Button)findViewById(R.id.btnKurang);
        btnKali=(Button)findViewById(R.id.btnKali);
        btnBagi=(Button)findViewById(R.id.btnBagi);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a1= Integer.parseInt(input1.getText().toString());
                int a2= Integer.parseInt(input2.getText().toString());
                Integer hasil=a1+a2;
                hasilhitung.setText(hasil.toString());
            }
        });
        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a1= Integer.parseInt(input1.getText().toString());
                int a2= Integer.parseInt(input2.getText().toString());
                Integer hasil=a1-a2;
                hasilhitung.setText(hasil.toString());
            }
        });
        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a1= Integer.parseInt(input1.getText().toString());
                int a2= Integer.parseInt(input2.getText().toString());
                Integer hasil=a1*a2;
                hasilhitung.setText(hasil.toString());
            }
        });
        btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float a1= Integer.parseInt(input1.getText().toString());
                float a2= Integer.parseInt(input2.getText().toString());
                if (a2==0){
                    hasilhitung.setText("Tak Terdefinisi");
                }
                else {
                    float hasil=a1/a2;
                    hasilhitung.setText(Float.toString(hasil));
                }
            }
        });
    }

}