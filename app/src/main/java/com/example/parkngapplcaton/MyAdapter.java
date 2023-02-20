package com.example.parkngapplcaton;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    Context context;

    private DatabaseReference mDatabaseRef;

    ArrayList<Vehicles> vehiclesList;

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
        holder.duration.setText(vehicles.getDuration()+" Hours");
        holder.vehicleType.setText(vehicles.getVehicleType());




        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.cardViewButton.setVisibility(View.VISIBLE);
            }
        });

        holder.closeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.cardViewButton.setVisibility(View.GONE);
            }
        });

        holder.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the key of the data to be deleted
                String key = String.valueOf(vehiclesList.get(position).getId());

                // Delete the data from the Firebase Realtime Database
                mDatabaseRef.child(key).removeValue();

                // Remove the item from the adapter
                vehiclesList.remove(position);
                notifyItemRemoved(position);
                notifyDataSetChanged();
                holder.cardViewButton.setVisibility(View.GONE);
            }
        });


    }



    @Override
    public int getItemCount() {
        return vehiclesList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{


        ConstraintLayout layout;
        CardView cardViewButton;
        TextView modelName,plaque,enteredTime,duration,vehicleType;
        ImageView closeCard;
        TextView buttonDelete;




        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            modelName = itemView.findViewById(R.id.txtModel);
            plaque = itemView.findViewById(R.id.txtPlaque);
            enteredTime = itemView.findViewById(R.id.txtEntered);
            duration = itemView.findViewById(R.id.txtDuration);
            vehicleType = itemView.findViewById(R.id.txtVehicleType);

            layout = itemView.findViewById(R.id.layoutOmer);
            cardViewButton = itemView.findViewById(R.id.cardViewButton);

            closeCard = itemView.findViewById(R.id.closeCard);
            buttonDelete = itemView.findViewById(R.id.buttonDelete);



        }
    }





}
