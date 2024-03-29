package lk.ijse.hotBurger.dao.custom.impl;

import lk.ijse.hotBurger.Entity.Order;
import lk.ijse.hotBurger.controller.CartTableController;
import lk.ijse.hotBurger.dao.SQLUtil;
import lk.ijse.hotBurger.dao.custom.OrderDAO;
import lk.ijse.hotBurger.db.DbConnection;
import lk.ijse.hotBurger.dto.OrderDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public boolean save(Order entity) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO orders VALUES(?,?,?,?,?,?,?,?)" , PreparedStatement.RETURN_GENERATED_KEYS);

        boolean affectedRow = SQLUtil.executeQueryWithGeneratedKey(preparedStatement,entity.getId(),entity.getType(),entity.getDate(),entity.getSubTotal(),entity.getDiscount(),entity.getDeliveryCharge(),entity.getTotal(),entity.getCustomerId());
        if (affectedRow){
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()){
                int generatedId = generatedKeys.getInt(1);
                entity.setId(generatedId);
                CartTableController.order.setId(entity.getId());
                CartTableController.order.setType(entity.getType());
                CartTableController.order.setSubTotal(entity.getSubTotal());
                CartTableController.order.setDiscount(entity.getDiscount());
                CartTableController.order.setDate(entity.getDate());
                CartTableController.order.setDeliveryCharge(entity.getDeliveryCharge());
                CartTableController.order.setTotal(entity.getTotal());
                CartTableController.order.setCustomerId(entity.getCustomerId());
            }
        }
        return false;
    }

    @Override
    public ArrayList<Order> getAll() throws SQLException {
        ArrayList<Order> orders = new ArrayList<>();
        ResultSet resultSet = SQLUtil.executeQuery("SELECT * FROM orders");
        while (resultSet.next()){
            Order order = new Order(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4),
                    resultSet.getDouble(5),
                    resultSet.getDouble(6),
                    resultSet.getDouble(7),
                    resultSet.getInt(8)
            );
            orders.add(order);
        }
        return orders;
    }

    @Override
    public Order totalSalesAmount() throws SQLException {
        ResultSet resultSet = SQLUtil.executeQuery("SELECT SUM(total) FROM orders");
        Order order = new Order();
        while (resultSet.next()){
            order.setTotal(resultSet.getDouble(1));
        }
        return order;
    }

    @Override
    public int totalSales() throws SQLException {
        int totalSales = 0;

        ResultSet resultSet = SQLUtil.executeQuery("SELECT COUNT(id) FROM orders");
        while (resultSet.next()){
            totalSales = resultSet.getInt(1);
        }
        return totalSales;
    }

    @Override
    public Order profit() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "";
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Order dto) throws SQLException {
        return false;
    }
}
