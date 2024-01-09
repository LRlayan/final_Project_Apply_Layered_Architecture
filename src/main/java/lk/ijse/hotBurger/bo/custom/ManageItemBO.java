package lk.ijse.hotBurger.bo.custom;

import lk.ijse.hotBurger.bo.SuperBO;
import lk.ijse.hotBurger.dto.ItemDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ManageItemBO extends SuperBO {
    ArrayList<ItemDto> getAllItem() throws SQLException;
   // ArrayList<ItemDto> loadAllItemCategoryVise(int catID) throws SQLException;
    boolean updateItem(ItemDto itemDto) throws SQLException;
    boolean deleteItem(String itemCode) throws SQLException;
}
