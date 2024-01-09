package lk.ijse.hotBurger.dao.custom.impl;

import lk.ijse.hotBurger.Entity.OrderDetail;
import lk.ijse.hotBurger.dao.SQLUtil;
import lk.ijse.hotBurger.dao.custom.OrderDetailDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public boolean save(OrderDetail entity) throws SQLException {
        return SQLUtil.executeQuery("INSERT INTO orderdetail VALUES(?,?,?,?,?,?,?,?)",0,"DEFAULT",entity.getQty(),entity.getTotal(),entity.getOrderId(),entity.getUnitCost(),entity.getItemCode(),entity.getName());
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
