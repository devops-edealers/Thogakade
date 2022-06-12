package lk.ijse.pos.dao.custom;

import lk.ijse.pos.dao.CrudDao;
import lk.ijse.pos.entity.SystemUser;

import java.sql.SQLException;

public interface SystemUserDao extends CrudDao<SystemUser, String> {
    public boolean login(String email, String password) throws SQLException, ClassNotFoundException;
}
