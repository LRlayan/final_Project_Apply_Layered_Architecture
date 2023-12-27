package lk.ijse.hotBurger.bo.custom;

import lk.ijse.hotBurger.Entity.Customer;
import lk.ijse.hotBurger.bo.SuperBO;
import lk.ijse.hotBurger.dto.CustomerDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDetailBO extends SuperBO {
    ArrayList<CustomerDto> getAll() throws SQLException;
}
