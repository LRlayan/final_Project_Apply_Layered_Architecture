package lk.ijse.hotBurger.bo.custom.impl;

import lk.ijse.hotBurger.Entity.Customer;
import lk.ijse.hotBurger.bo.custom.CustomerDetailBO;
import lk.ijse.hotBurger.dao.DAOFactory;
import lk.ijse.hotBurger.dao.custom.CustomerDAO;
import lk.ijse.hotBurger.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.hotBurger.dto.CustomerDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDetailBOImpl implements CustomerDetailBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public ArrayList<CustomerDto> getAllCustomer() throws SQLException {
        List<Customer> getAllCustomer = customerDAO.getAll();
        ArrayList<CustomerDto> customerDto = new ArrayList<>();

        for (Customer customers : getAllCustomer) {
            customerDto.add(new CustomerDto(customers.getId(), customers.getFName(), customers.getLName(), customers.getMobile() , customers.getAddress()));
        }
        return customerDto;
    }

    @Override
    public boolean updateCustomer(CustomerDto dto) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException {
        return false;
    }
}
