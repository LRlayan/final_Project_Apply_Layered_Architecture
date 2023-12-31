package lk.ijse.hotBurger.dao.custom.impl;

import lk.ijse.hotBurger.Entity.Order;
import lk.ijse.hotBurger.dao.SQLUtil;
import lk.ijse.hotBurger.dao.custom.ItemCategoryDAO;
import lk.ijse.hotBurger.dto.ItemCategoryDto;

import java.sql.SQLException;
import java.util.List;

public class ItemCategoryDAOImpl implements ItemCategoryDAO {
    @Override
    public boolean save(ItemCategoryDto dto) throws SQLException {
        return false;
    }

    @Override
    public List<ItemCategoryDto> getAll() throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "SELECT * FROM itemCategory";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//
//        List<ItemCategoryDto> itemCategoryList = new  ArrayList<>();
//
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()){
//            itemCategoryList.add(new ItemCategoryDto(
//                    resultSet.getInt(1),
//                    resultSet.getString(2),
//                    resultSet.getString(3)
//            ));
//        }
//
//        return itemCategoryList;
        return SQLUtil.executeQuery("SELECT * FROM itemCategory");
    }

    @Override
    public boolean update(ItemCategoryDto dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }
}
