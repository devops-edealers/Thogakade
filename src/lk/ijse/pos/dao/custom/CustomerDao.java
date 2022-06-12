package lk.ijse.pos.dao.custom;

import lk.ijse.pos.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDao {
    public boolean saveCustomer(Customer customer) throws SQLException, ClassNotFoundException;
    public boolean updateCustomer(Customer customer) throws SQLException, ClassNotFoundException;
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;
    public ArrayList<Customer> searchCustomer(String searchText) throws SQLException, ClassNotFoundException;
}
