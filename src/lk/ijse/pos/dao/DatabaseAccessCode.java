package lk.ijse.pos.dao;

import lk.ijse.pos.db.DatabaseConnection;
import lk.ijse.pos.dto.CustomerDto;
import lk.ijse.pos.dto.SystemUserDTO;
import lk.ijse.pos.util.IdGenerator;

import java.sql.*;
import java.util.ArrayList;

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

    public ArrayList<CustomerDto> searchCustomer(String searchText) throws SQLException, ClassNotFoundException {
        searchText = "%" + searchText + "%";
        ArrayList<CustomerDto> dtoList = new ArrayList<>();
        ResultSet set = CrudUtil.
                execute("SELECT * FROM customer WHERE name LIKE? OR address LIKE?",
                        searchText, searchText);
        while (set.next()) {
            dtoList.add(
                    new CustomerDto(set.getString(1), set.getString(2),
                            set.getString(3), set.getDouble(4))
            );
        }
        return dtoList;
    }

    public boolean updateCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {

        return CrudUtil.execute("UPDATE customer SET name=?, address=?, salary=? WHERE id=?",
                dto.getName(),
                dto.getAddress(),
                dto.getSalary(),
                dto.getId());
    }

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM customer WHERE id=?", id);
    }

    // Customer ===========

    // Item ===========

    // to be implemented

    // Item ===========


}
