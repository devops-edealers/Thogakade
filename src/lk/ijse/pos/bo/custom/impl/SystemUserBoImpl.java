package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.SystemUserBo;
import lk.ijse.pos.dao.DaoFactory;
import lk.ijse.pos.dao.custom.ItemDao;
import lk.ijse.pos.dao.custom.SystemUserDao;
import lk.ijse.pos.dto.SystemUserDTO;
import lk.ijse.pos.entity.SystemUser;

import java.sql.SQLException;

public class SystemUserBoImpl implements SystemUserBo {
    private SystemUserDao systemUserDao= DaoFactory.getInstance().getDao(DaoFactory.DaoType.SYSTEM_USER);

    @Override
    public boolean login(String email, String password) throws SQLException, ClassNotFoundException {
        return systemUserDao.login(email, password);
    }

    @Override
    public boolean registerUser(SystemUserDTO dto) throws SQLException, ClassNotFoundException {
        return systemUserDao.save(
                new SystemUser(dto.getName(),dto.getEmail(),dto.getPassword())
        );
    }
}
