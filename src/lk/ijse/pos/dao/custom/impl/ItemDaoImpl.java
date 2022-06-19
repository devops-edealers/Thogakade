package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.ItemDao;
import lk.ijse.pos.db.HibernateUtil;
import lk.ijse.pos.dto.ItemDto;
import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.entity.Item;
import lk.ijse.pos.util.IdGenerator;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDao {
    @Override
    public List<Item> searchItems(String searchText) throws SQLException, ClassNotFoundException {
        try (Session session = new HibernateUtil().getSession()) {
            Criteria criteria = session.createCriteria(Item.class);
            criteria.add(Restrictions.like("description",searchText, MatchMode.START));
            return criteria.list();
        }// try-resource
    }

    @Override
    public boolean save(Item item) throws SQLException, ClassNotFoundException {
        item.setCode(IdGenerator.getId());
        try (Session session = new HibernateUtil().getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(item);
            transaction.commit();
            return true;
        }// try-resource
    }

    @Override
    public boolean update(Item item) throws SQLException, ClassNotFoundException {
        try (Session session = new HibernateUtil().getSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(item);
            transaction.commit();
            return true;
        }// try-resource
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        try (Session session = new HibernateUtil().getSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(session.find(Item.class, s));
            transaction.commit();
            return true;
        }// try-resource
    }

    @Override
    public Item get(String s) {
        return null;
    }

    @Override
    public ArrayList<Item> getAll() {
        return null;
    }
}
