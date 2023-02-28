package com.example.parkngapplcaton;

public class Vehicles {

    String modelName;
    String plaque;
    String vehicleType;
    int id;
    String date;

    String premium;

    public Vehicles(){}

    public Vehicles(String modelName, String plaque, String vehicleType, int id, String date, String premium) {
        this.modelName = modelName;
        this.plaque = plaque;
        this.vehicleType = vehicleType;
        this.id = id;
        this.date = date;
        this.premium = premium;
    }

//    public void Vehicles1(String modelName, String plaque, String vehicleType, int id, String date, String premium) {
//        this.modelName = modelName;
//        this.plaque = plaque;
//        this.vehicleType = vehicleType;
//        this.id = id;
//        this.date = date;
//        this.premium = premium;
//    }


    public Vehicles(String modelName, String plaque, String vehicleType, int id, String date) {
        this.modelName = modelName;
        this.plaque = plaque;
        this.vehicleType = vehicleType;
        this.id = id;
        this.date = date;
    }



    public String getDate() {
        return date;
    }

    public void setDate(String  date) {
        this.date = date;
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
                ", vehicleType='" + vehicleType + '\'' +
                '}';
    }
}
