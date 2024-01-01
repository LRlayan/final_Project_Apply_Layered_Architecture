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
    public boolean saveCustomer(CustomerDto customerDto) throws SQLException {
       return customerDAO.save(new Customer(customerDto.getId(),customerDto.getFName(),customerDto.getLName(),customerDto.getMobile(),customerDto.getAddress()));
       //return new CustomerDto(customer.getId(),customer.getFName(),customer.getLName(),customer.getAddress(),customer.getMobile());
        //return false;
    }

    @Override
    public ArrayList<CustomerDto> getAll() throws SQLException {
        List<Customer> getAllCustomer = customerDAO.getAll();
        ArrayList<CustomerDto> customerDto = new ArrayList<>();

        for (Customer customers : getAllCustomer) {
            customerDto.add(new CustomerDto(customers.getId(), customers.getFName(), customers.getLName(), customers.getMobile() , customers.getAddress()));
        }
        return customerDto;
    }

    @Override
    public boolean dineAndPickUpCustomerSave(CustomerDto customerDto) throws SQLException {
        return customerDAO.save(new Customer(customerDto.getId(),customerDto.getFName(),customerDto.getLName(),customerDto.getAddress(),customerDto.getMobile()));
    }

    @Override
    public boolean update(CustomerDto dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }
}
