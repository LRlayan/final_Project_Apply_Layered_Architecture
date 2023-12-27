package lk.ijse.hotBurger.dao.custom.impl;

import lk.ijse.hotBurger.Entity.Order;
import lk.ijse.hotBurger.dao.CrudDAO;
import lk.ijse.hotBurger.dao.SQLUtil;
import lk.ijse.hotBurger.dao.custom.OrderDAO;
import lk.ijse.hotBurger.db.DbConnection;
import lk.ijse.hotBurger.dto.OrderDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public boolean save(Order entity) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "INSERT INTO orders VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql , PreparedStatement.RETURN_GENERATED_KEYS);

        preparedStatement.setInt(1, 0);
        preparedStatement.setString(2, entity.getType());
        preparedStatement.setString(3, entity.getDate());
        preparedStatement.setDouble(4, entity.getSubTotal());
        preparedStatement.setDouble(5, entity.getDiscount());
        preparedStatement.setDouble(6, entity.getDeliveryCharge());
        preparedStatement.setDouble(7, entity.getTotal());
        preparedStatement.setInt(8, entity.getCustomerId());

        preparedStatement.executeUpdate();

        int affectedRow = preparedStatement.executeUpdate();
        if (affectedRow > 0){
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()){
                int generatedId = generatedKeys.getInt(1);
                entity.setId(generatedId);
                //return entity; <- return type is not boolean
            }
        }
        //return null; <- return type is not boolean
        return false;
    }

    @Override
    public ArrayList<Order> getAll() throws SQLException {
        ArrayList<Order> orders = new ArrayList<>();
//        Connection connection = DbConnection.getInstance().getConnection();
//        String sql = "SELECT * FROM orders";
//
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = SQLUtil.executeQuery("SELECT * FROM orders");
        while (resultSet.next()){
            Order order = new Order(
                    resultSet.getInt(1),
                    resultSet.getDouble(2),
                    resultSet.getDouble(3),
                    resultSet.getDouble(4),
                    resultSet.getDouble(5),
                    resultSet.getString(6),
                    resultSet.getInt(7),
                    resultSet.getString(8)
            );
            orders.add(order);
        }
        return orders;
    }

    @Override
    public Order totalSalesAmount() throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//        String sql = "SELECT SUM(total) FROM orders";
//
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
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
//        Connection connection = DbConnection.getInstance().getConnection();
//        String sql = "SELECT COUNT(id) FROM orders";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = SQLUtil.executeQuery("SELECT COUNT(id) FROM orders");
       // OrderDto orderDto = new OrderDto();
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
    public boolean update(Order dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }
}
