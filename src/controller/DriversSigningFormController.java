package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static controller.ListController.*;

public class DriversSigningFormController {
    public AnchorPane driversSigningFormContext;
    public Label lblDate;
    public Label lblTime;
    public JFXComboBox cmbVehicleNumber;
    public Label lblVehicleType;
    public Label lblDriver;
    public JFXComboBox cmbDriver;
    public ImageView driverImage;
    public JFXButton parkButton;
    public JFXButton departButton;

    public AnchorPane slot1;
    public AnchorPane slot2;
    public AnchorPane slot3;
    public AnchorPane slot4;
    public AnchorPane slot5;
    public AnchorPane slot6;
    public AnchorPane slot7;
    public AnchorPane slot8;
    public AnchorPane slot9;
    public AnchorPane slot10;
    public AnchorPane slot11;
    public AnchorPane slot12;
    public AnchorPane slot13;
    public AnchorPane slot14;

    private int lastVehicle=-1;
    private int lastDriver=-1;
    private int lastSlot=-1;

    public void initialize(){
        implementSlots();
        setDateAndTime();
        String[] list1=getList1();
        String[] list2=getList2();
        cmbVehicleNumber.getItems().addAll(list1);
        cmbVehicleNumber.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String vehicle=(String)newValue;
            int index=findIndex(vehicle,list1);
            lastVehicle=index;
            setDateAndTime();
            setVehicleType(lastVehicle);
            if(lastDriver<0 && vehicleDetailsList[lastVehicle].getStatus().equals("Departed")){
                String departedDriver=findDepartedDriver(vehicle);
                lblDriver.setText(departedDriver);
                System.out.println("DepartedDriver : "+departedDriver);
                int id=findIndex(departedDriver,ListController.driversList);
                setImage(id+1);
            }else if(lastDriver<0 && !vehicleDetailsList[lastVehicle].getStatus().equals("Departed")){
                lblDriver.setText("");
                driverImage.setImage(null);
            }
            selectVehicleSlots();
            System.out.println(newValue);
        });
        cmbDriver.getItems().addAll(list2);
        cmbDriver.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String driver=(String)newValue;
            if(lastVehicle>=0)lblDriver.setText("");
            int id=findIndex(driver,ListController.driversList);
            int index=findIndex(driver,list2);
            lastDriver=index;
            setImage(id+1);
            setDateAndTime();
            System.out.println(newValue);
        });
    }

    private String findDepartedDriver(String vehicle) {
        String driver="";
        int lastIndex=nextIndex(departedRecordList)-1;
        for(int i=lastIndex;i>=0;i--){
            if(departedRecordList[i].getVehicleNumber().equals(vehicle)){
                driver=departedRecordList[i].getDriverName();
            }
        }
        return driver;
    }

    private String[] getList1() {
        int arrayLength=getArrayLength(vehicleDetailsList);
        String[] list1=new String[arrayLength];
        for(int i=0;i<list1.length;i++){
            list1[i]= vehicleDetailsList[i].getVehicleNumber();
        }
        return list1;
    }

    private String[] getList2() {
        int arrayLength=getArrayLength(ListController.driverDetailsList);
        String[] list2=new String[arrayLength];
        for(int i=0;i<list2.length;i++){
            list2[i]=ListController.driverDetailsList[i].getName();
        }
        return list2;
    }

    private int getArrayLength(Object[] array) {
        int count=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==null){
                break;
            }
            count++;
        }
        return count;
    }

    private void implementSlots() {
        ListController.slotList[0].setSlotPane(slot1);
        ListController.slotList[1].setSlotPane(slot2);
        ListController.slotList[2].setSlotPane(slot3);
        ListController.slotList[3].setSlotPane(slot4);
        ListController.slotList[4].setSlotPane(slot5);
        ListController.slotList[5].setSlotPane(slot6);
        ListController.slotList[6].setSlotPane(slot7);
        ListController.slotList[7].setSlotPane(slot8);
        ListController.slotList[8].setSlotPane(slot9);
        ListController.slotList[9].setSlotPane(slot10);
        ListController.slotList[10].setSlotPane(slot11);
        ListController.slotList[11].setSlotPane(slot12);
        ListController.slotList[12].setSlotPane(slot13);
        ListController.slotList[13].setSlotPane(slot14);
    }

    private void selectVehicleSlots() {
        Vehicle vehicle=ListController.vehicleDetailsList[lastVehicle];
        String status = vehicle.getStatus();
        if(!status.equals("Parked")){
            for(int i=0;i<ListController.slotList.length;i++){
                if(ListController.slotList[i].getVehicleType().equals(lblVehicleType.getText())){
                    if(ListController.slotList[i].isAvailability()){
                        ListController.slotList[i].getSlotPane().setStyle("-fx-background-color:linear-gradient(#009432,#083908)");
                    }else{
                        ListController.slotList[i].getSlotPane().setStyle("-fx-background-color:linear-gradient(#ff3f34,#8c0910)");
                    }
                }else{
                    ListController.slotList[i].getSlotPane().setStyle("-fx-background-color:linear-gradient( #5D5D5D,#1A1A1A)");
                }
            }
            for(int i=0;i<ListController.slotList.length;i++){
                if(ListController.slotList[i].getVehicleType().equals(lblVehicleType.getText()) && ListController.slotList[i].isAvailability()){
                    ListController.slotList[i].getSlotPane().setStyle("-fx-background-color:linear-gradient(#008c8c,#024d4d)");
                    lastSlot=i;
                    break;
                }
            }
        }
    }

    private void setVehicleType(int id) {
        String type= vehicleDetailsList[id].getClass().getName().substring(6);
        if(type.equals("CargoLorry")){
            type="Cargo Lorry";
        }
        lblVehicleType.setText(type);
    }

    private int findIndex(String element, String[] list) {
        int index=0;
        for(int i=0;i<list.length;i++){
            if(element.equals(list[i])){
                index=i;
            }
        }
        return index;
    }

    private void setImage(int index) {
        driverImage.setImage(new Image(getClass().getResourceAsStream("/assets/drivers/"+index+".png")));
        driverImage.setPreserveRatio(false);
    }

    public void setDateAndTime(){
        lblDate.setText(new SimpleDateFormat("dd MMM yyyy").format(new Date()));
        lblTime.setText(new SimpleDateFormat("hh:mm a").format(new Date()));
    }

    public void popUpLoginForm(ActionEvent actionEvent) throws IOException {
        driversSigningFormContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/LoginForm.fxml")));
    }

    public void parkOrDepart(ActionEvent actionEvent) throws IOException {
        if(lastVehicle>=0 && (lastDriver>=0 || !lblDriver.getText().equals("")/**/)){
            Vehicle vehicle=ListController.vehicleDetailsList[lastVehicle];
            String status=vehicle.getStatus();
            Driver driver=null;
            if(lastDriver>=0){
                driver=ListController.driverDetailsList[lastDriver];
            }else if(!lblDriver.getText().equals("")){
                for(Driver d:driverDetailsList){
                    if(d.getName().equals(lblDriver.getText())){
                        driver=d;
                        break;
                    }
                }
            }

            if(status.equals("Not Assigned")){
                saveAndProceeed(actionEvent.getSource(),vehicle,driver);
            }else if(status.equals("Parked")){
                if(actionEvent.getSource()==departButton){
                    saveAndProceeed(actionEvent.getSource(),vehicle,driver);
                }
            }else if(status.equals("Departed")){
                if(actionEvent.getSource()==parkButton){
                    saveAndProceeed(actionEvent.getSource(),vehicle,driver);
                }
            }
        }
    }

    private void saveAndProceeed(Object actionEventSource, Vehicle vehicle, Driver driver) throws IOException {
        setDateAndTime();
        String status = vehicle.getStatus();
        System.out.println("Old Status : "+status);
        if(actionEventSource==parkButton){
            vehicle.park();
            ListController.slotList[lastSlot].setAvailability(false);
            int nextIndex=nextIndex(ListController.parkedRecordList);
            if(nextIndex==ListController.parkedRecordList.length){
                ListController.parkedRecordList=expand(ListController.parkedRecordList);
            }
            ParkedRecord record=new ParkedRecord(vehicle.getVehicleNumber(),lblVehicleType.getText(),String.valueOf(ListController.slotList[lastSlot].getSlotId()),lblDate.getText()+" - "+lblTime.getText());
            ListController.parkedRecordList[nextIndex]=record;
        }else if(actionEventSource==departButton){
            if(vehicle.getStatus().equals("Parked")){
                ParkingSlot previousSlot=findPreviousSlot(vehicle.getVehicleNumber());
                previousSlot.setAvailability(true);
            }
            vehicle.depart();
            int nextIndex=nextIndex(departedRecordList);
            if(nextIndex==departedRecordList.length){
                departedRecordList=expand(departedRecordList);
            }
            DepartedRecord record=new DepartedRecord(vehicle.getVehicleNumber(),lblVehicleType.getText(),driver.getName(),lblDate.getText()+" - "+lblTime.getText());
            departedRecordList[nextIndex]=record;
        }
        driversSigningFormContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/DriversSigningForm.fxml")));
        status = vehicle.getStatus();
        System.out.println("New Status : "+status);
        lastVehicle=-1;
        lastDriver=-1;
        lastSlot=-1;
    }

    private ParkingSlot findPreviousSlot(String vehicleNumber) {
        ParkingSlot previousSlot=null;
        int lastIndex=nextIndex(parkedRecordList)-1;
        for(int i=lastIndex;i>=0;i--){
            if(parkedRecordList[i].getVehicleNumber().equals(vehicleNumber)){
                int slotId=Integer.valueOf(parkedRecordList[i].getParkingSlot());
                previousSlot=slotList[slotId-1];
            }
        }
        return previousSlot;
    }

    private ParkedRecord[] expand(ParkedRecord[] parkedRecordList) {
        int arrayLength= parkedRecordList.length;
        ParkedRecord[] temp=new ParkedRecord[arrayLength*2];
        for(int i=0;i<arrayLength;i++){
            temp[i]= parkedRecordList[i];
        }
        parkedRecordList =temp;
        return parkedRecordList;
    }

    private DepartedRecord[] expand(DepartedRecord[] departedRecordList) {
        int arrayLength= departedRecordList.length;
        DepartedRecord[] temp=new DepartedRecord[arrayLength*2];
        for(int i=0;i<arrayLength;i++){
            temp[i]=departedRecordList[i];
        }
        departedRecordList=temp;
        return departedRecordList;
    }

    private int nextIndex(Object[] list) {
        int nextIndex=0;
        for(int i=0;i<list.length;i++){
            if(list[i]==null){
               nextIndex=i;
               break;
            }
        }
        return nextIndex;
    }
}
