package com.example.parkngapplcaton;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;

public class SeeFragment extends Fragment {
    RecyclerView recyclerView;
    public static MyAdapter adapter;
    private DatabaseReference mDatabaseRef;

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
        adapter = new MyAdapter(view.getContext(),MainActivity.vehicleList,mDatabaseRef);
        recyclerView.setAdapter(adapter);
    }
}
