package com.example.parkngapplcaton;

public class Vehicles {

    String modelName;
    String plaque;
    String time;
    String duration;
    String vehicleType;
    int id;

    public Vehicles(){}


    public Vehicles(String modelName, String plaque, String time, String duration, String vehicleType, int id) {
        this.modelName = modelName;
        this.plaque = plaque;
        this.time = time;
        this.duration = duration;
        this.vehicleType = vehicleType;
        this.id = id;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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
                ", duration='" + duration + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                '}';
    }
}
