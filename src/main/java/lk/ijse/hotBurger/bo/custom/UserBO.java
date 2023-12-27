package lk.ijse.hotBurger.bo.custom;

import lk.ijse.hotBurger.bo.SuperBO;
import lk.ijse.hotBurger.dto.UserDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserBO extends SuperBO {
    ArrayList<UserDto> getAll() throws SQLException;
    boolean updateUsername(String confirmUsername,int userId ) throws SQLException;
    boolean updateUserPassword(String confirmPassword, int userId) throws SQLException;
}
