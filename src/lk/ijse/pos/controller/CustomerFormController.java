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
import lk.ijse.pos.bo.BoFactory;
import lk.ijse.pos.bo.custom.CustomerBo;
import lk.ijse.pos.dto.CustomerDto;
import lk.ijse.pos.view.tm.CustomerTM;

import java.io.IOException;
import java.sql.SQLException;

public class CustomerFormController {
    public TextField txtName;
    public TextField txtSalary;
    public TextField txtAddress;
    public TextField txtSearch;
    public TableView<CustomerTM> tblCustomer;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colSalary;
    public TableColumn colOption;
    public AnchorPane customerContainer;
    public Button btnSaveUpdate;

    private CustomerBo customerBo= BoFactory.getInstance().getBo(BoFactory.BoType.CUSTOMER);

    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));
        loadAllCustomers("");

        /*listener*/
        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            loadAllCustomers(newValue);
        });


        tblCustomer.getSelectionModel().selectedItemProperty().addListener
                ((observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        setData(newValue);
                    }
                });
        /*listener*/
    }

    private String id = "";

    private void setData(CustomerTM value) {
        btnSaveUpdate.setText("Update Customer");
        id = value.getId();
        txtName.setText(value.getName());
        txtSalary.setText(String.valueOf(value.getSalary()));
        txtAddress.setText(value.getAddress());
    }

    private void loadAllCustomers(String text) {
        ObservableList<CustomerTM> tmList = FXCollections.observableArrayList();
        try {
            for (CustomerDto dto : customerBo.searchCustomer(text)
            ) {
                Button btn = new Button("Delete");
                CustomerTM tm = new CustomerTM(
                        dto.getId(), dto.getName(), dto.getAddress(), dto.getSalary(),
                        btn
                );
                tmList.add(tm);
                /*=======*/
                btn.setOnAction((e)->{

                    Alert alert= new Alert(Alert.AlertType.CONFIRMATION,
                            "Are you sure whether do you want to delete this customer?",
                            ButtonType.YES, ButtonType.NO);
                    alert.showAndWait();
                    if (alert.getResult()==ButtonType.YES){
                        try {
                            if (customerBo.deleteCustomer(tm.getId())){
                                new Alert(Alert.AlertType.INFORMATION, "Deleted",
                                        ButtonType.OK).show();
                                loadAllCustomers("");
                            }

                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        } catch (ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    }

                });
                /*=======*/

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
        btnSaveUpdate.setText("Save Customer");
        clearData();
    }

    public void saveCustomerOnActopn(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (btnSaveUpdate.getText().equalsIgnoreCase("Save Customer")) {
            CustomerDto dto = new CustomerDto("", txtName.getText(), txtAddress.getText(),
                    Double.parseDouble(txtSalary.getText())
            );
            if (customerBo.saveCustomer(dto)) {
                loadAllCustomers("");
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!", ButtonType.CANCEL).show();
            } else {
                new Alert(Alert.AlertType.WARNING, " Try Again", ButtonType.OK).show();
            }
        } else {
            if (id.length()==0)return;
            CustomerDto dto = new CustomerDto(id, txtName.getText(), txtAddress.getText(),
                    Double.parseDouble(txtSalary.getText())
            );
            if (customerBo.updateCustomer(dto)) {
                loadAllCustomers("");
                new Alert(Alert.AlertType.CONFIRMATION, "Updated!", ButtonType.CANCEL).show();
            } else {
                new Alert(Alert.AlertType.WARNING, " Try Again", ButtonType.OK).show();
            }
        }
    }

    private void clearData() {
        txtAddress.clear();
        txtName.clear();
        txtSalary.clear();
    }

}
