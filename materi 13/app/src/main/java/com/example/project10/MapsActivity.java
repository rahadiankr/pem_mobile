package com.example.project10;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.project10.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener, OnMapReadyCallback {

    private GoogleMap mMap;
    public static final String nama_pulau[] ={"Pilih Pulau", "Sumatera","Jawa", "Kalimantan", "Sulawesi","Bali", "NTB", "NTT", "Maluku", "Papua"};
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_maps);
    // Obtain the SupportMapFragment and get notified when the map is ready to be used.
    SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    spinner=findViewById (R.id.pilihpulau);
    ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, nama_pulau);
    spinner.setAdapter(adapter);
    spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        double lati,longii;
        switch (position) {
            case 0:
                mMap.clear();
                break;
            case 1:
                mMap.clear();
                LatLng aceh = new LatLng(5.5611009,95.2935971);
                mMap.addMarker(new MarkerOptions().position(aceh).title("Aceh"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(aceh));

                LatLng sumut = new LatLng(3.6422756,98.5290638);
                mMap.addMarker(new MarkerOptions().position(sumut).title("Sumatra Utara"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sumut));

                LatLng sumbar = new LatLng(-0.9345808,100.2508401);
                mMap.addMarker(new MarkerOptions().position(sumbar).title("Sumatra Barat"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sumbar));

                LatLng sumsel = new LatLng(-2.9549663,104.6927524);
                mMap.addMarker(new MarkerOptions().position(sumsel).title("Sumatra Selatan"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sumsel));

                break;
            case 2:

            case 3:
            case 4:
            default:
                Toast.makeText(this, "kosong", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        
    }
}