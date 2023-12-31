package lk.ijse.hotBurger.dao.custom;

import lk.ijse.hotBurger.Entity.User;
import lk.ijse.hotBurger.dao.CrudDAO;
import lk.ijse.hotBurger.dto.UserDto;

import java.sql.SQLException;

public interface UserDAO extends CrudDAO<User> {
    boolean updateUsername(String confirmUsername,int userId ) throws SQLException;
    boolean updateUserPassword(String confirmPassword , int userId) throws SQLException;
}
