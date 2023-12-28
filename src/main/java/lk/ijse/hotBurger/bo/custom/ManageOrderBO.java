package lk.ijse.hotBurger.bo.custom;

import lk.ijse.hotBurger.bo.SuperBO;
import lk.ijse.hotBurger.dto.OrderDto;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ManageOrderBO extends SuperBO {
    ArrayList<OrderDto> loadAllOrders() throws SQLException;
}
