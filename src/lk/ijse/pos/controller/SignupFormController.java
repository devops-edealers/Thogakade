package lk.ijse.pos.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class SignupFormController {
    public AnchorPane registerContainer;
    public TextField txtName;
    public PasswordField txtPassword;
    public TextField txtEmail;

    public void alreadyHavAnOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/LoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage stage = (Stage) registerContainer.getScene().getWindow();
        stage.setScene(new Scene(load));
        stage.centerOnScreen();
        stage.setTitle("Login Form");
    }

    public void registerOnAction(ActionEvent actionEvent) {
    }
}
