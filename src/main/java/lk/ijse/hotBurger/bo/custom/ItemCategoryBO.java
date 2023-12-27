package lk.ijse.hotBurger.bo.custom;

import lk.ijse.hotBurger.Entity.ItemCategory;
import lk.ijse.hotBurger.bo.SuperBO;
import lk.ijse.hotBurger.dto.ItemCategoryDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemCategoryBO extends SuperBO {
    ArrayList<ItemCategoryDto> getAllItemCategory() throws SQLException;
}
