package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ManagementDashboardFormController {
    public JFXButton logoutButton;
    public AnchorPane dashboardContext;
    public JFXButton addVehicleButton;
    public JFXButton addDriverButton;
    public JFXComboBox cmbFieldList;
    public AnchorPane tableContext;
    public ImageView icon1;
    public ImageView icon2;

    public void initialize(){
        cmbFieldList.getItems().addAll("Parked","Departed");
        cmbFieldList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String field=(String)newValue;
            if(field.equals("Parked")){
                tableContext.getChildren().clear();
                try{
                    loadTableContext("ParkedTableForm");
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }else if(field.equals("Departed")){
                tableContext.getChildren().clear();
                try {
                    loadTableContext("DepartedTableForm");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //addVehicleButton.setStyle("-fx-background-color:transparent");
            //addDriverButton.setStyle("-fx-background-color: transparent");
            addDriverButton.getStyleClass().removeAll("button-selected");
            addVehicleButton.getStyleClass().removeAll("button-selected");
            icon1.setImage(new Image(getClass().getResourceAsStream("/assets/vehicleIcon01.png")));
            icon1.setPreserveRatio(false);
            icon2.setImage(new Image(getClass().getResourceAsStream("/assets/driverIcon01.png")));
            icon2.setPreserveRatio(false);
        });
    }

    private void loadTableContext(String tableForm) throws IOException {
        tableContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/"+tableForm+".fxml")));
    }

    public void backToDriverSigning(ActionEvent actionEvent) throws IOException {
        dashboardContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/DriversSigningForm.fxml")));
    }

    public void popUpVehicleAddingWindow(ActionEvent actionEvent) throws IOException {
        //addVehicleButton.setStyle("-fx-background-color:#29303A");
        //addDriverButton.setStyle("-fx-background-color: transparent");
        addVehicleButton.getStyleClass().add("button-selected");
        addDriverButton.getStyleClass().removeAll("button-selected");
        icon1.setImage(new Image(getClass().getResourceAsStream("/assets/vehicleIcon02.png")));
        icon1.setPreserveRatio(false);
        icon2.setImage(new Image(getClass().getResourceAsStream("/assets/driverIcon01.png")));
        icon2.setPreserveRatio(false);
        tableContext.getChildren().clear();
        loadAddingFormContext("Vehicle");
    }

    public void popUpDriverAddingWindow(ActionEvent actionEvent) throws IOException {
        //addDriverButton.setStyle("-fx-background-color:#29303A");
        //addVehicleButton.setStyle("-fx-background-color: transparent");
        addDriverButton.getStyleClass().add("button-selected");
        addVehicleButton.getStyleClass().removeAll("button-selected");
        icon1.setImage(new Image(getClass().getResourceAsStream("/assets/vehicleIcon01.png")));
        icon1.setPreserveRatio(false);
        icon2.setImage(new Image(getClass().getResourceAsStream("/assets/driverIcon02.png")));
        icon2.setPreserveRatio(false);
        tableContext.getChildren().clear();
        loadAddingFormContext("Driver");
    }

    private void loadAddingFormContext(String field) throws IOException {
        dashboardContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/"+field+"AddingForm.fxml")));
    }
}
