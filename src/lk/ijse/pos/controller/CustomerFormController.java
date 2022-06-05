package lk.ijse.pos.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.pos.dao.DatabaseAccessCode;
import lk.ijse.pos.dto.CustomerDto;
import lk.ijse.pos.view.tm.CustomerTM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));
        loadAllCustomers("");
    }

    private void loadAllCustomers(String text) {
        ObservableList<CustomerTM> tmList = FXCollections.observableArrayList();
        try {
            for (CustomerDto dto : new DatabaseAccessCode().searchCustomer(text)
            ) {
                Button btn = new Button("Delete");
                CustomerTM tm = new CustomerTM(
                        dto.getId(), dto.getName(), dto.getAddress(), dto.getSalary(),
                        btn
                );
                tmList.add(tm);
            }
            tblCustomer.setItems(tmList);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

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
        CustomerDto dto = new CustomerDto("", txtName.getText(), txtAddress.getText(),
                Double.parseDouble(txtSalary.getText())
        );
        try {
            if (new DatabaseAccessCode().saveCustomer(dto)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!", ButtonType.CANCEL).show();
            } else {
                new Alert(Alert.AlertType.WARNING, " Try Again", ButtonType.OK).show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void clearData() {
        txtAddress.clear();
        txtName.clear();
        txtSalary.clear();
    }

}
