package lk.ijse.hotBurger.dao.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.hotBurger.Entity.DeliveryDetail;
import lk.ijse.hotBurger.controller.DeliveryFormController;
import lk.ijse.hotBurger.dao.SQLUtil;
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

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO deliveryDetail VALUES(?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);

        boolean affectedRow = SQLUtil.executeQueryWithGeneratedKey(preparedStatement,entity.getId(),entity.getAddress(),entity.getAdditionalMobileNo(),entity.getCustomerId());
        if (affectedRow){
            new Alert(Alert.AlertType.INFORMATION,"Delivery details added successfully!");
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()){
                int generatedId = generatedKeys.getInt(1);
                entity.setId(generatedId);

                DeliveryFormController.deliveryDto.setId(entity.getId());
                DeliveryFormController.deliveryDto.setAddress(entity.getAddress());
                DeliveryFormController.deliveryDto.setAdditionalMobileNo(entity.getAdditionalMobileNo());
                DeliveryFormController.deliveryDto.setCustomerId(entity.getCustomerId());
            }
        }else {
            new Alert(Alert.AlertType.ERROR,"Error!!!");
        }
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
