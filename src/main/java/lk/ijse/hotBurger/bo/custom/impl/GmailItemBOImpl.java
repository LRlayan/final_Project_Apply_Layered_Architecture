package lk.ijse.hotBurger.bo.custom.impl;

import lk.ijse.hotBurger.Entity.Item;
import lk.ijse.hotBurger.bo.custom.GmailItemBO;
import lk.ijse.hotBurger.dao.DAOFactory;
import lk.ijse.hotBurger.dao.custom.ItemDAO;
import lk.ijse.hotBurger.dto.ItemDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class GmailItemBOImpl implements GmailItemBO {

    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    @Override
    public ArrayList<ItemDto> getAllItem() throws SQLException {
      ArrayList<Item> allItem = itemDAO.getAll();
      ArrayList<ItemDto> itemDto = new ArrayList<>();

        for (Item items : allItem) {
            itemDto.add(new ItemDto(items.getId(),items.getItemCode(),items.getName(),items.getUnitPrice(),items.getUnitCost(),items.getCategoryId()));
        }
        return itemDto;
    }
}
