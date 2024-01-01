package lk.ijse.hotBurger.dao.custom.impl;

import lk.ijse.hotBurger.Entity.ItemCategory;
import lk.ijse.hotBurger.Entity.Order;
import lk.ijse.hotBurger.dao.SQLUtil;
import lk.ijse.hotBurger.dao.custom.ItemCategoryDAO;
import lk.ijse.hotBurger.dto.ItemCategoryDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemCategoryDAOImpl implements ItemCategoryDAO {
    @Override
    public boolean save(ItemCategory dto) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<ItemCategory> getAll() throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "SELECT * FROM itemCategory";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//
        ArrayList<ItemCategory> itemCategoryList = new  ArrayList<>();
//
//        ResultSet resultSet = preparedStatement.executeQuery();
        ResultSet resultSet = SQLUtil.executeQuery("SELECT * FROM itemCategory");
        while (resultSet.next()){
            itemCategoryList.add(new ItemCategory(
                  resultSet.getInt(1),
                  resultSet.getString(2),
                  resultSet.getString(3)
            ));
        }

        return itemCategoryList;
    }

    @Override
    public boolean update(ItemCategory dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }
}
