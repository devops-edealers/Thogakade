package lk.ijse.pos.dao;

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
        return new ItemDaoImpl().save(
                new Item(dto.getCode(),
                        dto.getDescription(),
                        dto.getQtyOnHand(),
                        dto.getUnitPrice())
        );
    }

    public ArrayList<ItemDto> searchItem(String searchText) throws SQLException, ClassNotFoundException {
        ArrayList<ItemDto> dtoList = new ArrayList<>();
        for (Item i : new ItemDaoImpl().searchItems(searchText)
        ) {
            dtoList.add(
                    new ItemDto(
                            i.getCode(), i.getDescription(), i.getQtyOnHand(), i.getUnitPrice()
                    )
            );
        }
        return dtoList;

    }

    public boolean updateItem(ItemDto dto) throws SQLException, ClassNotFoundException {

        return new ItemDaoImpl().update(
                new Item(dto.getCode(),
                        dto.getDescription(),
                        dto.getQtyOnHand(),
                        dto.getUnitPrice())
        );
    }

    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
        return new ItemDaoImpl().delete(id);
    }

    // Item ===========

    // Customer ===========

    public boolean saveCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {
        return new CustomerDaoImpl().save(new Customer(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getSalary()
        ));
    }

    public ArrayList<CustomerDto> searchCustomer(String searchText) throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDto> dtoList = new ArrayList<>();
        for (Customer c : new CustomerDaoImpl().searchCustomer(searchText)
        ) {
            dtoList.add(new CustomerDto(
                    c.getId(), c.getName(), c.getAddress(), c.getSalary()
            ));
        }
        return dtoList;
    }

    public boolean updateCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {

        return new CustomerDaoImpl().update(new Customer(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getSalary()
        ));
    }

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return new CustomerDaoImpl().delete(id);
    }

    // Customer ===========


}
