package com.example.parkngapplcaton;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Vehicles {

    String modelName;
    String plaque;
    String time;
    String vehicleType;
    int id;
    int minFormat;
    String date;

    public Vehicles(){}


    public Vehicles(String modelName, String plaque, String time, String vehicleType, int id, int minFormat, String date) {
        this.modelName = modelName;
        this.plaque = plaque;
        this.time = time;
        this.vehicleType = vehicleType;
        this.id = id;
        this.minFormat = minFormat;
        this.date = date;
    }



    public String getDate() {
        return date;
    }

    public void setDate(String  date) {
        this.date = date;
    }

    public int getMinFormat() {
        return minFormat;
    }

    public void setMinFormat(int minFormat) {
        this.minFormat = minFormat;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getPlaque() {
        return plaque;
    }

    public void setPlaque(String plaque) {
        this.plaque = plaque;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Vehicles{" +
                "modelName='" + modelName + '\'' +
                ", plaque='" + plaque + '\'' +
                ", time='" + time + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                '}';
    }
}
