package lk.ijse.pos.bo.custom;

import lk.ijse.pos.dto.SystemUserDTO;

import java.sql.SQLException;

public interface SystemUserBo {
    public boolean login(String email, String password) throws SQLException, ClassNotFoundException;
    public boolean registerUser(SystemUserDTO dto) throws SQLException, ClassNotFoundException;
}
