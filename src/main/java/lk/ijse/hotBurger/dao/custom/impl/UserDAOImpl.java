package lk.ijse.hotBurger.dao.custom.impl;

import lk.ijse.hotBurger.Entity.User;
import lk.ijse.hotBurger.dao.SQLUtil;
import lk.ijse.hotBurger.dao.custom.UserDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAOImpl implements UserDAO {

    @Override
    public boolean save(User dto) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<User> getAll() throws SQLException {

        ArrayList<User> allUsers = new ArrayList<>();
        ResultSet resultSet = SQLUtil.executeQuery("SELECT * from user");

        while (resultSet.next()) {
            User user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
            allUsers.add(user);
        }
        return allUsers;
    }

    @Override
    public boolean update(User dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateUsername(String confirmUsername, int userId) throws SQLException {
        return SQLUtil.executeQuery("UPDATE user SET username = ? WHERE id = ?",confirmUsername,userId);
    }

    @Override
    public boolean updateUserPassword(String confirmPassword, int userId) throws SQLException {
        return SQLUtil.executeQuery("UPDATE user SET password = ? WHERE id = ?",confirmPassword,userId);
    }
}
