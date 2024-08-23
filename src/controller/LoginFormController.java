package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LoginFormController {
    public AnchorPane loginFormContext;
    public JFXTextField usernameField;
    public JFXPasswordField passwordField;

    public void backToHome(ActionEvent actionEvent) throws IOException {
        //loginFormContext.getChildren().clear();
        loginFormContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/DriversSigningForm.fxml")));
    }

    public void logIntoDashboard(ActionEvent actionEvent) throws IOException {
        loginFormContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/ManagementDashboardForm.fxml")));
    }

    public void moveToPassword(ActionEvent actionEvent) {
        passwordField.requestFocus();
    }

}
