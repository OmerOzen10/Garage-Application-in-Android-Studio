package com.example.parkngapplcaton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;

public class AddFragment extends Fragment {

    TextInputLayout layoutModel,layoutPlaque;

    TextInputEditText edtModel,edtPlaque;

    Spinner vehicleType;

    Button addButton;

    public  final static String TAG = "AddFragment";

    DatabaseReference databaseReference;



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        layoutModel = view.findViewById(R.id.layoutModel);
        layoutPlaque = view.findViewById(R.id.layoutPlaque);
        edtModel = view.findViewById(R.id.edtModel);
        edtPlaque = view.findViewById(R.id.edtPlaque);
        vehicleType = view.findViewById(R.id.vehicleType);
        addButton = view.findViewById(R.id.addButton);

        databaseReference = FirebaseDatabase.getInstance().getReference();


        edtModel.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String modelName = charSequence.toString();
                if (!modelName.isEmpty()){
                    layoutModel.setError("");
                }else {
                    layoutModel.setError(null);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        edtPlaque.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String plaque = charSequence.toString();
                if (!plaque.isEmpty()){

                    layoutPlaque.setError("");

                    if (plaque.length()>6){

                        layoutPlaque.setError("");

                        if (plaque.contains(plaque.toUpperCase()) && !plaque.contains(plaque.toLowerCase())){
                            layoutPlaque.setError("");
                            if (!plaque.contains(" ")){
                                layoutPlaque.setError("");
                            }else {
                                layoutPlaque.setError("Please enter the plaque without spacing");
                            }
                        }else {
                            layoutPlaque.setError("The plaque cannot contains lowercase letter");
                        }

                    }else {

                        layoutPlaque.setError("The plaque must be at least 7 characters");

                    }

                }else {

                    layoutPlaque.setError(null);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        addButton.setOnClickListener(view1 -> {

            if (Correction()){

                    InsertData();

                    edtPlaque.getText().clear();
                    edtModel.getText().clear();


            }else {
                Toast.makeText(view.getContext(), "Something Wrong!!", Toast.LENGTH_SHORT).show();
            }

        });




    }

    private boolean Correction(){

       if (edtPlaque.getText().toString().contains(" ")){
           edtPlaque.requestFocus();
           return false;
       }

        if (edtModel.getText().toString().isEmpty()){
            layoutModel.setError("Required");
            edtModel.requestFocus();
            return false;
        }
        if (edtPlaque.getText().toString().isEmpty()){
            layoutPlaque.setError("Required");
            edtPlaque.requestFocus();
            return false;
        }
        if (edtPlaque.length()<7){
            edtPlaque.requestFocus();
            return false;
        }
        if (edtPlaque.getText().toString().contains(edtPlaque.getText().toString().toLowerCase())){
            edtPlaque.requestFocus();
            return false;
        }
        return true;

        }

    private void InsertData() {
        Calendar calendar = Calendar.getInstance();
        int hourEntered = calendar.get(Calendar.HOUR_OF_DAY);
        int minuteEntered = calendar.get(Calendar.MINUTE);

        int minFormat = (hourEntered * 60) + minuteEntered;

//        double Price;
//
//        switch (vehicleType.getSelectedItem().toString()){
//            case "Car" : Price = 0.2;break;
//
//        }



        String modelName = Objects.requireNonNull(edtModel.getText()).toString();
        String plaque = Objects.requireNonNull(edtPlaque.getText()).toString();
        @SuppressLint("DefaultLocale") String time = String.format("%d:%02d", hourEntered, minuteEntered);
        String vehicle = vehicleType.getSelectedItem().toString();
        String id =edtPlaque.getText().toString();

        Vehicles vehicles = new Vehicles(modelName,plaque,time,vehicle,id,minFormat);



            databaseReference.child("vehicles").child((id)).setValue(vehicles)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getView().getContext(), "Added Successfully!", Toast.LENGTH_SHORT).show();
                            }


                        }
                    });




    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add,container,false);





    }
}
