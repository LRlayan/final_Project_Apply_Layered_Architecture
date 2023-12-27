package lk.ijse.hotBurger.bo.custom;

import lk.ijse.hotBurger.bo.SuperBO;
import lk.ijse.hotBurger.dto.AddNewItemDto;

import java.sql.SQLException;

public interface AddNewItemBO extends SuperBO {
    boolean addNewItem(AddNewItemDto newItemDto) throws SQLException;
}
