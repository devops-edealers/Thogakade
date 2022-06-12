package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.OrderDao;
import lk.ijse.pos.entity.Order;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderImpl implements OrderDao {
    @Override
    public boolean save(Order order) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO `Order` VALUES (?,?,?,?)",
                order.getId(), order.getDate(),
                order.getCost(), order.getCustomer());
    }

    @Override
    public boolean update(Order order) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Order get(String s) {
        return null;
    }

    @Override
    public ArrayList<Order> getAll() {
        return null;
    }
}
