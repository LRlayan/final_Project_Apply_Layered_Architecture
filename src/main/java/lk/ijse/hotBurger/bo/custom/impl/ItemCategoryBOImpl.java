package lk.ijse.hotBurger.bo.custom.impl;

import lk.ijse.hotBurger.Entity.ItemCategory;
import lk.ijse.hotBurger.bo.custom.ItemCategoryBO;
import lk.ijse.hotBurger.dao.DAOFactory;
import lk.ijse.hotBurger.dao.custom.ItemCategoryDAO;
import lk.ijse.hotBurger.dto.ItemCategoryDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemCategoryBOImpl implements ItemCategoryBO {
    ItemCategoryDAO itemCategoryDAO = (ItemCategoryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM_CATEGORY);

    @Override
    public ArrayList<ItemCategoryDto> getAllItemCategory() throws SQLException {
       ArrayList<ItemCategory> itemCategories = itemCategoryDAO.getAll();
       ArrayList<ItemCategoryDto> categoryDTO = new ArrayList<>();

        for (ItemCategory itemCategory : itemCategories) {
            categoryDTO.add(new ItemCategoryDto(itemCategory.getId(),itemCategory.getName(),itemCategory.getDescription()));
        }
        return categoryDTO;
    }
}
