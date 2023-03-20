package com.example.parkngapplcaton;

import android.animation.LayoutTransition;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.media.Image;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

public class InfoFragment extends Fragment {

    CardView cardViewCar, cardViewTruck,cardViewBus,cardViewTaxi,cardViewMotor;
    LinearLayout linerLayoutCar, linearLayoutTruck,linearLayoutBus,linearLayoutTaxi,linearLayoutMotor;

    TextView demo1,demo2,demo3,demo4,demo5,txtTruck1,txtTruck2,txtTruck3,txtTruck4,txtTruck5,txtBus1,txtBus2,txtBus3,txtBus4,txtBus5,txtTaxi1,txtTaxi2,txtTaxi3,txtTaxi4,txtTaxi5,txtMotor1,txtMotor2,txtMotor3,txtMotor4,txtMotor5;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cardViewCar = view.findViewById(R.id.cardViewCar);
        linerLayoutCar = view.findViewById(R.id.linearLayoutCar);
        demo1 = view.findViewById(R.id.demo1);
        demo2 = view.findViewById(R.id.demo2);
        demo3 = view.findViewById(R.id.demo3);
        demo4 = view.findViewById(R.id.demo4);
        demo5 = view.findViewById(R.id.demo5);


        cardViewTruck = view.findViewById(R.id.cardViewTruck);
        linearLayoutTruck = view.findViewById(R.id.linearLayoutTruck);
        txtTruck1 = view.findViewById(R.id.txtTruck1);
        txtTruck2 = view.findViewById(R.id.txtTruck2);
        txtTruck3 = view.findViewById(R.id.txtTruck3);
        txtTruck4 = view.findViewById(R.id.txtTruck4);
        txtTruck5 = view.findViewById(R.id.txtTruck5);

        cardViewBus = view.findViewById(R.id.cardViewBus);
        linearLayoutBus = view.findViewById(R.id.linearLayoutBus);
        txtBus1 = view.findViewById(R.id.txtBus1);
        txtBus2 = view.findViewById(R.id.txtBus2);
        txtBus3 = view.findViewById(R.id.txtBus3);
        txtBus4 = view.findViewById(R.id.txtBus4);
        txtBus5 = view.findViewById(R.id.txtBus5);


        cardViewTaxi = view.findViewById(R.id.cardViewTaxi);
        linearLayoutTaxi = view.findViewById(R.id.linearLayoutTaxi);
        txtTaxi1 = view.findViewById(R.id.txtTaxi1);
        txtTaxi2 = view.findViewById(R.id.txtTaxi2);
        txtTaxi3 = view.findViewById(R.id.txtTaxi3);
        txtTaxi4 = view.findViewById(R.id.txtTaxi4);
        txtTaxi5 = view.findViewById(R.id.txtTaxi5);


        cardViewMotor = view.findViewById(R.id.cardViewMotor);
        linearLayoutMotor = view.findViewById(R.id.linearLayoutMotor);
        txtMotor1 = view.findViewById(R.id.txtMotor1);
        txtMotor2 = view.findViewById(R.id.txtMotor2);
        txtMotor3 = view.findViewById(R.id.txtMotor3);
        txtMotor4 = view.findViewById(R.id.txtMotor4);
        txtMotor5 = view.findViewById(R.id.txtMotor5);


        final float originalRadiusCar = cardViewCar.getRadius();


