package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.Bus;
import model.CargoLorry;
import model.Van;
import model.Vehicle;

import java.io.IOException;

import static controller.ListController.vehicleDetailsList;

public class VehicleAddingFormController {
    public AnchorPane addingFormContext;
    public JFXTextField txtVehicleNumber;
    public JFXComboBox cmbVehicleType;
    public JFXTextField txtMaxWeight;
    public JFXTextField txtPassengerCount;
    public Label lblError;

    private String selectedType="";
    private static int busCount=0;
    private static int vanCount=0;
    private static int cargoLorryCount=0;

    public void initialize(){
        cmbVehicleType.getItems().addAll("Bus","Van","Cargo Lorry");
        cmbVehicleType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedType=(String)newValue;
         });
    }

    public void backToDashboard(ActionEvent actionEvent) throws IOException {
        addingFormContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/ManagementDashboardForm.fxml")));
    }

    public void addVehicle(ActionEvent actionEvent) throws IOException {
        if(!txtVehicleNumber.getText().equals("") && !selectedType.equals("") && !txtMaxWeight.getText().equals("") && !txtPassengerCount.getText().equals("")){
            if(selectedType.equals("Bus")){
                if(busCount<1){
                    vehicleDetailsList[nextIndex()]=new Bus(txtVehicleNumber.getText(),Integer.valueOf(txtMaxWeight.getText()),Integer.valueOf(txtPassengerCount.getText()),"Not Assigned");
                    busCount++;
                    addingFormContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/ManagementDashboardForm.fxml")));
                }else{
                    lblError.setText("You have already exceeded the maximum number of Buses. Please try again");
                }
            }else if(selectedType.equals("Van")){
                if(vanCount<6){
                    vehicleDetailsList[nextIndex()]=new Van(txtVehicleNumber.getText(),Integer.valueOf(txtMaxWeight.getText()),Integer.valueOf(txtPassengerCount.getText()),"Not Assigned");
                    vanCount++;
                    addingFormContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/ManagementDashboardForm.fxml")));
                }else{
                    lblError.setText("You have already exceeded the maximum number of Vans. Please try again");
                }
            }else if(selectedType.equals("Cargo Lorry")){
                if(cargoLorryCount<6){
                    vehicleDetailsList[nextIndex()]=new CargoLorry(txtVehicleNumber.getText(),Integer.valueOf(txtMaxWeight.getText()),Integer.valueOf(txtPassengerCount.getText()),"Not Assigned");
                    cargoLorryCount++;
                    addingFormContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/ManagementDashboardForm.fxml")));
                }else{
                    lblError.setText("You have already exceeded the maximum number of Cargo Lorries. Please try again");
                }
            }
            selectedType="";
        }
    }

    private int nextIndex() {
        Vehicle[] list=vehicleDetailsList;
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
