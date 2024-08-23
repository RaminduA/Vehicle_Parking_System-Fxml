package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.ParkedRecord;

public class ParkedTableFormController {
    public TableView tblParkedVehicles;
    public TableColumn colVehicleNumber;
    public TableColumn colVehicleType;
    public TableColumn colParkingSlot;
    public TableColumn colParkedTime;

    public void initialize(){
        ParkedRecord[] tableList=new ParkedRecord[listLength(ListController.parkedRecordList)];
        for(int i=0;i<tableList.length;i++){
            tableList[i]=ListController.parkedRecordList[i];
        }
        ObservableList<ParkedRecord> ob= FXCollections.observableArrayList();
        for(ParkedRecord record:tableList) {
            ob.add(record);
        }
        tblParkedVehicles.setItems(ob);
        colVehicleNumber.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colParkingSlot.setCellValueFactory(new PropertyValueFactory<>("parkingSlot"));
        colParkedTime.setCellValueFactory(new PropertyValueFactory<>("parkedTime"));
    }

    private int listLength(ParkedRecord[] list) {
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
