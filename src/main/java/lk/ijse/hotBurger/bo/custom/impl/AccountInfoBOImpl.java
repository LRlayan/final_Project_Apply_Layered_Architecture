package lk.ijse.hotBurger.bo.custom.impl;

import lk.ijse.hotBurger.bo.custom.AccountInfoBO;
import lk.ijse.hotBurger.dao.DAOFactory;
import lk.ijse.hotBurger.dao.custom.UserDAO;

import java.sql.SQLException;

public class AccountInfoBOImpl implements AccountInfoBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public boolean updateUsername(String confirmUsername, int userId) throws SQLException {
        return userDAO.updateUsername(confirmUsername, userId);
    }

    @Override
    public boolean updateUserPassword(String confirmPassword, int userId) throws SQLException {
        return userDAO.updateUserPassword(confirmPassword, userId);
    }
}
