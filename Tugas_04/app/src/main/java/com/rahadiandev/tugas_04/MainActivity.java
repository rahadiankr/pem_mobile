package com.rahadiandev.tugas_04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    public String menu_film[]={"Squid Game", "Move to Heaven", "Shadow and Bone", "Jupiter's Legacy", "Sweet Tooth", "The Chair", "Nevertheless", "Afterlife of the Party", "Sweet Girl", "Memories of A Murderer: The Nilsen Tapes"};

    Spinner combo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView) findViewById(R.id.listdata);
        combo=(Spinner) findViewById(R.id.combodata);

        ArrayAdapter adapter=new ArrayAdapter(MainActivity.this, R.layout.support_simple_spinner_dropdown_item,menu_film);
        listView.setAdapter(adapter);
        combo.setAdapter(adapter);
    }
}