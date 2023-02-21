package com.example.parkngapplcaton;

public class Vehicles {

    String modelName;
    String plaque;
    String time;
    String duration;
    String vehicleType;
    String id;

    int minFormat;

    public Vehicles(){}


    public Vehicles(String modelName, String plaque, String time, String vehicleType, String id, int minFormat) {
        this.modelName = modelName;
        this.plaque = plaque;
        this.time = time;
//        this.duration = duration;
        this.vehicleType = vehicleType;
        this.id = id;
        this.minFormat = minFormat;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Vehicles{" +
                "modelName='" + modelName + '\'' +
                ", plaque='" + plaque + '\'' +
                ", time='" + time + '\'' +
                ", duration='" + duration + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                '}';
    }
}
