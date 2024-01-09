package lk.ijse.hotBurger.bo.custom.impl;

import lk.ijse.hotBurger.Entity.Item;
import lk.ijse.hotBurger.bo.custom.UpdateItemPopUpWindowBO;
import lk.ijse.hotBurger.dao.DAOFactory;
import lk.ijse.hotBurger.dao.custom.ItemDAO;
import lk.ijse.hotBurger.dto.ItemDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class UpdateItemPopUpWindowBOImpl implements UpdateItemPopUpWindowBO {
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public boolean updateItem(ItemDto itemDto) throws SQLException {
        return itemDAO.update(new Item(itemDto.getId(),itemDto.getItemCode(),itemDto.getName(),itemDto.getUnitPrice(),itemDto.getUnitCost(),itemDto.getCategoryId(),null));
    }
}
