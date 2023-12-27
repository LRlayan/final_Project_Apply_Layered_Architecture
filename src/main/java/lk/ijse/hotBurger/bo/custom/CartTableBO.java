package lk.ijse.hotBurger.bo.custom;

import lk.ijse.hotBurger.Entity.Customer;
import lk.ijse.hotBurger.Entity.Order;
import lk.ijse.hotBurger.bo.SuperBO;
import lk.ijse.hotBurger.dto.CustomerDto;
import lk.ijse.hotBurger.dto.DeliveryDto;
import lk.ijse.hotBurger.dto.OrderDetailsDto;
import lk.ijse.hotBurger.dto.OrderDto;

import java.sql.SQLException;

public interface CartTableBO extends SuperBO {

    boolean saveOrder(OrderDto orderDto) throws SQLException;
    boolean saveCustomer(CustomerDto customerDto) throws SQLException;
    boolean saveDelivery(DeliveryDto deliveryDto) throws SQLException;
    boolean saveOrderDetail(OrderDetailsDto orderDetailsDto) throws SQLException;
    boolean dineAndPickUpCustomerSave(CustomerDto customerDto) throws SQLException;
}
