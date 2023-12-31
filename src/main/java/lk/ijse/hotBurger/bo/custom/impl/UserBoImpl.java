package lk.ijse.hotBurger.bo.custom.impl;

import lk.ijse.hotBurger.Entity.User;
import lk.ijse.hotBurger.bo.custom.UserBO;
import lk.ijse.hotBurger.dao.DAOFactory;
import lk.ijse.hotBurger.dao.custom.UserDAO;
import lk.ijse.hotBurger.dao.custom.impl.UserDAOImpl;
import lk.ijse.hotBurger.dto.UserDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBoImpl implements UserBO {

    UserDAO userDAO = new UserDAOImpl();
    @Override
    public ArrayList<UserDto> getAll() throws SQLException {
        List<User> allUsers = userDAO.getAll();
        ArrayList<UserDto> userDto = new ArrayList<>();

        for (User users : allUsers) {
            userDto.add(new UserDto(users.getId(),users.getType(),users.getPassword(),users.getUsername(),users.getEmailAddress(),users.getPhone()));
        }
        return userDto;
      //  return null;
    }

    @Override
    public boolean update(UserDto dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

//    @Override
//    public boolean updateUsername(String confirmUsername, int userId) throws SQLException {
//        return userDAO.updateUsername(confirmUsername,userId);
//    }
//
//    @Override
//    public boolean updateUserPassword(String confirmPassword, int userId) throws SQLException {
//        return userDAO.updateUserPassword(confirmPassword,userId);
//    }

}
