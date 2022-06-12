package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.CustomerBo;
import lk.ijse.pos.dao.DaoFactory;
import lk.ijse.pos.dao.custom.CustomerDao;
import lk.ijse.pos.dto.CustomerDto;
import lk.ijse.pos.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBoImpl implements CustomerBo {
    private CustomerDao customerDao= DaoFactory.getInstance().getDao(DaoFactory.DaoType.CUSTOMER);

    @Override
    public boolean saveCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {
        return customerDao.save(new Customer(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getSalary()
        ));
    }

    @Override
    public boolean updateCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {
        return customerDao.update(new Customer(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getSalary()
        ));
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDao.delete(id);
    }

    @Override
    public ArrayList<CustomerDto> searchCustomer(String searchText) throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDto> dtoList = new ArrayList<>();
        for (Customer c : customerDao.searchCustomer(searchText)
        ) {
            dtoList.add(new CustomerDto(
                    c.getId(), c.getName(), c.getAddress(), c.getSalary()
            ));
        }
        return dtoList;
    }
}
