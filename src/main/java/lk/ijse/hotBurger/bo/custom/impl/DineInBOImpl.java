package lk.ijse.hotBurger.bo.custom.impl;

import lk.ijse.hotBurger.Entity.Customer;
import lk.ijse.hotBurger.bo.custom.DineInBO;
import lk.ijse.hotBurger.dao.DAOFactory;
import lk.ijse.hotBurger.dao.custom.CustomerDAO;
import lk.ijse.hotBurger.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.hotBurger.dto.CustomerDto;

import java.sql.SQLException;

public class DineInBOImpl implements DineInBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public CustomerDto dineAndPickUpCustomerSave(CustomerDto dto) throws SQLException {

       Customer customer = customerDAO.dineAndPickUpCustomerSave(new Customer(dto.getId(),dto.getFName(),dto.getLName(),dto.getAddress(),dto.getMobile()));
       return new CustomerDto(customer.getId(),customer.getFName(),customer.getLName(),customer.getAddress(),customer.getMobile());
    }
}
