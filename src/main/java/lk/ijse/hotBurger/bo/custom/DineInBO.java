package lk.ijse.hotBurger.bo.custom;

import lk.ijse.hotBurger.Entity.Customer;
import lk.ijse.hotBurger.bo.SuperBO;
import lk.ijse.hotBurger.dto.CustomerDto;

import java.sql.SQLException;

public interface DineInBO extends SuperBO {
    CustomerDto dineAndPickUpCustomerSave(CustomerDto dto) throws SQLException;
}
