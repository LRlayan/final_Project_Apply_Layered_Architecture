package lk.ijse.hotBurger.bo.custom;

import lk.ijse.hotBurger.Entity.Customer;
import lk.ijse.hotBurger.bo.SuperBO;
import lk.ijse.hotBurger.dto.CustomerDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDetailBO extends SuperBO {

    boolean saveCustomer(CustomerDto customerDto) throws SQLException;
    ArrayList<CustomerDto> getAll() throws SQLException;
    boolean dineAndPickUpCustomerSave(CustomerDto customerDto) throws SQLException;
    boolean update(CustomerDto dto) throws SQLException;
    boolean delete(String id) throws SQLException;
}
