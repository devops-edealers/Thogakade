package lk.ijse.pos.dao;

import lk.ijse.pos.db.DatabaseConnection;
import lk.ijse.pos.dto.CustomerDto;
import lk.ijse.pos.dto.SystemUserDTO;
import lk.ijse.pos.util.IdGenerator;

import java.sql.*;

public class DatabaseAccessCode {
    // system user===========
    public boolean createSystemUser(SystemUserDTO dto)
            throws ClassNotFoundException, SQLException {
        return CrudUtil.execute("INSERT INTO system_user VALUES (?,?,?)"
                , dto.getName(), dto.getEmail(), dto.getPassword());
    }

    public boolean login(String email, String password) throws ClassNotFoundException, SQLException {
        ResultSet resultSet =
                CrudUtil.execute("SELECT * FROM system_user WHERE email =? AND password=?",
                        email, password);
        return resultSet.next();
    }

    // system user===========

    // Customer ===========

    public boolean saveCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {
        dto.setId(IdGenerator.getId());
        System.out.println(dto);
        return CrudUtil.execute("INSERT INTO customer VALUES(?,?,?,?)",
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getSalary());
    }

    // Customer ===========


}
