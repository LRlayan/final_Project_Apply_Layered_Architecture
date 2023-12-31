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
        //return itemDAO.update(new Item(itemDto.getId(),itemDto.getItemCode(),itemDto.getName(),itemDto.getUnitPrice(),itemDto.getUnitCost(),itemDto.getCategoryId(),null));
        return false;
    }

    @Override
    public ArrayList<ItemDto> getAllItem() throws SQLException {
//       ArrayList<Item> getAllItem = itemDAO.getAll();
//       ArrayList<ItemDto> itemDto = new ArrayList<>();
//
//       for(Item items : getAllItem){
//            itemDto.add(new ItemDto(items.getId(),items.getItemCode(),items.getName(),items.getUnitPrice(),items.getUnitCost(),items.getCategoryId()));
//       }
//       return itemDto;
    return null;
    }
}
