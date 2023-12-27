package lk.ijse.hotBurger.dao.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.hotBurger.Entity.DeliveryDetail;
import lk.ijse.hotBurger.dao.custom.DeliveryDetailDAO;
import lk.ijse.hotBurger.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeliveryDetailDAOImpl implements DeliveryDetailDAO {
    @Override
    public boolean save(DeliveryDetail entity) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "INSERT INTO deliveryDetail VALUES(?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

        preparedStatement.setInt(1,0);
        preparedStatement.setString(2,entity.getAddress());
        preparedStatement.setString(3,entity.getAdditionalMobileNo());
        preparedStatement.setInt(4,entity.getCustomerId());

        int affectedRow = preparedStatement.executeUpdate();
        if (affectedRow > 0){
            new Alert(Alert.AlertType.INFORMATION,"Delivery details added successfully!");
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()){
                int generatedId = generatedKeys.getInt(1);
                entity.setId(generatedId);
                //return entity; <- return type is not boolean
            }
        }else {
            new Alert(Alert.AlertType.ERROR,"Error!!!");
        }
        //return null; <- return type is not boolean
        return false;
    }

    @Override
    public ArrayList<DeliveryDetail> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean update(DeliveryDetail dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }
}
