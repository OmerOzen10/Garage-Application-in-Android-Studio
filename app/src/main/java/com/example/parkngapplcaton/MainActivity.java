package com.example.parkngapplcaton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Vehicles> vehicleList;
    public static final String TAG = "MainActivity";

    public static DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new InfoFragment()).addToBackStack(null).commit();

        vehicleList = new ArrayList<>();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnItemSelectedListener(navListener);

        databaseReference = FirebaseDatabase.getInstance().getReference("vehicles");
        readData();
    }

    private void readData() {

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                vehicleList.clear();
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Vehicles vehicles = dataSnapshot.getValue(Vehicles.class);
                    vehicleList.add(vehicles);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Log.w(TAG, "loadPost:onCancelled ", error.toException());

            }
        };
        databaseReference.addValueEventListener(postListener);

    }

    private NavigationBarView.OnItemSelectedListener navListener =

            new NavigationBarView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case    R.id.nav_info:
                            selectedFragment = new InfoFragment();
                            break;
                        case R.id.nav_add:
                            selectedFragment = new AddFragment();
                            break;
                        case R.id.nav_see:
                            selectedFragment = new SeeFragment(databaseReference);
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,selectedFragment).addToBackStack(null).commit();
                    return true;
                }
            };
}