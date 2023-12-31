package lk.ijse.hotBurger.bo.custom.impl;

import lk.ijse.hotBurger.Entity.Customer;
import lk.ijse.hotBurger.Entity.DeliveryDetail;
import lk.ijse.hotBurger.Entity.Order;
import lk.ijse.hotBurger.Entity.OrderDetail;
import lk.ijse.hotBurger.bo.custom.CartTableBO;
import lk.ijse.hotBurger.dao.DAOFactory;
import lk.ijse.hotBurger.dao.custom.CustomerDAO;
import lk.ijse.hotBurger.dao.custom.DeliveryDetailDAO;
import lk.ijse.hotBurger.dao.custom.OrderDAO;
import lk.ijse.hotBurger.dao.custom.OrderDetailDAO;
import lk.ijse.hotBurger.dto.CustomerDto;
import lk.ijse.hotBurger.dto.DeliveryDto;
import lk.ijse.hotBurger.dto.OrderDetailsDto;
import lk.ijse.hotBurger.dto.OrderDto;

import java.sql.SQLException;

public class CartTableBOImpl implements CartTableBO {

    OrderDetailDAO orderDetailDAO = (OrderDetailDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER_DETAIL);
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    DeliveryDetailDAO deliveryDetailDAO = (DeliveryDetailDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.DELIVERY);

    @Override
    public boolean saveOrder(OrderDto orderDto) throws SQLException {
        return orderDAO.save(new Order(orderDto.getId(),orderDto.getType(),orderDto.getDate(),orderDto.getSubTotal(),orderDto.getDiscount(),orderDto.getDeliveryCharge(),orderDto.getTotal(),orderDto.getCustomerId()));
       // return false;
    }

    @Override
    public boolean saveCustomer(CustomerDto customerDto) throws SQLException {
        return customerDAO.save(new Customer(customerDto.getId(),customerDto.getFName(),customerDto.getLName(),customerDto.getAddress(),customerDto.getMobile()));
    //return false;
    }

    @Override
    public boolean saveDelivery(DeliveryDto deliveryDto) throws SQLException {
        return deliveryDetailDAO.save(new DeliveryDetail(deliveryDto.getId(),deliveryDto.getAddress(),deliveryDto.getAdditionalMobileNo(),deliveryDto.getCustomerId()));
      //return false;
    }

    @Override
    public boolean saveOrderDetail(OrderDetailsDto orderDetailsDto) throws SQLException {
        return orderDetailDAO.save(new OrderDetail(orderDetailsDto.getId(),orderDetailsDto.getSize(),orderDetailsDto.getQty(),orderDetailsDto.getTotal(),orderDetailsDto.getOrderId(),orderDetailsDto.getUnitCost(),orderDetailsDto.getItemCode(),orderDetailsDto.getName(),orderDetailsDto.getUnitPrice()));
        //return false;
    }

    @Override
    public CustomerDto dineAndPickUpCustomerSave(CustomerDto customerDto) throws SQLException {
        Customer customer = customerDAO.dineAndPickUpCustomerSave(new Customer(customerDto.getId(),customerDto.getFName(),customerDto.getLName(),"No Address",customerDto.getMobile()));
        return new CustomerDto(customer.getId(),customer.getFName(),customer.getLName(),customer.getAddress(),customer.getMobile());
        //  return false;
    }
}
