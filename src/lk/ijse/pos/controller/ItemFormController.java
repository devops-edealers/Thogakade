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
import lk.ijse.pos.dto.ItemDto;
import lk.ijse.pos.view.tm.CustomerTM;
import lk.ijse.pos.view.tm.ItemTm;

import java.io.IOException;
import java.sql.SQLException;

public class ItemFormController {
    public AnchorPane ItemContainer;
    public TextField txtDescription;
    public TextField txtUnitPrice;
    public TextField txtQtyOnHand;
    public Button btnSaveUpdate;
    public TextField txtSearch;
    public TableView<ItemTm> tblItem;
    public TableColumn colCode;
    public TableColumn colDescription;
    public TableColumn colUnitPrice;
    public TableColumn colQtyOnHand;
    public TableColumn colOption;


    public void initialize() {
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colQtyOnHand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));
        loadAllItems("");

        /*listener*/
        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            loadAllItems(newValue);
        });


        tblItem.getSelectionModel().selectedItemProperty().addListener
                ((observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        setData(newValue);
                    }
                });
        /*listener*/
    }
    private String code = "";

    private void setData(ItemTm value) {
        btnSaveUpdate.setText("Update Item");
        code = value.getCode();
        txtDescription.setText(value.getDescription());
        txtQtyOnHand.setText(String.valueOf(value.getQtyOnHand()));
        txtUnitPrice.setText(String.valueOf(value.getUnitPrice()));
    }

    private void loadAllItems(String text) {
        ObservableList<ItemTm> tmList = FXCollections.observableArrayList();
        try {
            for (ItemDto dto : new DatabaseAccessCode().searchItem(text)
            ) {
                Button btn = new Button("Delete");
                ItemTm tm = new ItemTm(
                        dto.getCode(), dto.getDescription(), dto.getQtyOnHand(), dto.getUnitPrice(),
                        btn
                );
                tmList.add(tm);
                /*=======*/
                btn.setOnAction((e)->{

                    Alert alert= new Alert(Alert.AlertType.CONFIRMATION,
                            "Are you sure whether do you want to delete this Item?",
                            ButtonType.YES, ButtonType.NO);
                    alert.showAndWait();
                    if (alert.getResult()==ButtonType.YES){
                        try {
                            if (new DatabaseAccessCode().deleteItem(tm.getCode())){
                                new Alert(Alert.AlertType.INFORMATION, "Deleted",
                                        ButtonType.OK).show();
                                loadAllItems("");
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
            tblItem.setItems(tmList);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveItemOnActopn(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (btnSaveUpdate.getText().equalsIgnoreCase("Save Item")) {
            ItemDto dto = new ItemDto("", txtDescription.getText(),Integer.parseInt( txtQtyOnHand.getText()),
                    Double.parseDouble(txtUnitPrice.getText())
            );
            if (new DatabaseAccessCode().saveItem(dto)) {
                loadAllItems("");
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!", ButtonType.CANCEL).show();
            } else {
                new Alert(Alert.AlertType.WARNING, " Try Again", ButtonType.OK).show();
            }
        } else {
            if (code.length()==0)return;
            ItemDto dto = new ItemDto(code, txtDescription.getText(),Integer.parseInt( txtQtyOnHand.getText()),
                    Double.parseDouble(txtUnitPrice.getText())
            );
            if (new DatabaseAccessCode().updateItem(dto)) {
                loadAllItems("");
                new Alert(Alert.AlertType.CONFIRMATION, "Updated!", ButtonType.CANCEL).show();
            } else {
                new Alert(Alert.AlertType.WARNING, " Try Again", ButtonType.OK).show();
            }
        }
    }

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ItemContainer.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader
                .load(getClass().getResource("../view/DashboardForm.fxml"))));
        stage.centerOnScreen();
        stage.setTitle("Dashboard");
    }

    public void newSaveItemOnAction(ActionEvent actionEvent) {
        btnSaveUpdate.setText("Save Item");
        clearData();
    }
    private void clearData() {
        txtDescription.clear();
        txtUnitPrice.clear();
        txtQtyOnHand.clear();
    }
}
