package lk.ijse.hotBurger.dao.custom.impl;

import lk.ijse.hotBurger.Entity.OrderDetail;
import lk.ijse.hotBurger.dao.CrudDAO;
import lk.ijse.hotBurger.dao.SQLUtil;
import lk.ijse.hotBurger.dao.custom.OrderDetailDAO;
import lk.ijse.hotBurger.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public boolean save(OrderDetail entity) throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//        String sql = "INSERT INTO orderdetail VALUES(?,?,?,?,?,?,?,?)";
//
//        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//
//        preparedStatement.setInt(1,0);
//        preparedStatement.setString(2, "DEFAULT");
//        preparedStatement.setInt(3,entity.getQty());
//        preparedStatement.setDouble(4,entity.getTotal());
//        preparedStatement.setInt(5,entity.getOrderId());
//        preparedStatement.setDouble(6,entity.getUnitCost());
//        preparedStatement.setString(7,entity.getItemCode());
//        preparedStatement.setString(8,entity.getName());
//
//        preparedStatement.executeUpdate();

        return SQLUtil.executeQuery("INSERT INTO orderdetail VALUES(?,?,?,?,?,?,?,?)",entity);
    }

    @Override
    public ArrayList<OrderDetail> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean update(OrderDetail dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }
}