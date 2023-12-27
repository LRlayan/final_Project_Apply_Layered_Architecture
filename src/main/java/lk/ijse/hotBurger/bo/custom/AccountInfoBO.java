package lk.ijse.hotBurger.bo.custom;

import lk.ijse.hotBurger.bo.SuperBO;

import java.sql.SQLException;

public interface AccountInfoBO extends SuperBO {
    boolean updateUsername(String confirmUsername, int userId) throws SQLException;
    boolean updateUserPassword(String confirmPassword, int userId) throws SQLException;
}
