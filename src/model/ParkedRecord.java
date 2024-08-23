package model;

public class ParkedRecord {
    private String vehicleNumber;
    private String vehicleType;
    private String parkingSlot;
    private String parkedTime;

    public ParkedRecord() {

    }
    public ParkedRecord(String vehicleNumber, String vehicleType, String parkingSlot, String parkedTime) {
        this.setVehicleNumber(vehicleNumber);
        this.setVehicleType(vehicleType);
        this.setParkingSlot(parkingSlot);
        this.setParkedTime(parkedTime);
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getParkingSlot() {
        return parkingSlot;
    }
    public void setParkingSlot(String parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public String getParkedTime() {
        return parkedTime;
    }
    public void setParkedTime(String parkedTime) {
        this.parkedTime = parkedTime;
    }
}
