package model;

public class DepartedRecord {
    private String vehicleNumber;
    private String vehicleType;
    private String driverName;
    private String departedTime;

    public DepartedRecord() {

    }
    public DepartedRecord(String vehicleNumber, String vehicleType, String driverName, String departedTime) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.driverName = driverName;
        this.departedTime = departedTime;
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

    public String getDriverName() {
        return driverName;
    }
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDepartedTime() {
        return departedTime;
    }
    public void setDepartedTime(String departedTime) {
        this.departedTime = departedTime;
    }
}
