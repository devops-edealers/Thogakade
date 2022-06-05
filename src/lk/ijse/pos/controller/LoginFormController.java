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

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

public class LoginFormController {
    public AnchorPane loginContainer;
    public TextField txtEmail;
    public PasswordField txtPassword;

    public void signInOnAction(ActionEvent actionEvent) {
        try {

            if (new DatabaseAccessCode().login(txtEmail.getText().trim(), txtPassword.getText().trim())) {
                setUI("DashboardForm","Dashboard");
            }else{
                new Alert(Alert.AlertType.WARNING, "User not found", ButtonType.OK).show();
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void createAnAccountOnAction(ActionEvent actionEvent) throws IOException {
        setUI("SignupForm","Sign up");
    }
    private void setUI(String location, String title) throws IOException {
        Stage stage = (Stage) loginContainer.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader
                .load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
        stage.setTitle(title);
    }
}
