package lk.ijse.hotBurger.bo.custom.impl;

import lk.ijse.hotBurger.Entity.Order;
import lk.ijse.hotBurger.bo.custom.DashboardPaneBO;
import lk.ijse.hotBurger.dao.DAOFactory;
import lk.ijse.hotBurger.dao.custom.OrderDAO;
import lk.ijse.hotBurger.dto.OrderDto;

import java.sql.SQLException;

public class DashboardPaneBoImpl implements DashboardPaneBO {
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);

    @Override
    public OrderDto totalSalesAmount() throws SQLException {
        Order totalSalesAmount = orderDAO.totalSalesAmount();
        return new OrderDto(totalSalesAmount.getTotal());
    }
}
