package com.example.parkngapplcaton;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;




public class AddFragment extends Fragment {

    TextInputLayout layoutModel,layoutPlaque;

    TextInputEditText edtModel,edtPlaque;

    Spinner vehicleType,chooseRegis;

    Button addButton;





    public  final static String TAG = "AddFragment";

    TextView textView1;

    DatabaseReference databaseReference;




    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        layoutModel = view.findViewById(R.id.layoutModel);
        layoutPlaque = view.findViewById(R.id.layoutPlaque);
        edtModel = view.findViewById(R.id.edtModel);
        edtPlaque = view.findViewById(R.id.edtPlaque);
        vehicleType = view.findViewById(R.id.vehicleType);
        addButton = view.findViewById(R.id.addButton);
        textView1 = view.findViewById(R.id.textView1);






//        textView1.setText("The capacity is: " + (250 - (MainActivity.vehicleList.size())));




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

        if (MainActivity.vehicleList.size()<3){
            textView1.setText("Capacity: " + (3-(MainActivity.vehicleList.size())));
            textView1.setTextColor(Color.GREEN);
        }
        if (MainActivity.vehicleList.size()==3){
            textView1.setText("The Garage is full");
            textView1.setTextColor(Color.RED);
        }


        addButton.setOnClickListener(view1 -> {

            if (Correction()){
                if (MainActivity.vehicleList.size()<3){
                    InsertData();
                    textView1.setText("Capacity: " + (3-(MainActivity.vehicleList.size())-1) );
                    textView1.setTextColor(Color.GREEN);

                    if (MainActivity.vehicleList.size()==2){
                        textView1.setText("The Garage is full");
                        textView1.setTextColor(Color.RED);
                    }

                }




//                    textView1.setText(String.valueOf(MainActivity.vehicleList.size()+1));

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

        String modelName = Objects.requireNonNull(edtModel.getText()).toString();
        String plaque = Objects.requireNonNull(edtPlaque.getText()).toString();
        String vehicle = vehicleType.getSelectedItem().toString();
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        String id = edtPlaque.getText().toString();











        Vehicles vehicles = new Vehicles(modelName,plaque,vehicle,id,date);





            databaseReference.child("vehicles").child((id)).setValue(vehicles)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(requireContext(), "Added Successfully!", Toast.LENGTH_SHORT).show();

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
