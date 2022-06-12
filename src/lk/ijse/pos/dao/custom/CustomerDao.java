package lk.ijse.pos.dao.custom;

import lk.ijse.pos.entity.Customer;

import java.util.ArrayList;

public interface CustomerDao {
    public boolean saveCustomer(Customer customer);
    public boolean updateCustomer(Customer customer);
    public boolean deleteCustomer(String id);
    public ArrayList<Customer> searchCustomer(String searchText);
}
