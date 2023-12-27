package lk.ijse.hotBurger.bo.custom;

import lk.ijse.hotBurger.bo.SuperBO;

import java.sql.SQLException;

public interface ForgetChangePasswordBO extends SuperBO {
    boolean updateUserPassword(String confirmPassword, int userId) throws SQLException;}
