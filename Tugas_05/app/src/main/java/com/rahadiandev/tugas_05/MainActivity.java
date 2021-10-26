package com.rahadiandev.tugas_05;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    BantuDataBase bd;
    public static ListView listView;
    public static EditText editText;
    Button tmbTambah;

    ArrayAdapter adapter;
    ArrayList<String> listviewku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listbuah);
        editText = findViewById(R.id.databuah);
        tmbTambah = findViewById(R.id.tbladd);
        bd = new BantuDataBase(this);


        listviewku = new ArrayList<>();
        tampilList();

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                final String noid = listviewku.get(position);
                final String nomor = noid.substring(0,2);
                //editText.setText(nomor.toString());

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Perhatian !")
                        .setMessage("Yakin mau dihapus bang?")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                bd.deleterecord(Integer.parseInt(nomor));
                                listviewku.remove(position);
                                listView.invalidateViews();

                            }
                        })
                        .setNegativeButton("NO",null)
                        .show();
                return false;
            }
        });

        tmbTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bd.tambahData(editText.getText().toString());
                Toast.makeText(MainActivity.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                listviewku.clear();
                tampilList();
            }
        });

    }

    private void tampilList() {
        Cursor cursor = bd.tampilData();
        if (cursor.getCount()==0) {
            Toast.makeText(this, "record kosong", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                listviewku.add(String.valueOf(cursor.getInt(0))+" "+cursor.getString(1));
            }
            adapter= new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,listviewku);
            listView.setAdapter(adapter);
        }
    }
}