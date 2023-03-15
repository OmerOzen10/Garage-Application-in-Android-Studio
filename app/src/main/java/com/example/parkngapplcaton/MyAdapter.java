package com.example.parkngapplcaton;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{


    Context context;

    // OldNovel was here
    private DatabaseReference mDatabaseRef;

    ArrayList<Vehicles> vehiclesList;

    ArrayList<Vehicles> filteredVehiclesList;


    public  final static String TAG = "MyAdapter";







    public MyAdapter(Context context, ArrayList<Vehicles> vehiclesList, DatabaseReference databaseRef, ArrayList<Vehicles> filteredVehiclesList) {
        this.context = context;
        this.vehiclesList = vehiclesList;
        mDatabaseRef = databaseRef;
        this.filteredVehiclesList = filteredVehiclesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_vehicles,parent,false);
        return new MyViewHolder(v);


    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        Vehicles vehicles = vehiclesList.get(position);
        holder.modelName.setText(vehicles.getModelName());
        holder.plaque.setText(vehicles.getPlaque());
        holder.enteredTime.setText(vehicles.getDate());
        holder.vehicleType.setText(vehicles.getVehicleType());


        if(position%2==0){

            holder.layout.startAnimation(AnimationUtils.loadAnimation(context,R.anim.first_item));
        }else {
            holder.layout.startAnimation(AnimationUtils.loadAnimation(context,R.anim.second_item));
        }







        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LocalDateTime dateExit = LocalDateTime.now();

                String dateEntry = vehiclesList.get(position).date;

                LocalDateTime date1 = LocalDateTime.parse(dateEntry, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                Duration duration = Duration.between(date1,dateExit);
                int totalTime = (int) duration.toMinutes();



                int hours = totalTime / 60;
                int remainingMinutes = totalTime % 60;

                int day = hours / 24;
                int remainingHours = hours % 24;

                String totalDuration = null;

                if (hours>24){

                    totalDuration = "The duration was: " + day + " Day and " + remainingHours + " Hours";

                }
                if (hours<24){

                    totalDuration = "The duration was: " + hours + "." + remainingMinutes + " Hours";

                }


                Car car = new Car();
                Truck truck = new Truck();
                Bus bus = new Bus();
                Taxi taxi = new Taxi();
                Motorcycle motor = new Motorcycle();

                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Delete Vehicle");




                if (holder.vehicleType.getText().toString().equals("Car")){
                    if (totalTime > 0 && totalTime <= 30){
                        builder.setMessage(totalDuration + "\nThe fee is " + car.priceCar1 + " Euro");
                    } else if (totalTime > 30 && totalTime <= 60){
                       builder.setMessage(totalDuration + "\nThe fee is " + car.priceCar2 + " Euro");
                   } else if (totalTime > 60 && totalTime <= 120){
                       builder.setMessage(totalDuration + "\nThe fee is " + car.priceCar3 + " Euro");
                   } else if (totalTime > 120) {
                        int additionalTime = totalTime - 120;
                        double additionalFee = Math.ceil(additionalTime / 30.0) * 0.25;
                        double totalFee = car.priceCar4 + additionalFee;
                        builder.setMessage(totalDuration +"\nThe fee is " + totalFee + " Euro");
                    }
                }


                 if (holder.vehicleType.getText().toString().equals("Truck")) {
                    if (totalTime > 0 && totalTime <=30){
                        builder.setMessage(totalDuration + "\nThe fee is " + truck.priceTruck1 + " Euro");
                    } else if (totalTime > 30 && totalTime <= 60){
                        builder.setMessage(totalDuration + "\nThe fee is " + truck.priceTruck2 + " Euro");
                    } else if (totalTime > 60 && totalTime <= 120){
                        builder.setMessage(totalDuration + "\nThe fee is " + truck.priceTruck3 + " Euro");
                    } else if (totalTime > 120) {
                        int additionalTime = totalTime - 120;
                        double additionalFee = Math.ceil(additionalTime / 30.0) * 0.50;
                        double totalFee = truck.priceTruck4 + additionalFee;
                        builder.setMessage(totalDuration + "\nThe fee is " + totalFee + " Euro");
                    }
                }


                 if (holder.vehicleType.getText().toString().equals("Bus")) {
                    if (totalTime > 0 && totalTime <=30){
                        builder.setMessage(totalDuration + "\nThe fee is " + bus.priceBus1 + " Euro");
                    } else if (totalTime > 30 && totalTime <= 60){
                        builder.setMessage(totalDuration + "\nThe fee is " + bus.priceBus2 + " Euro");
                    } else if (totalTime > 60 && totalTime <= 120){
                        builder.setMessage(totalDuration + "\nThe fee is " + bus.priceBus3 + " Euro");
                    } else if (totalTime > 120) {
                        int additionalTime = totalTime - 120;
                        double additionalFee = Math.ceil(additionalTime / 30.0) * 0.50;
                        double totalFee = bus.priceBus4 + additionalFee;
                        builder.setMessage(totalDuration + "\nThe fee is " + totalFee + " Euro");
                    }

                }


                 if (holder.vehicleType.getText().toString().equals("Taxi")) {
                    if (totalTime > 0 && totalTime <=30){
                        builder.setMessage(totalDuration + "\nThe fee is " + taxi.priceTaxi1 + " Euro");
                    } else if (totalTime > 30 && totalTime <= 60){
                        builder.setMessage(totalDuration + "\nThe fee is " + taxi.priceTaxi2 + " Euro");
                    } else if (totalTime > 60 && totalTime <= 120){
                        builder.setMessage(totalDuration + "\nThe fee is " + taxi.priceTaxi3 + " Euro");
                    } else if (totalTime > 120) {
                        int additionalTime = totalTime - 120;
                        double additionalFee = Math.ceil(additionalTime / 30.0) * 0.30;
                        double totalFee = taxi.priceTaxi4 + additionalFee;
                        builder.setMessage(totalDuration + "\nThe fee is " + totalFee + " Euro");
                    }
                }


                 if (holder.vehicleType.getText().toString().equals("Motorcycle")) {
                    if (totalTime > 0 && totalTime <=30){
                        builder.setMessage(totalDuration + "\nThe fee is " + motor.priceMotorcycle1 + " Euro");
                    } else if (totalTime > 30 && totalTime <= 60){
                        builder.setMessage(totalDuration + "\nThe fee is " + motor.priceMotorcycle2 + " Euro");
                    } else if (totalTime > 60 && totalTime <= 120){
                        builder.setMessage(totalDuration + "\nThe fee is " + motor.priceMotorcycle3 + " Euro");
                    } else if (totalTime > 120) {
                        int additionalTime = totalTime - 120;
                        double additionalFee = Math.ceil(additionalTime / 30.0) * 0.20;
                        double totalFee = motor.priceMotorcycle4 + additionalFee;
                        builder.setMessage(totalDuration + "\nThe fee is " + totalFee + " Euro");
                    }
                }



                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @SuppressLint("NotifyDataSetChanged")
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Log.d(TAG, "before: " + vehiclesList.size());
                                String key = String.valueOf(vehiclesList.get(position).getId());
                                vehiclesList.remove(position);
                                notifyItemRemoved(position);
                                mDatabaseRef.child(key).removeValue();
                                notifyDataSetChanged();


                            }
                        });

                builder.show();
            }
        });



    }
    public void setFilteredList(ArrayList<Vehicles> filteredList){
      this.vehiclesList =filteredList;
      notifyDataSetChanged();
    }




    @Override
    public int getItemCount() {
        return vehiclesList.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder{


        ConstraintLayout layout;
        TextView modelName,plaque,enteredTime,vehicleType;
        ImageButton delete;
        SearchView search;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            modelName = itemView.findViewById(R.id.txtModel);
            plaque = itemView.findViewById(R.id.txtPlaque);
            enteredTime = itemView.findViewById(R.id.txtEntered);
            vehicleType = itemView.findViewById(R.id.txtVehicleType);
            layout = itemView.findViewById(R.id.layoutOmer);
            delete = itemView.findViewById(R.id.delete);
            search = itemView.findViewById(R.id.search);

        }
    }
}
