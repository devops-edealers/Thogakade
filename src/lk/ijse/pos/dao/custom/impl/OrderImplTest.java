package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.entity.Order;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

class OrderImplTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new OrderImplTest().save();
    }
    void save() throws SQLException, ClassNotFoundException {

        Order o1= new Order("O-1", new SimpleDateFormat("YYYY-MM-dd").
                format(new Date()),
                2500,"C-QXI8pXdQk7hi");
        Order o2= new Order("O-2", new SimpleDateFormat("YYYY-MM-dd").
                format(new Date()),
                45800,"C-QXI8pXdQk7hi");
        Order o3= new Order("O-3", new SimpleDateFormat("YYYY-MM-dd").
                format(new Date()),
                7500,"C-QXI8pXdQk7hi");
        Order o4= new Order("O-4", new SimpleDateFormat("YYYY-MM-dd").
                format(new Date()),
                7842,"C-bYKKUk6k57");
        Order o5= new Order("O-5", new SimpleDateFormat("YYYY-MM-dd").
                format(new Date()),
                9500,"C-bYKKUk6k57");
        new OrderImpl().save(o1);
        new OrderImpl().save(o2);
        new OrderImpl().save(o3);
        new OrderImpl().save(o4);
        new OrderImpl().save(o5);
    }
}