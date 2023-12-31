package lk.ijse.hotBurger.dao;

import javafx.scene.control.Alert;
import lk.ijse.hotBurger.db.DbConnection;
import lk.ijse.hotBurger.dto.CustomerDto;
import lk.ijse.hotBurger.model.CustomerModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLUtil {

    public static <T> T executeQuery(String sql, Object... ar) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < ar.length; i++) {
            preparedStatement.setObject((i + 1), ar[i]);
        }

        if (sql.startsWith("SELECT")) {
            return (T) preparedStatement.executeQuery();
        } else {
            return (T) (Boolean) (preparedStatement.executeUpdate() > 0);
        }
    }

    public static <T> T executeQueryWithGeneratedKey(PreparedStatement preparedStatement, Object... ar) throws SQLException {
        for (int i = 0; i < ar.length; i++) {
            preparedStatement.setObject((i + 1), ar[i]);
        }
         return (T)(Boolean)(preparedStatement.executeUpdate() > 0);
    }

//    public static <T> T test(PreparedStatement preparedStatement, T dto, Object... ar) throws SQLException {
//        for (int i = 0; i < ar.length; i++) {
//            preparedStatement.setObject((i + 1), ar[i]);
//        }
//
//        boolean affectedRow = preparedStatement.executeUpdate() > 0;
//        if (affectedRow) {
//            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
//            if (generatedKeys.next()) {
//                int generatedId = generatedKeys.getInt(1);
//                dto.setId(generatedId);
//;
//            }
//        }
//        return customerDto;
//    }
}
