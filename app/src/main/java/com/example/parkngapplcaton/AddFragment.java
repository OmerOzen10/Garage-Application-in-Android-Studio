package com.example.parkngapplcaton;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
import java.util.Locale;
import java.util.Objects;

public class AddFragment extends Fragment {

    TextInputLayout layoutModel,layoutPlaque,layoutEntered,layoutDuration;

    TextInputEditText edtModel,edtPlaque,edtEntered,edtDuration;

    Spinner vehicleType;

    Button addButton;

    DatabaseReference databaseReference;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        layoutModel = view.findViewById(R.id.layoutModel);
        layoutPlaque = view.findViewById(R.id.layoutPlaque);
        edtModel = view.findViewById(R.id.edtModel);
        edtPlaque = view.findViewById(R.id.edtPlaque);
        layoutEntered = view.findViewById(R.id.layoutEntered);
        edtEntered = view.findViewById(R.id.edtEntered);
        layoutDuration = view.findViewById(R.id.layoutDuration);
        edtDuration = view.findViewById(R.id.edtDuration);

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
                    layoutModel.setError("Required");
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
                        }else {
                            layoutPlaque.setError("The plaque cannot contains lowercase letter");
                        }

                    }else {

                        layoutPlaque.setError("The plaque must be at least 7 characters");

                    }

                }else {

                    layoutPlaque.setError("Required");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        edtEntered.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String entryTime = charSequence.toString();
                if (!entryTime.isEmpty()){
                    layoutEntered.setError("");

                    if (entryTime.length() == 5){
                        layoutEntered.setError("");
                        if (Character.isDigit(entryTime.charAt(0))){
                            layoutEntered.setError("");
                            if (Character.isDigit(entryTime.charAt(1))){
                                layoutEntered.setError("");
                                if (Character.isDigit(entryTime.charAt(3))){
                                    layoutEntered.setError("");
                                    if (Character.isDigit(entryTime.charAt(4))){
                                        layoutEntered.setError("");

                                        if (entryTime.charAt(2)==':'){
                                            layoutEntered.setError("");

                                            String[] parts = entryTime.split(":");
                                            int hours = Integer.parseInt(parts[0]);
                                            int minutes = Integer.parseInt(parts[1]);
                                            if (hours<24){
                                                layoutEntered.setError("");
                                                if (minutes<60){
                                                    layoutEntered.setError("");
                                                }else {
                                                    layoutEntered.setError("Invalid Time!");

                                                }

                                            }else {
                                                layoutEntered.setError("Invalid Time!");

                                            }

                                        }else {
                                            layoutEntered.setError("Invalid Time!");
                                        }

                                    }else {
                                        layoutEntered.setError("Invalid Time!");
                                    }

                                }else {
                                    layoutEntered.setError("Invalid Time!");
                                }

                            }else {
                                layoutEntered.setError("Invalid Time!");
                            }
                        }else {
                            layoutEntered.setError("Invalid Time!");
                        }
                    }else {
                        layoutEntered.setError("Invalid Time!");
                    }

                }else {
                    layoutEntered.setError("Required");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        edtDuration.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                String duration = charSequence.toString();

                if (!duration.isEmpty()) {
                    layoutDuration.setError("");
                    if (duration.length() == 2){
                        layoutDuration.setError("");

                        if (Character.isDigit(duration.charAt(0))){
                            layoutDuration.setError("");

                            if (Character.isDigit(duration.charAt(1))){
                                layoutDuration.setError("");

                                if (Integer.parseInt(duration)<25){
                                    layoutDuration.setError("");
                                }else {
                                    layoutDuration.setError("Max 1 Day!");
                                }

                            }else {
                                layoutDuration.setError("ex: XX");
                            }

                        }else {
                            layoutDuration.setError("ex: XX");
                        }

                    }else {

                        layoutDuration.setError("ex: XX");
                    }


                }else {
                    layoutDuration.setError("Required");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        addButton.setOnClickListener(view1 -> {

            if (Correction()){
                InsertData();

            }else {
                Toast.makeText(view.getContext(), "Something Wrong!!", Toast.LENGTH_SHORT).show();
            }

        });




    }

    private boolean Correction(){
        if (edtModel.getText().toString().isEmpty()){
            edtModel.requestFocus();
            return false;
        }
        if (edtPlaque.getText().toString().isEmpty()){
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

        if (edtEntered.getText().toString().isEmpty()){
            edtEntered.requestFocus();
            return false;
        }

        if (edtEntered.length()!=5){
            edtEntered.requestFocus();
            return false;
        }

        if (!Character.isDigit(edtEntered.getText().charAt(0))){
            edtEntered.requestFocus();
            return false;
        }
        if (!Character.isDigit(edtEntered.getText().charAt(1))){
            edtEntered.requestFocus();
            return false;
        }
        if (!Character.isDigit(edtEntered.getText().charAt(3))){
            edtEntered.requestFocus();
            return false;
        }
        if (!Character.isDigit(edtEntered.getText().charAt(4))){
            edtEntered.requestFocus();
            return false;
        }
        if (edtEntered.getText().charAt(2) !=':'){
            edtEntered.requestFocus();
            return false;
        }
        String enteredTime = edtEntered.getText().toString();
        String[] parts = enteredTime.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        if (hours >= 24) {
            edtEntered.requestFocus();
            return false;
        }
        if (minutes >= 60) {
            edtEntered.requestFocus();
            return false;
        }

        if (edtDuration.getText().toString().isEmpty()){
            edtDuration.requestFocus();
            return false;
        }
        if (edtDuration.length()!=2){
            edtDuration.requestFocus();
            return false;
        }
        if (!Character.isDigit(edtDuration.getText().charAt(0))){
            edtDuration.requestFocus();
            return false;
        }
        if (!Character.isDigit(edtDuration.getText().charAt(1))){
            edtDuration.requestFocus();
            return false;
        }

        if (Integer.parseInt(edtDuration.getText().toString())>24) {
            edtDuration.requestFocus();
            return false;
        }
        return true;

        }

    private void InsertData() {

        String modelName = Objects.requireNonNull(edtModel.getText()).toString();
        String plaque = Objects.requireNonNull(edtPlaque.getText()).toString();
        String time = Objects.requireNonNull(edtEntered.getText()).toString();
        String duration = Objects.requireNonNull(edtDuration.getText()).toString();
        String vehicle = vehicleType.getSelectedItem().toString();
        int id = MainActivity.vehicleList.size()+1;

        Vehicles vehicles = new Vehicles(modelName,plaque,time,duration,vehicle,id);



            databaseReference.child("vehicles").child(String.valueOf(id)).setValue(vehicles)
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
