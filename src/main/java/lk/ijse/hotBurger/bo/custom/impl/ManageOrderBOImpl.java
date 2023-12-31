package lk.ijse.hotBurger.bo.custom.impl;

import lk.ijse.hotBurger.Entity.Order;
import lk.ijse.hotBurger.bo.custom.ManageOrderBO;
import lk.ijse.hotBurger.dao.DAOFactory;
import lk.ijse.hotBurger.dao.custom.OrderDAO;
import lk.ijse.hotBurger.dto.OrderDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManageOrderBOImpl implements ManageOrderBO {

    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    @Override
    public ArrayList<OrderDto> loadAllOrders() throws SQLException {

//        List<OrderDto> getAllOrder = orderDAO.getAll();
//        ArrayList<OrderDto> orderDto = new ArrayList<>();
//
//        for(OrderDto orders : getAllOrder){
//            orderDto.add(new OrderDto(orders.getId(),orders.getType(),orders.getDate(),orders.getSubTotal(),orders.getDiscount(),orders.getDeliveryCharge(),orders.getTotal(),orders.getCustomerId()));
//        }
//        return orderDto;
      return null;
    }

    @Override
    public boolean saveOrder(OrderDto order) throws SQLException {
        return orderDAO.save(new Order(order.getId(), order.getType(), order.getDate(), order.getSubTotal(), order.getDiscount(), order.getDeliveryCharge(), order.getTotal(), order.getCustomerId()));
      //  return false;
    }

//    @Override
//    public OrderDto totalSalesAmount() throws SQLException {
//        Order getOrder = orderDAO.totalSalesAmount();
//        OrderDto orderDto = new OrderDto(getOrder.getId(),getOrder.getSubTotal(),getOrder.getDeliveryCharge(),getOrder.getDiscount(),getOrder.getTotal(),getOrder.getDate(),getOrder.getCustomerId(),getOrder.getType());
//        return orderDto;
//    }

//    @Override
//    public int totalSales() throws SQLException {
//        return orderDAO.totalSales();
//    }
//
//    @Override
//    public boolean profit() throws SQLException {
//        return false;
//    }
}
