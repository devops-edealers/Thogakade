package lk.ijse.pos.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.pos.bo.BoFactory;
import lk.ijse.pos.bo.custom.OrderBo;
import lk.ijse.pos.dto.OrderDto;
import lk.ijse.pos.entity.Order;
import lk.ijse.pos.view.tm.OrderTM;

import java.sql.SQLException;

public class OrderFormController {


    public TableView<OrderTM> tblOrders;
    public TableColumn colOrderId;
    public TableColumn colDate;
    public TableColumn colCost;

    private OrderBo bo = BoFactory.getInstance().getBo(BoFactory.BoType.ORDER);

    public void initialize() throws SQLException, ClassNotFoundException {
        colOrderId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        loadAllOrders();
    }

    ObservableList<OrderTM> obList= FXCollections.observableArrayList();
    private void loadAllOrders() throws SQLException, ClassNotFoundException {
        for (OrderDto dto:bo.getAllOrders()
             ) {
            obList.add(
                    new OrderTM(dto.getId(),dto.getDate(),dto.getCost())
            );
        }
        tblOrders.setItems(obList);
    }

}
