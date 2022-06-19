package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.CustomerDao;
import lk.ijse.pos.db.HibernateUtil;
import lk.ijse.pos.dto.CustomerDto;
import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.entity.SystemUser;
import lk.ijse.pos.util.IdGenerator;
import lk.ijse.pos.util.SecurityConfig;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public List<Customer> searchCustomer(String searchText) throws SQLException, ClassNotFoundException {
        try (Session session = new HibernateUtil().getSession()) {
            Criteria criteria = session.createCriteria(Customer.class);
            criteria.add(Restrictions.like("name",searchText, MatchMode.START));
            return criteria.list();
        }// try-resource
    }

    @Override
    public boolean save(Customer customer) throws SQLException, ClassNotFoundException {
        customer.setId(IdGenerator.getId());
        try (Session session = new HibernateUtil().getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
            return true;
        }// try-resource
    }

    @Override
    public boolean update(Customer customer) throws SQLException, ClassNotFoundException {
        try (Session session = new HibernateUtil().getSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(customer);
            transaction.commit();
            return true;
        }// try-resource
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        try (Session session = new HibernateUtil().getSession()) {
            session.delete(session.find(Customer.class,s));
            return true;
        }// try-resource
    }

    @Override
    public Customer get(String s) {
        return null;
    }

    @Override
    public ArrayList<Customer> getAll() {
        return null;
    }
}
