package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DepartedRecord;

public class DepartedTableFormController {
    public TableView tblDepartedVehicles;
    public TableColumn colVehicleNumber;
    public TableColumn colVehicleType;
    public TableColumn colDriverName;
    public TableColumn colDepartedTime;

    public void initialize(){
        DepartedRecord[] tableList=new DepartedRecord[listLength(ListController.departedRecordList)];
        for(int i=0;i<tableList.length;i++){
            tableList[i]=ListController.departedRecordList[i];
        }
        ObservableList<DepartedRecord> ob= FXCollections.observableArrayList();
        for(DepartedRecord record:tableList) {
            ob.add(record);
        }

        tblDepartedVehicles.setItems(ob);
        colVehicleNumber.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colDriverName.setCellValueFactory(new PropertyValueFactory<>("driverName"));
        colDepartedTime.setCellValueFactory(new PropertyValueFactory<>("departedTime"));
    }

    private int listLength(DepartedRecord[] list) {
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
