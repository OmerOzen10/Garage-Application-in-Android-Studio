package com.example.parkngapplcaton;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.sql.Date;
import java.sql.Time;
import java.util.Locale;

public class AddFragment extends Fragment {

    TextInputLayout layoutModel,layoutPlaque,layoutEntered,layoutDuration;

    TextInputEditText edtModel,edtPlaque,edtEntered,edtDuration;

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

        Correction();
    }

    public boolean Correction(){
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
        Time();
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
        return true;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add,container,false);


    }

    public void Time(){
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
    }
}
