package lk.ijse.hotBurger.dao.custom;

import lk.ijse.hotBurger.Entity.Customer;
import lk.ijse.hotBurger.dao.CrudDAO;
import lk.ijse.hotBurger.dto.CustomerDto;

import java.sql.SQLException;

public interface CustomerDAO extends CrudDAO<Customer> {
    Customer dineAndPickUpCustomerSave(Customer entity) throws SQLException;
}
