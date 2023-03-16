package com.example.parkngapplcaton;

import android.animation.LayoutTransition;
import android.media.Image;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class InfoFragment extends Fragment {

    CardView cardViewCar;
    LinearLayout linerLayoutCar;

    TextView demo1,demo2,demo3,demo4,demo5;

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

        final float originalRadius = cardViewCar.getRadius();

        linerLayoutCar.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

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
                    cardViewCar.setRadius(originalRadius);
                }else {
                    cardViewCar.setRadius(30f);
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
