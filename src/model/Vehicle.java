package model;

public class Vehicle {
    private String vehicleNumber;
    private int maximumWeight;
    private int passengerCount;
    private String status;


    public Vehicle() {

    }
    public Vehicle(String vehicleNumber, int maximumWeight, int passengerCount, String status) {
        this.setVehicleNumber(vehicleNumber);
        this.setMaximumWeight(maximumWeight);
        this.setPassengerCount(passengerCount);
        this.setStatus(status);
    }

    public void park(){
        this.setStatus("Parked");
    }
    public void depart(){
        this.setStatus("Departed");
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public int getMaximumWeight() {
        return maximumWeight;
    }
    public void setMaximumWeight(int maximumWeight) {
        this.maximumWeight = maximumWeight;
    }

    public int getPassengerCount() {
        return passengerCount;
    }
    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    public String getStatus() {
        return status;
    }
    private void setStatus(String status) {
        this.status = status;
    }
}