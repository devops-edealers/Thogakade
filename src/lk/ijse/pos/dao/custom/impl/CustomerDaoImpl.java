package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.CustomerDao;
import lk.ijse.pos.dto.CustomerDto;
import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.util.IdGenerator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public ArrayList<Customer> searchCustomer(String searchText) throws SQLException, ClassNotFoundException {
        searchText = "%" + searchText + "%";
        ArrayList<Customer> dtoList = new ArrayList<>();
        ResultSet set = CrudUtil.
                execute("SELECT * FROM customer WHERE name LIKE? OR address LIKE?",
                        searchText, searchText);
        while (set.next()) {
            dtoList.add(
                    new Customer(set.getString(1), set.getString(2),
                            set.getString(3), set.getDouble(4))
            );
        }
        return dtoList;
    }

    @Override
    public boolean save(Customer customer) throws SQLException, ClassNotFoundException {
        customer.setId(IdGenerator.getId());
        return CrudUtil.execute("INSERT INTO customer VALUES(?,?,?,?)",
                customer.getId(),
                customer.getName(),
                customer.getAddress(),
                customer.getSalary());
    }

    @Override
    public boolean update(Customer customer) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE customer SET name=?, address=?, salary=? WHERE id=?",
                customer.getName(),
                customer.getAddress(),
                customer.getSalary(),
                customer.getId());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM customer WHERE id=?", s);
    }

    @Override
    public Customer get(String s) {
        return null;
    }

    @Override
    public ArrayList<Customer> getAll() {
        return null;
    }
}
