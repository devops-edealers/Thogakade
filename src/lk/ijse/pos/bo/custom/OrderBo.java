package lk.ijse.pos.bo.custom;

import lk.ijse.pos.dto.OrderDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderBo {
    public ArrayList<OrderDto> getAllOrders() throws SQLException, ClassNotFoundException;
}
