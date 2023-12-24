package lk.ijse.hotBurger.dao.custom;

import lk.ijse.hotBurger.dto.AddNewItemDto;

import java.sql.SQLException;

public interface ItemDAO {
    boolean addNewItem(AddNewItemDto newItemDto) throws SQLException;
}
