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

                Calendar calendar = Calendar.getInstance();

                int hourExit = calendar.get(Calendar.HOUR_OF_DAY);
                int minuteExit = calendar.get(Calendar.MINUTE);
                int minFormatExit = (hourExit * 60) + minuteExit;

                int fee = minFormatExit - vehiclesList.get(position).getMinFormat();

                int durationMinute;
                int durationHour = (int)(fee/60);

                if (durationHour == 0) {
                    durationMinute = fee;
                }else {
                    durationMinute = fee%(durationHour * 60);
                }




                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Delete Vehicle")
                        .setMessage("The duration was " + durationHour + " Hours and " + durationMinute + " Minutes" +
                                "\nThe fee is " + fee )
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                vehiclesList.remove(position);
                                notifyItemRemoved(position);
                                String key = String.valueOf(vehiclesList.get(position).getId());
                                mDatabaseRef.child(key).removeValue();
                                notifyDataSetChanged();
                            }
                        });
                builder.show();
                Log.d(TAG, "sum:  " +fee);
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
