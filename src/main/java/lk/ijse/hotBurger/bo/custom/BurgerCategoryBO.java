package lk.ijse.hotBurger.bo.custom;

import lk.ijse.hotBurger.bo.SuperBO;
import lk.ijse.hotBurger.dto.ItemDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BurgerCategoryBO extends SuperBO {
    ArrayList<ItemDto> loadAllItemCategoryVise(int catID) throws SQLException;
}
