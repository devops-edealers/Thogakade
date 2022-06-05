package lk.ijse.pos.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.pos.dao.DatabaseAccessCode;
import lk.ijse.pos.dto.SystemUserDTO;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

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
        SystemUserDTO dto= new SystemUserDTO(txtName.getText(),txtEmail.getText().trim(),
                        txtPassword.getText().trim());
        try {
            if(new DatabaseAccessCode().createSystemUser(dto)){
                new Alert(Alert.AlertType.INFORMATION,"User Saved!",
                        ButtonType.CLOSE).show();
            }else{
                new Alert(Alert.AlertType.WARNING,"Something went wring!",
                        ButtonType.OK).show();
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
