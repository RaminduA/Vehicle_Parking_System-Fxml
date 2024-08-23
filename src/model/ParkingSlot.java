package model;


import javafx.scene.layout.AnchorPane;

public class ParkingSlot {
    private int slotId;
    private boolean availability;
    private String vehicleType;
    private AnchorPane slotPane;

    public ParkingSlot() {

    }
    public ParkingSlot(int slotId, boolean availability, String vehicleType, AnchorPane slotPane) {
        this.setSlotId(slotId);
        this.setAvailability(availability);
        this.setVehicleType(vehicleType);
        this.setSlotPane(slotPane);
    }

    public int getSlotId() {
        return slotId;
    }
    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public boolean isAvailability() {
        return availability;
    }
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getVehicleType() {
        return vehicleType;
    }
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public AnchorPane getSlotPane() {
        return slotPane;
    }
    public void setSlotPane(AnchorPane slotPane) {
        this.slotPane = slotPane;
    }


}
