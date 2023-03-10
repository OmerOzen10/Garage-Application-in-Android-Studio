package com.example.parkngapplcaton;

import android.os.Bundle;
import android.util.Log;
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

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.TimeUnit;

public class SeeFragment extends Fragment {
    RecyclerView recyclerView;
    public static MyAdapter adapter;
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
        adapter = new MyAdapter(view.getContext(),MainActivity.vehicleList,mDatabaseRef);
        recyclerView.setAdapter(adapter);

        mDatabaseRef.orderByChild("premium").equalTo(true).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Vehicles vehicles = snapshot.getValue(Vehicles.class);
                if (vehicles != null) {
                    long currentTime = System.currentTimeMillis();
                    long endTime = vehicles.getDuration();
                    long duration = TimeUnit.MILLISECONDS.toSeconds(endTime - currentTime);
                    Log.d(TAG, "onChildAdded: duration" + duration);
                    if (duration <= 0) {
                        String key = snapshot.getKey();
                        mDatabaseRef.child(key).removeValue();
                    }
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                // handle changed data
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                // handle removed data
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                // handle moved data
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // handle error
            }
        });




    }
}
