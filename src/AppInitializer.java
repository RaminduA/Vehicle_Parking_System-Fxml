import controller.ListController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.*;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        createSlotList();
        //createDriverDetailsList();
        //createVehicleDetailsList();

        launch(args);
    }

    private static void createVehicleDetailsList() {
        ListController.vehicleDetailsList[0]=new Bus("NA-3434",3500,60,"Not Assigned");
        ListController.vehicleDetailsList[1]=new Van("KA-4563",1000,7,"Not Assigned");
        ListController.vehicleDetailsList[2]=new Van("58-3567",1500,4,"Not Assigned");
        ListController.vehicleDetailsList[3]=new Van("GF-4358",800,4,"Not Assigned");
        ListController.vehicleDetailsList[4]=new Van("CCB-3568",1800,8,"Not Assigned");
        ListController.vehicleDetailsList[5]=new Van("LM-6679",1500,4,"Not Assigned");
        ListController.vehicleDetailsList[6]=new Van("QA-3369",1800,6,"Not Assigned");
        ListController.vehicleDetailsList[7]=new CargoLorry("KB-3668",2500,2,"Not Assigned");
        ListController.vehicleDetailsList[8]=new CargoLorry("JJ-9878",3000,2,"Not Assigned");
        ListController.vehicleDetailsList[9]=new CargoLorry("GH-5772",4000,3,"Not Assigned");
        ListController.vehicleDetailsList[10]=new CargoLorry("XY-4456",3500,2,"Not Assigned");
        ListController.vehicleDetailsList[11]=new CargoLorry("YQ-3536",2000,2,"Not Assigned");
        ListController.vehicleDetailsList[12]=new CargoLorry("CBB-3566",2500,2,"Not Assigned");
        ListController.vehicleDetailsList[13]=new CargoLorry("QH-3444",5000,4,"Not Assigned");
    }

    private static void createDriverDetailsList() {
        ListController.driverDetailsList[0]=new Driver("Sumith Kumara","7835348345V","B6474845","Panadura","0725637456");
        ListController.driverDetailsList[1]=new Driver("Amila Pathirana","8826253734V","B3354674","Galle","0717573583");
        ListController.driverDetailsList[2]=new Driver("Jithmal Perera","9283289272V","B3674589","Horana","0772452457");
        ListController.driverDetailsList[3]=new Driver("Sumith Dissanayaka","9425245373V","B8366399","Kaluthara","0782686390");
        ListController.driverDetailsList[4]=new Driver("Sumanasiri Herath","8976544373V","B3537538","Beruwala","0772534436");
        ListController.driverDetailsList[5]=new Driver("Awantha Fernando","9173537839V","B3554789","Colombo 5","0714534356");
        ListController.driverDetailsList[6]=new Driver("Charith Sudara","9573536833V","B6835836","Baththaramulla","0771536662");
        ListController.driverDetailsList[7]=new Driver("Prashan Dineth","9362426738V","B2683536","Wadduwa","0715353434");
        ListController.driverDetailsList[8]=new Driver("Chethiya Dilan","9162353436V","B6836836","Panadura","0772436737");
        ListController.driverDetailsList[9]=new Driver("Dushantha Perera","9255556343V","B3334435","Matara","0777245343");
        ListController.driverDetailsList[10]=new Driver("Sumith Udayanga","8735354355V","B3573783","Galle","0703635442");
        ListController.driverDetailsList[11]=new Driver("Dinesh Udara","9026344373V","B5343783","Hettimulla","0713456878");
        ListController.driverDetailsList[12]=new Driver("Udana Chathuranga","9692653338V","B7888632","Kottawa","0772442444");
        ListController.driverDetailsList[13]=new Driver("Mohommad Riaz","9124537733V","B3638537","Kaluthara","0777544222");
        ListController.driverDetailsList[14]=new Driver("Sandun Kumara","9563524267V","B2263333","Panadura","0772325544");
        ListController.driverDetailsList[15]=new Driver("Priyanga Perera","9135343537V","B3853753","Matara","0723344562");
    }

    private static void createSlotList() {
        for(int i=0;i< ListController.slotList.length;i++){
            ParkingSlot slotX=new ParkingSlot();
            slotX.setSlotId(i+1);
            slotX.setAvailability(true);
            if((i+1)==1||(i+1)==2||(i+1)==3||(i+1)==4||(i+1)==12||(i+1)==13){
                slotX.setVehicleType("Van");
            }else if((i+1)==14){
                slotX.setVehicleType("Bus");
            }else{
                slotX.setVehicleType("Cargo Lorry");
            }
            slotX.setSlotPane(new AnchorPane());
            ListController.slotList[i]=slotX;
        }
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Scene scene=new Scene(FXMLLoader.load(getClass().getResource("view/DriversSigningForm.fxml")));
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
