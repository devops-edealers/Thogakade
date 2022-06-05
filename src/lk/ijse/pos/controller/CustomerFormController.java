package lk.ijse.pos.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerFormController {
    public TextField txtName;
    public TextField txtSalary;
    public TextField txtAddress;
    public TextField txtSearch;
    public TableView tblCustomer;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colSalary;
    public TableColumn colOption;
    public AnchorPane customerContainer;

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) customerContainer.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader
                .load(getClass().getResource("../view/DashboardForm.fxml"))));
        stage.centerOnScreen();
        stage.setTitle("Dashboard");
    }

    public void newCustomerOnAction(ActionEvent actionEvent) {
    }

    public void saveCustomerOnActopn(ActionEvent actionEvent) {
    }
}
