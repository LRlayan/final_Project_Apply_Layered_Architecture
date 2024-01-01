package lk.ijse.hotBurger.bo.custom;

import lk.ijse.hotBurger.Entity.User;
import lk.ijse.hotBurger.bo.SuperBO;
import lk.ijse.hotBurger.dto.UserDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserBO extends SuperBO {
    ArrayList<UserDto> getAll() throws SQLException;
    boolean updatePassword(String confirmPassword, int userId) throws SQLException;
    boolean updateUsername(String confirmUsername, int userId) throws SQLException;
    boolean deleteUser(String id) throws SQLException;
}
