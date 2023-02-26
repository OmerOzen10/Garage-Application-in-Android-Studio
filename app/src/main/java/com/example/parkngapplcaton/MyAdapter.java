package com.example.parkngapplcaton;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{


    Context context;

    private DatabaseReference mDatabaseRef;

    ArrayList<Vehicles> vehiclesList;

    public  final static String TAG = "MyAdapter";





    public MyAdapter(Context context, ArrayList<Vehicles> vehiclesList, DatabaseReference databaseRef) {
        this.context = context;
        this.vehiclesList = vehiclesList;
        mDatabaseRef = databaseRef;
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
        holder.enteredTime.setText(vehicles.getTime());
        holder.vehicleType.setText(vehicles.getVehicleType());




        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                Calendar calendar = Calendar.getInstance();
//
//                int hourExit = calendar.get(Calendar.HOUR_OF_DAY);
//                int minuteExit = calendar.get(Calendar.MINUTE);
//                int minFormatExit = (hourExit * 60) + minuteExit;
//
//                int totalTime = minFormatExit - vehiclesList.get(position).getMinFormat();
//
//                int durationMinute;
//                int durationHour = (int)(totalTime/60);
//
//                if (durationHour == 0) {
//                    durationMinute = totalTime;
//                }else {
//                    durationMinute = totalTime%(durationHour * 60);
//                }

                LocalDateTime dateExit = LocalDateTime.now();

                String dateEntry = vehiclesList.get(position).date;

                LocalDateTime date1 = LocalDateTime.parse(dateEntry, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

                Duration duration = Duration.between(date1,dateExit);
                int hour = (int) duration.toHours();
                int minutes = (int) duration.toMinutes();
                int totalFormat = (hour * 60) + minutes;

                Log.d(TAG, "totalFormat:  " + dateExit);












                Car car = new Car();
                Truck truck = new Truck();
                Bus bus = new Bus();
                Taxi taxi = new Taxi();
                Motorcycle motor = new Motorcycle();




                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Delete Vehicle");
//                        .setMessage("The duration was " + durationHour + " Hours and " + durationMinute + " Minutes" +
//                                "\nThe fee is ");

                if (holder.vehicleType.getText().toString().equals("Car")){
                    if (totalFormat > 0 && totalFormat <= 30){
                        builder.setMessage("\nThe fee is " + car.priceCar1 + " Euro");

                    } else if (totalFormat > 30 && totalFormat <= 60){
                        builder.setMessage("\nThe fee is " + car.priceCar1 * 2 + " Euro");

                    } else if (totalFormat > 60 && totalFormat <= 120){
                        builder.setMessage("\nThe fee is " + car.priceCar1 * 3 + " Euro");

                    } else if (totalFormat > 120) {
                        int additionalTime = totalFormat - 120;
                        double additionalFee = Math.ceil(additionalTime / 30.0) * 0.5;
                        double totalFee = (car.priceCar1 * 3) + additionalFee;
                        builder.setMessage("\nThe fee is " + totalFee + " Euro");
                    }
                }




//                if (holder.vehicleType.getText().toString().equals("Car")){
//                    if (totalTime > 0 && totalTime <= 30){
//                        builder.setMessage("The duration was " + durationHour + " Hours and " + durationMinute + " Minutes" + "\nThe fee is " + car.priceCar0to2 + " Euro");
//                    } else if (totalTime > 30 && totalTime <= 60){
//                        builder.setMessage("The duration was " + durationHour + " Hours and " + durationMinute + " Minutes" + "\nThe fee is " + car.priceCar0to2 * 2 + " Euro");
//                    } else if (totalTime > 60 && totalTime <= 120){
//                        builder.setMessage("The duration was " + durationHour + " Hours and " + durationMinute + " Minutes" + "\nThe fee is " + car.priceCar0to2 * 3 + " Euro");
//                    } else if (totalTime > 120) {
//                        int additionalTime = totalTime - 120;
//                        double additionalFee = Math.ceil(additionalTime / 30.0) * 0.4;
//                        double totalFee = car.priceCar0to2 * 3 + additionalFee;
//                        builder.setMessage("The duration was " + durationHour + " Hours and " + durationMinute + " Minutes" + "\nThe fee is " + totalFee + " Euro");
//                    }
//                }


//                 if (holder.vehicleType.getText().toString().equals("Truck")) {
//                    if (totalTime > 0 && totalTime <=30){
//                        builder.setMessage("The duration was " + durationHour + " Hours and " + durationMinute + " Minutes" + "\nThe fee is " + truck.priceTruck0to2 + " Euro");
//                    } else if (totalTime > 30 && totalTime <= 60){
//                        builder.setMessage("The duration was " + durationHour + " Hours and " + durationMinute + " Minutes" + "\nThe fee is " + truck.priceTruck0to2 * 2 + " Euro");
//                    } else if (totalTime > 60 && totalTime <= 120){
//                        builder.setMessage("The duration was " + durationHour + " Hours and " + durationMinute + " Minutes" + "\nThe fee is " + truck.priceTruck0to2 * 3 + " Euro");
//                    } else if (totalTime > 120) {
//                        int additionalTime = totalTime - 120;
//                        double additionalFee = Math.ceil(additionalTime / 30.0) * 0.5;
//                        double totalFee = truck.priceTruck0to2 * 3 + additionalFee;
//                        builder.setMessage("The duration was " + durationHour + " Hours and " + durationMinute + " Minutes" + "\nThe fee is " + totalFee + " Euro");
//                    }
//                }
//
//
//                 if (holder.vehicleType.getText().toString().equals("Bus")) {
//                    if (totalTime > 0 && totalTime <=30){
//                        builder.setMessage("The duration was " + durationHour + " Hours and " + durationMinute + " Minutes" + "\nThe fee is " + bus.priceBus0to2 + " Euro");
//                    } else if (totalTime > 30 && totalTime <= 60){
//                        builder.setMessage("The duration was " + durationHour + " Hours and " + durationMinute + " Minutes" + "\nThe fee is " + bus.priceBus0to2 * 2 + " Euro");
//                    } else if (totalTime > 60 && totalTime <= 120){
//                        builder.setMessage("The duration was " + durationHour + " Hours and " + durationMinute + " Minutes" + "\nThe fee is " + bus.priceBus0to2 * 3 + " Euro");
//                    } else if (totalTime > 120) {
//                        int additionalTime = totalTime - 120;
//                        double additionalFee = Math.ceil(additionalTime / 30.0) * 0.4;
//                        double totalFee = bus.priceBus0to2 * 3 + additionalFee;
//                        builder.setMessage("The duration was " + durationHour + " Hours and " + durationMinute + " Minutes" + "\nThe fee is " + totalFee + " Euro");
//                    }
//
//                }
//
//
//                 if (holder.vehicleType.getText().toString().equals("Taxi")) {
//                    if (totalTime > 0 && totalTime <=30){
//                        builder.setMessage("The duration was " + durationHour + " Hours and " + durationMinute + " Minutes" + "\nThe fee is " + taxi.priceTaxi0to2 + " Euro");
//                    } else if (totalTime > 30 && totalTime <= 60){
//                        builder.setMessage("The duration was " + durationHour + " Hours and " + durationMinute + " Minutes" + "\nThe fee is " + taxi.priceTaxi0to2 * 2 + " Euro");
//                    } else if (totalTime > 60 && totalTime <= 120){
//                        builder.setMessage("The duration was " + durationHour + " Hours and " + durationMinute + " Minutes" + "\nThe fee is " + taxi.priceTaxi0to2 * 3 + " Euro");
//                    } else if (totalTime > 120) {
//                        int additionalTime = totalTime - 120;
//                        double additionalFee = Math.ceil(additionalTime / 30.0) * 0.4;
//                        double totalFee = taxi.priceTaxi0to2 * 3 + additionalFee;
//                        builder.setMessage("The duration was " + durationHour + " Hours and " + durationMinute + " Minutes" + "\nThe fee is " + totalFee + " Euro");
//                    }
//                }
//
//                 if (holder.vehicleType.getText().toString().equals("Motorcycle")) {
//                    if (totalTime > 0 && totalTime <=30){
//                        builder.setMessage("The duration was " + durationHour + " Hours and " + durationMinute + " Minutes" + "\nThe fee is " + motor.priceMotorcycle0to2 + " Euro");
//                    } else if (totalTime > 30 && totalTime <= 60){
//                        builder.setMessage("The duration was " + durationHour + " Hours and " + durationMinute + " Minutes" + "\nThe fee is " + motor.priceMotorcycle0to2 * 2 + " Euro");
//                    } else if (totalTime > 60 && totalTime <= 120){
//                        builder.setMessage("The duration was " + durationHour + " Hours and " + durationMinute + " Minutes" + "\nThe fee is " + motor.priceMotorcycle0to2 * 3 + " Euro");
//                    } else if (totalTime > 120) {
//                        int additionalTime = totalTime - 120;
//                        double additionalFee = Math.ceil(additionalTime / 30.0) * 0.3;
//                        double totalFee = motor.priceMotorcycle0to2 * 3 + additionalFee;
//                        builder.setMessage("The duration was " + durationHour + " Hours and " + durationMinute + " Minutes" + "\nThe fee is " + totalFee + " Euro");
//                    }
//                }

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Log.d(TAG, "before: " + vehiclesList.size());



                                // SAKIN AYNI APTALLIGI TEKRAR YAPMA 2 SAATIN COP OLDU //


//                                vehiclesList.remove(position);
//                                notifyItemRemoved(position);


                                String key = String.valueOf(vehiclesList.get(position).getId());
                                vehiclesList.remove(position);
                                notifyItemRemoved(position);
                                mDatabaseRef.child(key).removeValue();
                                notifyDataSetChanged();

                            }
                        });
                builder.show();
                Log.d(TAG, "after: " + vehiclesList.size());
            }
        });
    }



    @Override
    public int getItemCount() {
        return vehiclesList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{


        ConstraintLayout layout;
        TextView modelName,plaque,enteredTime,vehicleType;
        ImageButton delete;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            modelName = itemView.findViewById(R.id.txtModel);
            plaque = itemView.findViewById(R.id.txtPlaque);
            enteredTime = itemView.findViewById(R.id.txtEntered);
            vehicleType = itemView.findViewById(R.id.txtVehicleType);
            layout = itemView.findViewById(R.id.layoutOmer);
            delete = itemView.findViewById(R.id.delete);
        }
    }
}
