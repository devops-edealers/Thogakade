package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.OrderBo;
import lk.ijse.pos.dao.DaoFactory;
import lk.ijse.pos.dao.custom.OrderDao;
import lk.ijse.pos.dto.OrderDto;
import lk.ijse.pos.entity.Order;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderBoImpl implements OrderBo {

    private OrderDao orderDao =
            DaoFactory.getInstance().getDao(
                    DaoFactory.DaoType.ORDER
            );

    @Override
    public ArrayList<OrderDto> getAllOrders() throws SQLException, ClassNotFoundException {
        ArrayList<OrderDto> list = new ArrayList<>();
        for (Order o : orderDao.getAll()
        ) {
            list.add(new OrderDto(
                    o.getId(), o.getDate(), o.getCost(), o.getCustomer()
            ));
        }
        return list;
    }
}
