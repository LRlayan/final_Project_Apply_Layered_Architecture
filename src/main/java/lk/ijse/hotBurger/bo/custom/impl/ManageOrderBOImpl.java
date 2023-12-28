package lk.ijse.hotBurger.bo.custom.impl;

import lk.ijse.hotBurger.Entity.Order;
import lk.ijse.hotBurger.bo.custom.ManageOrderBO;
import lk.ijse.hotBurger.dao.DAOFactory;
import lk.ijse.hotBurger.dao.custom.OrderDAO;
import lk.ijse.hotBurger.dto.OrderDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class ManageOrderBOImpl implements ManageOrderBO {

    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    @Override
    public ArrayList<OrderDto> loadAllOrders() throws SQLException {
        ArrayList<Order> getAllOrder = orderDAO.getAll();
        ArrayList<OrderDto> orderDto = new ArrayList<>();

        for(Order orders : getAllOrder){
            orderDto.add(new OrderDto(orders.getId(),orders.getSubTotal(),orders.getDeliveryCharge(),orders.getDiscount(),orders.getDate(),orders.getTotal(),orders.getCustomerId(),orders.getType()));
        }
        return orderDto;
    }
}
