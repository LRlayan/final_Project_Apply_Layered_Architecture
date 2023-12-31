package lk.ijse.hotBurger.dao.custom;

import lk.ijse.hotBurger.Entity.Item;
import lk.ijse.hotBurger.dao.CrudDAO;
import lk.ijse.hotBurger.dto.ItemDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ItemDAO extends CrudDAO<ItemDto> {
  //  boolean addNewItem(Item newItemDto) throws SQLException;
  ArrayList<ItemDto> loadAllItemCategoryVise(int catID) throws SQLException;

}
