package lk.ijse.pos.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.pos.dao.DatabaseAccessCode;
import lk.ijse.pos.dto.CustomerDto;

import java.io.IOException;
import java.sql.SQLException;

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
        CustomerDto dto= new CustomerDto("",txtName.getText(),txtAddress.getText(),
                Double.parseDouble(txtSalary.getText())
        );
        try {
            if (new DatabaseAccessCode().saveCustomer(dto)){
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!", ButtonType.CANCEL).show();
            }else{
                new Alert(Alert.AlertType.WARNING," Try Again", ButtonType.OK).show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveCustomerOnActopn(ActionEvent actionEvent) {
    }
}
