package lk.ijse.hotBurger.bo.custom.impl;

import lk.ijse.hotBurger.bo.custom.ForgetChangePasswordBO;
import lk.ijse.hotBurger.dao.DAOFactory;
import lk.ijse.hotBurger.dao.custom.UserDAO;

import java.sql.SQLException;

public class ForgetChangePasswordBOImpl implements ForgetChangePasswordBO {
    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);
    @Override
    public boolean updateUserPassword(String confirmPassword, int userId) throws SQLException {
        return userDAO.updateUserPassword(confirmPassword, userId);
    }
}
