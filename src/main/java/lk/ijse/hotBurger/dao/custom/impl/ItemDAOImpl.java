package lk.ijse.hotBurger.dao.custom.impl;

import lk.ijse.hotBurger.Entity.Item;
import lk.ijse.hotBurger.dao.SQLUtil;
import lk.ijse.hotBurger.dao.custom.ItemDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {

    @Override
    public boolean save(Item dto) throws SQLException {
        return SQLUtil.executeQuery("INSERT INTO item VALUES(?,?,?,?,?,?,?)" , dto.getId(),dto.getItemCode(),dto.getName(),dto.getUnitPrice(),dto.getUnitCost(),dto.getCategoryId(),null);
    }

    @Override
    public ArrayList<Item> getAll() throws SQLException {
        ArrayList<Item> itemDtos = new ArrayList<>();

        ResultSet resultSet = SQLUtil.executeQuery("SELECT  * FROM item");

            while (resultSet.next()) {
                Item itemDto = new Item(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDouble(4),
                        resultSet.getDouble(5),
                        resultSet.getString(6),
                        resultSet.getString(7)
                );
                itemDtos.add(itemDto);
            }
            return itemDtos;
    }

    @Override
    public boolean update(Item item) throws SQLException {
        return SQLUtil.executeQuery("UPDATE item SET name = ?, itemCode = ?,unitPrice = ?,unitCost = ?,categoryId = ? WHERE id = ?",item.getName(),item.getItemCode(),item.getUnitPrice(),item.getUnitCost(),item.getCategoryId(),item.getId());
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SQLUtil.executeQuery("DELETE FROM item WHERE itemCode = ?",id);
    }

    @Override
    public ArrayList<Item> loadAllItemCategoryVise(int catID) throws SQLException {
        ArrayList<Item> getAllItem = new ArrayList<>();

            ResultSet resultSet = SQLUtil.executeQuery("SELECT  * FROM item WHERE categoryId = ?",catID);
            while (resultSet.next()){
                Item items = new Item(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4),
                    resultSet.getDouble(5),
                    resultSet.getString(6),
                    resultSet.getString(7));
                getAllItem.add(items);
            }
        return getAllItem;
    }
}
