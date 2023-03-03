package com.example.parkngapplcaton;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Truck extends Vehicles{

    double priceTruck1 = 1.5;
    double priceTruck2 = 3;
    double priceTruck3 = 4.5;
    double priceTruck4 = 4.5;


//    double priceTruck0to4 = 0.14;
//    double priceTruck0to6 = 0.13;
//    double priceTruck0to24 = 0.12;




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
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }
}
