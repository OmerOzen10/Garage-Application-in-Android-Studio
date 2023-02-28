package com.example.parkngapplcaton;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Bus extends Vehicles{

    double priceBus1 = 1.25;
    double priceBus2 = 2.50;
    double priceBus3 = 3.75;
    double priceBus4 = 3.75;


//    double priceBus0to4 = 0.12;
//    double priceBus0to6 = 0.11;
//    double priceBus0to24 = 0.10;

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
