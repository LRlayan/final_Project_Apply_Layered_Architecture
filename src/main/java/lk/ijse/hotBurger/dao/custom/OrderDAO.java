package lk.ijse.hotBurger.dao.custom;

import lk.ijse.hotBurger.Entity.Order;
import lk.ijse.hotBurger.dao.CrudDAO;
import lk.ijse.hotBurger.dto.OrderDto;

import java.sql.SQLException;

public interface OrderDAO extends CrudDAO<Order> {
    Order totalSalesAmount() throws SQLException;
    int totalSales() throws SQLException;
    Order profit() throws SQLException;
}
