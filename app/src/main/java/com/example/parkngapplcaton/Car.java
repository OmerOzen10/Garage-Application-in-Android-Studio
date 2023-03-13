package com.example.parkngapplcaton;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Car extends Vehicles{

    double priceCar1 = 1.0;
    double priceCar2 = 2.0;
    double priceCar3 = 3.0;
    double priceCar4 = 3.0;
 //    double priceCar2 = 2;
//    double priceCar3= 3;
//    double priceCar3 = 3;




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
    public String getId() {
        return super.getId();
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public String getVehicleType() {
        return super.getVehicleType();
    }

    @Override
    public void setVehicleType(String vehicleType) {
        super.setVehicleType(vehicleType);
    }
}
