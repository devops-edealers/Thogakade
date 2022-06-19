package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.OrderDao;
import lk.ijse.pos.db.HibernateUtil;
import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.entity.Order;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Override
    public boolean save(Order order) throws SQLException, ClassNotFoundException {

        try (Session session = new HibernateUtil().getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
            return true;
        }// try-resource
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
    public List<Order> getAll() throws SQLException, ClassNotFoundException {
        try (Session session = new HibernateUtil().getSession()) {
            Query query = session.createQuery("FROM Orders");
            return query.list();
        }// try-resource
    }
}
