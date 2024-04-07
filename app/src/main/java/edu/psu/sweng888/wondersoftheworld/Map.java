package edu.psu.sweng888.wondersoftheworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class Map extends FragmentActivity implements View.OnClickListener, OnMapReadyCallback {
    // declare class variables
    private GoogleMap map;
    private TextView textViewOption1, textViewOption2;
    private FloatingActionButton fab;
    private BottomNavigationView navBar;

    public Map() {
        // required empty constructor
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity);

        // initialize class variables
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);

        // instantiate UI elements
        instantiateUIElements();

        // initialize navBar
        navBar = findViewById(R.id.nav_bar);

        // set Map selected
        navBar.setSelectedItemId(R.id.map_nav_button);

        // onItemSelectedListener
        navBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.map_nav_button) {
                    startActivity(new Intent(getApplicationContext(),Map.class));
                    overridePendingTransition(0,0);
                    return true;
                } else if (item.getItemId() == R.id.list_nav_button) {
                    startActivity(new Intent(getApplicationContext(),Details.class));
                    overridePendingTransition(0,0);
                    return true;
                }
                return false;
            }
        });
    }

    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;

        // enable Zoom controls
        map.getUiSettings().setZoomControlsEnabled(true);
        map.setPadding(0, 0, 0, 125);
    }

    private void instantiateUIElements() {
        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showOptionsMenu();
            }
        });

        textViewOption1 = findViewById(R.id.show_markers);
        textViewOption2 = findViewById(R.id.hide_markers);

        textViewOption1.setOnClickListener(this);
        textViewOption2.setOnClickListener(this);
    }

    private void showOptionsMenu() {
        ConstraintLayout optionsMenu = findViewById(R.id.options_menu);
        if (optionsMenu.getVisibility() == View.VISIBLE) {
            // hide the options menu
            optionsMenu.setVisibility(View.GONE);
        } else {
            // show the options menu
            optionsMenu.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.show_markers) {
            markWonders();
        } else if (v.getId() == R.id.hide_markers) {
            map.clear();
        }
    }

    private void markWonders() {
        // 7 Wonders of the World
        String greatWall = "Great Wall Of China, China";
        String tajMahal = "Taj Mahal, India";
        String petra = "Petra, Jordan";
        String colosseum = "Colosseum, Italy";
        String christRedeemer = "Christ the Redeemer, Brazil";
        String itza = "Chichen Itza, Mexico";
        String machuPicchu = "Mach Picchu, Peru";

        // Represent location using LatLng
        //  * positive values indicate North/East
        //  * negative values indicate South/West
        LatLng wonderOne = new LatLng(40.4319, 116.5704);
        LatLng wonderTwo = new LatLng(27.1751, 78.0421);
        LatLng wonderThree = new LatLng(30.3285, 35.4444);
        LatLng wonderFour = new LatLng(41.8902, 12.4922);
        LatLng wonderFive = new LatLng(-22.9519, -43.2105);
        LatLng wonderSix = new LatLng(20.6843, -88.5678);
        LatLng wonderSeven = new LatLng(-13.1632, -72.5453);

        // Add markers to the map
        addMarker(greatWall, wonderOne);
        addMarker(tajMahal, wonderTwo);
        addMarker(petra, wonderThree);
        addMarker(colosseum, wonderFour);
        addMarker(christRedeemer, wonderFive);
        addMarker(itza, wonderSix);
        addMarker(machuPicchu, wonderSeven);
    }

    private void addMarker(String location, LatLng coordinates) {
        map.addMarker(new MarkerOptions().position(coordinates).title(location));
    }
}