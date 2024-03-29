package lk.ijse.hotBurger.bo.custom.impl;

import lk.ijse.hotBurger.Entity.Item;
import lk.ijse.hotBurger.bo.custom.ManageItemBO;
import lk.ijse.hotBurger.dao.DAOFactory;
import lk.ijse.hotBurger.dao.custom.ItemDAO;
import lk.ijse.hotBurger.dao.custom.impl.ItemDAOImpl;
import lk.ijse.hotBurger.dto.ItemDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManageItemBOImpl implements ManageItemBO {
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public ArrayList<ItemDto> getAllItem() throws SQLException {

        ArrayList<Item> allItem = itemDAO.getAll();
        ArrayList<ItemDto> itemDto = new ArrayList<>();

        for (Item items : allItem) {
            itemDto.add(new ItemDto(items.getId(),items.getItemCode(),items.getName(),items.getUnitPrice(),items.getUnitCost(),items.getCategoryId(),null));
        }
        return itemDto;
    }

    @Override
    public boolean updateItem(ItemDto itemDto) throws SQLException {
      return itemDAO.update(new Item(itemDto.getId(),itemDto.getItemCode(),itemDto.getName(),itemDto.getUnitPrice(),itemDto.getUnitCost(),itemDto.getCategoryId(),null));
    }

    @Override
    public boolean deleteItem(String itemCode) throws SQLException {
        return itemDAO.delete(itemCode);
    }
}
