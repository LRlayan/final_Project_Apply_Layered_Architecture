package lk.ijse.hotBurger.controller;

import lk.ijse.hotBurger.db.DbConnection;
import lk.ijse.hotBurger.dto.ItemDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemModel {

    public static List<ItemDto> loadAllItemCategoryVise(int catID) {
        ArrayList<ItemDto> itemDtos = new ArrayList<>();
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT  * FROM item WHERE categoryId = ?");

            preparedStatement.setInt(1,catID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                ItemDto itemDto = new ItemDto(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getDouble(4),resultSet.getDouble(5),resultSet.getString(6),resultSet.getString(7));
                itemDtos.add(itemDto);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return itemDtos;
    }
}
