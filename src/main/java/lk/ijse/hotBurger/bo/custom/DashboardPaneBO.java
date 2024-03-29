package lk.ijse.hotBurger.bo.custom;

import lk.ijse.hotBurger.Entity.Order;
import lk.ijse.hotBurger.bo.SuperBO;
import lk.ijse.hotBurger.dto.OrderDto;

import java.sql.SQLException;

public interface DashboardPaneBO extends SuperBO {

    OrderDto totalSalesAmount() throws SQLException;
    int totalSales() throws SQLException;
    Order profit();
}
