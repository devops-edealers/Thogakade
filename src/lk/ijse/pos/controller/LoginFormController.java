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

public class LoginFormController {
    public AnchorPane loginContainer;
    public TextField txtEmail;
    public PasswordField txtPassword;

    public void signInOnAction(ActionEvent actionEvent) {
    }

    public void createAnAccountOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/SignupForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage stage = (Stage) loginContainer.getScene().getWindow();
        stage.setScene(new Scene(load));
        stage.centerOnScreen();
        stage.setTitle("Sign up");
    }
}
