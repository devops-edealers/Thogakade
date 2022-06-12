package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.SystemUserDao;
import lk.ijse.pos.entity.SystemUser;
import lk.ijse.pos.util.SecurityConfig;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SystemUserDaoImpl implements SystemUserDao {
    @Override
    public boolean save(SystemUser systemUser) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO system_user VALUES (?,?,?)"
                , systemUser.getName(), systemUser.getEmail(),
                SecurityConfig.encrypt(systemUser.getPassword(),SecurityConfig.holdingSecretKey)
                );
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
        ResultSet resultSet =
                CrudUtil.execute("SELECT * FROM system_user WHERE email =? AND password=?",
                        email, password);
        return resultSet.next();
    }
}
