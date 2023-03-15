package com.example.parkngapplcaton;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeeFragment extends Fragment {
    RecyclerView recyclerView;
    public static MyAdapter adapter;
    SearchView search;
    private DatabaseReference mDatabaseRef;
    public  final static String TAG = "SeeFragment";



    public SeeFragment(DatabaseReference databaseRef) {
        mDatabaseRef = databaseRef;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_see,container,false);



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recView);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new MyAdapter(view.getContext(),MainActivity.vehicleList,mDatabaseRef,MainActivity.filteredVehicles);
        recyclerView.setAdapter(adapter);
        search = view.findViewById(R.id.search);

        
        
        ConstraintLayout constraintLayout = view.findViewById(R.id.mainLayout);

        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();
        

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.isEmpty()){
                    resetList();
                }else {
                    filterList(newText);
                }
                return false;
            }
        });



    }

    private void filterList(String text) {
        ArrayList<Vehicles> filteredList = new ArrayList<>();
        for (Vehicles vehicles : adapter.vehiclesList){
            if (vehicles.getPlaque().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(vehicles);
            }
        }
        if (filteredList.isEmpty()){

            Toast.makeText(getContext(), "No data found", Toast.LENGTH_SHORT).show();

        }else {
            adapter.setFilteredList(filteredList);

        }
    }

    private void resetList() {
        adapter.setFilteredList(MainActivity.vehicleList);
    }


}

