package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.*;

import java.io.IOException;

import static controller.ListController.driverDetailsList;

public class DriverAddingFormController {
    public AnchorPane addingFormContext;
    public JFXTextField txtDriverName;
    public JFXTextField txtDriversLicense;
    public JFXTextField txtAddress;
    public JFXTextField txtNIC;
    public JFXTextField txtContact;
    public Label lblError;

    private static int driverCount=0;

    public void backToDashboard(ActionEvent actionEvent) throws IOException {
        addingFormContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/ManagementDashboardForm.fxml")));
    }

    public void addDriver(ActionEvent actionEvent) throws IOException {
        if(!txtDriverName.getText().equals("") && !txtDriversLicense.getText().equals("") && !txtAddress.getText().equals("") && !txtNIC.getText().equals("") && !txtContact.getText().equals("")){
            if(driverCount<16){
                driverDetailsList[nextIndex()]=new Driver(txtDriverName.getText(),txtNIC.getText(),txtDriversLicense.getText(),txtContact.getText(),txtAddress.getText());
                driverCount++;
                addingFormContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/ManagementDashboardForm.fxml")));
            }else{
                lblError.setText("You have already exceeded the maximum number of Drivers. Please try again");
            }
        }
    }

    private int nextIndex() {
        Driver[] list=driverDetailsList;
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
