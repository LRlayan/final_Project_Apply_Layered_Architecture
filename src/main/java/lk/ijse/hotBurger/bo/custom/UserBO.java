package lk.ijse.hotBurger.bo.custom;

import lk.ijse.hotBurger.Entity.User;
import lk.ijse.hotBurger.bo.SuperBO;
import lk.ijse.hotBurger.dto.UserDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserBO extends SuperBO {
    ArrayList<UserDto> getAll() throws SQLException;
    boolean update(User dto) throws SQLException;
    boolean delete(String id) throws SQLException;
}
