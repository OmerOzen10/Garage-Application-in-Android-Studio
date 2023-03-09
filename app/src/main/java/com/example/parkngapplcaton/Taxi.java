package com.example.parkngapplcaton;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Taxi extends Vehicles{

    double priceTaxi1 = 1.0;
    double priceTaxi2 = 2.0;
    double priceTaxi3 = 3.0;
    double priceTaxi4 = 3.0;
//    double priceTaxi0to4 = 0.08;
//    double priceTaxi0to6 = 0.07;
//    double priceTaxi0to24 = 0.06;


    @Override
    public long getDuration() {
        return super.getDuration();
    }

    @Override
    public void setDuration(long duration) {
        super.setDuration(duration);
    }

    @Override
    public boolean getPremium() {
        return super.getPremium();
    }

    @Override
    public void setPremium(boolean premium) {
        super.setPremium(premium);
    }

    @Override
    public String getDate() {
        return super.getDate();
    }

    @Override
    public void setDate(String date) {
        super.setDate(date);
    }

    @Override
    public String getModelName() {
        return super.getModelName();
    }

    @Override
    public void setModelName(String modelName) {
        super.setModelName(modelName);
    }

    @Override
    public String getPlaque() {
        return super.getPlaque();
    }

    @Override
    public void setPlaque(String plaque) {
        super.setPlaque(plaque);
    }


    @Override
    public String getVehicleType() {
        return super.getVehicleType();
    }

    @Override
    public void setVehicleType(String vehicleType) {
        super.setVehicleType(vehicleType);
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }
}
