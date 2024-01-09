package lk.ijse.hotBurger.bo.custom;

import lk.ijse.hotBurger.bo.SuperBO;
import lk.ijse.hotBurger.dto.UserDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ForgetChangePasswordBO extends SuperBO {

    ArrayList<UserDto> getAllUsers() throws SQLException;
    boolean updatePassword(String confirmPassword, int userId) throws SQLException;}
