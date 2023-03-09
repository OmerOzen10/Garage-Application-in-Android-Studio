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

        Query query = mDatabaseRef.orderByChild("premium").equalTo(true);

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                MainActivity.vehicleListPremium.clear();
                for (DataSnapshot snapshot1 : snapshot.getChildren()){
                    Vehicles vehicles1 = snapshot1.getValue(Vehicles.class);
                    if (vehicles1 != null){
                        MainActivity.vehicleListPremium.add(vehicles1);
                    }
                }
                Log.d(TAG, "onDataChange: premium" + MainActivity.vehicleListPremium.size());

                for (int i = 0; i < MainActivity.vehicleListPremium.size(); i++){
                    long currentTime = System.currentTimeMillis();
                    long endTime = MainActivity.vehicleListPremium.get(i).getDuration();
                    Log.d(TAG, "onDataChange: currentTime " + currentTime);

                    Log.d(TAG, "onDataChange: endTime" + endTime);
                    long duration = TimeUnit.MILLISECONDS.toSeconds(endTime - currentTime);

                    Log.d(TAG, "onDataChange: duration " + duration);

                    if (duration <= 0){
                        String key = String.valueOf(MainActivity.vehicleListPremium.get(i).getId());
                        mDatabaseRef.child(key).removeValue();
                        int index = MainActivity.vehicleList.indexOf(MainActivity.vehicleListPremium.get(i));
                        if (index != -1){
                            MainActivity.vehicleList.remove(index);
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}