        linearLayoutTruck.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGE_DISAPPEARING);;

        cardViewCar.setOnClickListener(new View.OnClickListener() {
            boolean isToggled = false;
            @Override
            public void onClick(View view) {


                int v = (demo1.getVisibility() == View.GONE && demo2.getVisibility() == View.GONE && demo3.getVisibility() == View.GONE && demo4.getVisibility() == View.GONE && demo5.getVisibility() == View.GONE)?View.VISIBLE: View.GONE;

              TransitionManager.beginDelayedTransition(linerLayoutCar, new AutoTransition());
                demo1.setVisibility(v);
                demo2.setVisibility(v);
                demo3.setVisibility(v);
                demo4.setVisibility(v);
                demo5.setVisibility(v);

                if (isToggled){
                    cardViewCar.setRadius(originalRadiusCar);

                }else {
                    cardViewCar.setRadius(30f);
                }
                isToggled = !isToggled;


            }
        });

        final float originalRadiusTruck = cardViewTruck.getRadius();

        linearLayoutTruck.getLayoutTransition().setDuration(LayoutTransition.CHANGING, 1000);

        cardViewTruck.setOnClickListener(new View.OnClickListener() {

            boolean isToggled = false;
            @Override
            public void onClick(View view) {


                int v = (txtTruck1.getVisibility() == View.GONE && txtTruck2.getVisibility() == View.GONE && txtTruck3.getVisibility() == View.GONE && txtTruck4.getVisibility() == View.GONE && txtTruck5.getVisibility() == View.GONE)?View.VISIBLE: View.GONE;

                TransitionManager.beginDelayedTransition(linearLayoutTruck, new AutoTransition());
                txtTruck1.setVisibility(v);
                txtTruck2.setVisibility(v);
                txtTruck3.setVisibility(v);
                txtTruck4.setVisibility(v);
                txtTruck5.setVisibility(v);

                if (isToggled){
                    cardViewTruck.setRadius(originalRadiusTruck);

                }else {
                    cardViewTruck.setRadius(30f);
                }
                isToggled = !isToggled;


            }
        });



        final float originalRadiusBus = cardViewBus.getRadius();

        linearLayoutBus.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGE_DISAPPEARING);

        cardViewBus.setOnClickListener(new View.OnClickListener() {
            boolean isToggled = false;
            @Override
            public void onClick(View view) {


                int v = (txtBus1.getVisibility() == View.GONE && txtBus2.getVisibility() == View.GONE && txtBus3.getVisibility() == View.GONE && txtBus4.getVisibility() == View.GONE && txtBus5.getVisibility() == View.GONE)?View.VISIBLE: View.GONE;

                TransitionManager.beginDelayedTransition(linearLayoutTruck, new AutoTransition());
                txtBus1.setVisibility(v);
                txtBus2.setVisibility(v);
                txtBus3.setVisibility(v);
                txtBus4.setVisibility(v);
                txtBus5.setVisibility(v);

                if (isToggled){
                    cardViewBus.setRadius(originalRadiusBus);

                }else {
                    cardViewBus.setRadius(30f);
                }
                isToggled = !isToggled;


            }
        });

        final float originalRadiusTaxi = cardViewTaxi.getRadius();

        linearLayoutTaxi.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGE_DISAPPEARING);

        cardViewTaxi.setOnClickListener(new View.OnClickListener() {
            boolean isToggled = false;
            @Override
            public void onClick(View view) {


                int v = (txtTaxi1.getVisibility() == View.GONE && txtTaxi2.getVisibility() == View.GONE && txtTaxi3.getVisibility() == View.GONE && txtTaxi4.getVisibility() == View.GONE && txtTaxi5.getVisibility() == View.GONE)?View.VISIBLE: View.GONE;

                TransitionManager.beginDelayedTransition(linearLayoutTruck, new AutoTransition());
                txtTaxi1.setVisibility(v);
                txtTaxi2.setVisibility(v);
                txtTaxi3.setVisibility(v);
                txtTaxi4.setVisibility(v);
                txtTaxi5.setVisibility(v);

                if (isToggled){
                    cardViewTaxi.setRadius(originalRadiusTaxi);

                }else {
                    cardViewTaxi.setRadius(30f);
                }
                isToggled = !isToggled;


            }
        });

        final float originalRadiusMotor = cardViewMotor.getRadius();

        linearLayoutMotor.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGE_DISAPPEARING);

        cardViewMotor.setOnClickListener(new View.OnClickListener() {
            boolean isToggled = false;
            @Override
            public void onClick(View view) {


                int v = (txtMotor1.getVisibility() == View.GONE && txtMotor2.getVisibility() == View.GONE && txtMotor3.getVisibility() == View.GONE && txtMotor4.getVisibility() == View.GONE && txtMotor5.getVisibility() == View.GONE)?View.VISIBLE: View.GONE;

                TransitionManager.beginDelayedTransition(linearLayoutTruck, new AutoTransition());
                txtMotor1.setVisibility(v);
                txtMotor2.setVisibility(v);
                txtMotor3.setVisibility(v);
                txtMotor4.setVisibility(v);
                txtMotor5.setVisibility(v);

                if (isToggled){
                    cardViewMotor.setRadius(originalRadiusMotor);

                }else {
                    cardViewMotor.setRadius(30f);
                }
                isToggled = !isToggled;


            }
        });






    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_info,container,false);

    }
}
