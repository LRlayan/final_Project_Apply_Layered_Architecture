package lk.ijse.hotBurger.bo.custom;

import lk.ijse.hotBurger.bo.SuperBO;
import lk.ijse.hotBurger.dto.ItemDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface GmailItemBO extends SuperBO {
    ArrayList<ItemDto> getAllItem() throws SQLException;
}
