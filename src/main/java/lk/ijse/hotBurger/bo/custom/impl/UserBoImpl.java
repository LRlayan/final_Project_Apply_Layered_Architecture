package lk.ijse.hotBurger.bo.custom.impl;

import lk.ijse.hotBurger.Entity.User;
import lk.ijse.hotBurger.bo.custom.UserBO;
import lk.ijse.hotBurger.dao.DAOFactory;
import lk.ijse.hotBurger.dao.custom.UserDAO;
import lk.ijse.hotBurger.dto.UserDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserBoImpl implements UserBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);
    @Override
    public ArrayList<UserDto> getAll() throws SQLException {
        ArrayList<User> allUsers = userDAO.getAll();
        ArrayList<UserDto> userDto = new ArrayList<>();

        for (User users : allUsers) {
            userDto.add(new UserDto(users.getId(),users.getType(),users.getPassword(),users.getUsername(),users.getEmailAddress(),users.getPhone()));
        }
        return userDto;
    }

    @Override
    public boolean updateUsername(String confirmUsername, int userId) throws SQLException {
        return userDAO.updateUsername(confirmUsername,userId);
    }

    @Override
    public boolean updateUserPassword(String confirmPassword, int userId) throws SQLException {
        return userDAO.updateUserPassword(confirmPassword,userId);
    }

}
