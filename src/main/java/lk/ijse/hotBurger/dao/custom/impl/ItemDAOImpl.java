package lk.ijse.hotBurger.dao.custom.impl;

import lk.ijse.hotBurger.Entity.Order;
import lk.ijse.hotBurger.dao.SQLUtil;
import lk.ijse.hotBurger.dao.custom.ItemDAO;
import lk.ijse.hotBurger.dto.ItemDto;
import lk.ijse.hotBurger.dto.OrderDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {

    @Override
    public boolean save(ItemDto dto) throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "INSERT INTO item VALUES(?,?,?,?,?,?,?)";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);

//        preparedStatement.setInt(1,newItemDto.getId());
//        preparedStatement.setString(2 , newItemDto.getItemCode());
//        preparedStatement.setString(3 , newItemDto.getName());
//        preparedStatement.setDouble(4 , newItemDto.getUnitPrice());
//        preparedStatement.setDouble(5 , newItemDto.getUnitCost());
//        preparedStatement.setString(6 , newItemDto.getCategoryId());
//        preparedStatement.setString(7,"null");

//        return preparedStatement.executeUpdate() > 0;
        return SQLUtil.executeQuery("INSERT INTO item VALUES(?,?,?,?,?,?,?)" , dto.getId(),dto.getItemCode(),dto.getName(),dto.getUnitPrice(),dto.getUnitCost(),dto.getCategoryId(),null);
    }

    @Override
    public List<ItemDto> getAll() throws SQLException {
     //   ArrayList<Item> itemDtos = new ArrayList<>();
//            Connection connection = DbConnection.getInstance().getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT  * FROM item");
//
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()){
//                ItemDto itemDto = new ItemDto(
//                        resultSet.getInt(1),
//                        resultSet.getString(2),
//                        resultSet.getString(3),
//                        resultSet.getDouble(4),
//                        resultSet.getDouble(5),
//                        resultSet.getString(6),
//                        resultSet.getString(7)
//                );
//                itemDtos.add(itemDto);
        return SQLUtil.executeQuery("SELECT  * FROM item");

    }

    @Override
    public boolean update(ItemDto item) throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//        String sql = "UPDATE item SET name = ?, itemCode = ?,unitPrice = ?,unitCost = ?,categoryId = ? WHERE id = ?";
//
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1,itemDto.getName());
//        preparedStatement.setString(2,itemDto.getItemCode());
//        preparedStatement.setDouble(3,itemDto.getUnitPrice());
//        preparedStatement.setDouble(4,itemDto.getUnitCost());
//        preparedStatement.setString(5, (itemDto.getCategoryId()));
//        preparedStatement.setInt(6,itemDto.getId());
//
//        return preparedStatement.executeUpdate() > 0;
        return SQLUtil.executeQuery("UPDATE item SET name = ?, itemCode = ?,unitPrice = ?,unitCost = ?,categoryId = ? WHERE id = ?");
    }

    @Override
    public boolean delete(String id) throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//        String sql = "DELETE FROM item WHERE itemCode = ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1,id);
//
//        return preparedStatement.executeUpdate() > 0;
        return SQLUtil.executeQuery("DELETE FROM item WHERE itemCode = ?",id);
    }

    @Override
    public ArrayList<ItemDto> loadAllItemCategoryVise(int catID) throws SQLException {
//        ArrayList<ItemDto> itemDtos = new ArrayList<>();
//        try {
//            Connection connection = DbConnection.getInstance().getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT  * FROM item WHERE categoryId = ?");
//
//            preparedStatement.setInt(1,catID);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                ItemDto itemDto = new ItemDto(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getDouble(4),resultSet.getDouble(5),resultSet.getString(6),resultSet.getString(7));
//                itemDtos.add(itemDto);
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//        return itemDtos;
        return SQLUtil.executeQuery("SELECT  * FROM item WHERE categoryId = ?",catID);
    }

}
