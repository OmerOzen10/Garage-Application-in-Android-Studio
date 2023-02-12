package com.example.parkngapplcaton;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class InfoFragment extends Fragment {

    CardView cardViewCar,cardViewInfoCar,cardViewTruck,cardViewInfoTruck,cardViewBus,cardViewInfoBus,
    cardViewTaxi,cardViewInfoTaxi,cardViewMotor,cardViewInfoMotor;

    ImageView closeCardViewCar,closeCardViewTruck,closeCardViewBus,closeCardViewTaxi,closeCardViewMotor;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cardViewCar = view.findViewById(R.id.CardViewCar);
        cardViewInfoCar = view.findViewById(R.id.cardViewInfo);
        closeCardViewCar = view.findViewById(R.id.closeImageCar);
        cardViewTruck = view.findViewById(R.id.CardViewTruck);
        cardViewInfoTruck = view.findViewById(R.id.cardViewInfoTruck);
        closeCardViewTruck = view.findViewById(R.id.closeImageTruck);
        cardViewBus = view.findViewById(R.id.CardViewBus);
        cardViewInfoBus = view.findViewById(R.id.cardViewInfoBus);
        closeCardViewBus = view.findViewById(R.id.closeImageBus);
        cardViewTaxi = view.findViewById(R.id.CardViewTaxi);
        cardViewInfoTaxi = view.findViewById(R.id.cardViewInfoTaxi);
        closeCardViewTaxi = view.findViewById(R.id.closeImageTaxi);
        cardViewMotor = view.findViewById(R.id.CardViewMotorcycle);
        cardViewInfoMotor = view.findViewById(R.id.cardViewInfoMotor);
        closeCardViewMotor = view.findViewById(R.id.closeImageMotor);






        cardViewCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardViewInfoCar.setVisibility(View.VISIBLE);
                cardViewInfoTruck.setVisibility(View.GONE);
                cardViewInfoBus.setVisibility(View.GONE);
                cardViewInfoTaxi.setVisibility(View.GONE);
                cardViewInfoMotor.setVisibility(View.GONE);
            }
        });

        closeCardViewCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardViewInfoCar.setVisibility(View.GONE);
            }
        });



        cardViewTruck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardViewInfoTruck.setVisibility(View.VISIBLE);
                cardViewInfoCar.setVisibility(View.GONE);
                cardViewInfoBus.setVisibility(View.GONE);
                cardViewInfoTaxi.setVisibility(View.GONE);
                cardViewInfoMotor.setVisibility(View.GONE);
            }
        });

        closeCardViewTruck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardViewInfoTruck.setVisibility(View.GONE);
            }
        });



        cardViewBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardViewInfoBus.setVisibility(View.VISIBLE);
                cardViewInfoTruck.setVisibility(View.GONE);
                cardViewInfoCar.setVisibility(View.GONE);
                cardViewInfoTaxi.setVisibility(View.GONE);
                cardViewInfoMotor.setVisibility(View.GONE);
            }
        });

        closeCardViewBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardViewInfoBus.setVisibility(View.GONE);
            }
        });



        cardViewTaxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardViewInfoTaxi.setVisibility(View.VISIBLE);
                cardViewInfoTruck.setVisibility(View.GONE);
                cardViewInfoCar.setVisibility(View.GONE);
                cardViewInfoBus.setVisibility(View.GONE);
                cardViewInfoMotor.setVisibility(View.GONE);
            }
        });

        closeCardViewTaxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardViewInfoTaxi.setVisibility(View.GONE);
            }
        });



        cardViewMotor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardViewInfoMotor.setVisibility(View.VISIBLE);
                cardViewInfoTruck.setVisibility(View.GONE);
                cardViewInfoCar.setVisibility(View.GONE);
                cardViewInfoBus.setVisibility(View.GONE);
                cardViewInfoTaxi.setVisibility(View.GONE);
            }
        });

        closeCardViewMotor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardViewInfoMotor.setVisibility(View.GONE);
            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_info,container,false);

    }
}
