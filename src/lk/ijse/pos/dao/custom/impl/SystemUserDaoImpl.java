package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.SystemUserDao;
import lk.ijse.pos.db.HibernateUtil;
import lk.ijse.pos.entity.SystemUser;
import lk.ijse.pos.util.SecurityConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SystemUserDaoImpl implements SystemUserDao {
    @Override
    public boolean save(SystemUser systemUser) throws SQLException, ClassNotFoundException {
       try(Session session = new HibernateUtil().getSession()){
           Transaction transaction = session.beginTransaction();
           systemUser.setPassword
                   (SecurityConfig.encrypt(systemUser.getPassword(),
                           SecurityConfig.holdingSecretKey));
           session.save(systemUser);
           transaction.commit();
           return true;
       }// try-resource
    }

    @Override
    public boolean update(SystemUser systemUser) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public SystemUser get(String s) {
        return null;
    }

    @Override
    public ArrayList<SystemUser> getAll() {
        return null;
    }

    @Override
    public boolean login(String email, String password) throws SQLException, ClassNotFoundException {

        try(Session session = new HibernateUtil().getSession()){
            SystemUser systemUser = session.find(SystemUser.class, email);
            if (systemUser!=null){
                String decryptPassword
                        = SecurityConfig.decrypt(systemUser.getPassword(), SecurityConfig.holdingSecretKey);
                return decryptPassword.equals(password);
            }else{
                return false;
            }
        }// try-resource

    }
}
