package lk.ijse.hotBurger.bo.custom.impl;

import lk.ijse.hotBurger.Entity.Item;
import lk.ijse.hotBurger.bo.custom.AddNewItemBO;
import lk.ijse.hotBurger.dao.DAOFactory;
import lk.ijse.hotBurger.dao.custom.ItemDAO;
import lk.ijse.hotBurger.dto.AddNewItemDto;

import java.sql.SQLException;

public class AddNewItemBOImpl implements AddNewItemBO {

    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public boolean saveNewItem(AddNewItemDto newItemDto) throws SQLException {
       return itemDAO.save(new Item(newItemDto.getId(),newItemDto.getItemCode(),newItemDto.getName(),newItemDto.getUnitPrice(),newItemDto.getUnitCost(),newItemDto.getCategoryId(),null));
    }
}

