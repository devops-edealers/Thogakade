package lk.ijse.pos.dao;

import lk.ijse.pos.bo.custom.impl.CustomerBoImpl;
import lk.ijse.pos.bo.custom.impl.ItemBoImpl;
import lk.ijse.pos.dao.custom.CustomerDao;
import lk.ijse.pos.dao.custom.ItemDao;
import lk.ijse.pos.dao.custom.impl.CustomerDaoImpl;
import lk.ijse.pos.dao.custom.impl.ItemDaoImpl;
import lk.ijse.pos.db.DatabaseConnection;
import lk.ijse.pos.dto.CustomerDto;
import lk.ijse.pos.dto.ItemDto;
import lk.ijse.pos.dto.SystemUserDTO;
import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.entity.Item;
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

    // Item ===========

    public boolean saveItem(ItemDto dto) throws SQLException, ClassNotFoundException {
        return new ItemBoImpl().saveItem(dto);
    }

    public ArrayList<ItemDto> searchItem(String searchText) throws SQLException, ClassNotFoundException {
        return new ItemBoImpl().searchItem(searchText);
    }

    public boolean updateItem(ItemDto dto) throws SQLException, ClassNotFoundException {

        return new ItemBoImpl().updateItem(dto);

    }

    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
        return new ItemBoImpl().deleteItem(id);
    }

    // Item ===========

    // Customer ===========

    public boolean saveCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {
        return new CustomerBoImpl().saveCustomer(dto);

    }

    public ArrayList<CustomerDto> searchCustomer(String searchText) throws SQLException, ClassNotFoundException {
        return new CustomerBoImpl().searchCustomer(searchText);
    }

    public boolean updateCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {
        return new CustomerBoImpl().updateCustomer(dto);

    }

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return new CustomerBoImpl().deleteCustomer(id);
    }

    // Customer ===========


}
