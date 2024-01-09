package lk.ijse.hotBurger.dao.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.hotBurger.Entity.Customer;
import lk.ijse.hotBurger.Entity.Order;
import lk.ijse.hotBurger.controller.DeliveryFormController;
import lk.ijse.hotBurger.controller.DineInCustomerFormController;
import lk.ijse.hotBurger.dao.SQLUtil;
import lk.ijse.hotBurger.dao.custom.CustomerDAO;
import lk.ijse.hotBurger.db.DbConnection;
import lombok.NonNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @NonNull
    @Override
    public boolean save(Customer entity) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customer VALUES(?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);

        boolean affectedRow = SQLUtil.executeQueryWithGeneratedKey(preparedStatement, entity.getId(), entity.getFName(), entity.getLName(), entity.getMobile(), entity.getAddress());
        if (affectedRow) {
            new Alert(Alert.AlertType.INFORMATION, "Customer created successfully!");
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);
                entity.setId(generatedId);

                DeliveryFormController.customerDto.setId(entity.getId());
                DeliveryFormController.customerDto.setFName(entity.getFName());
                DeliveryFormController.customerDto.setLName(entity.getLName());
                DeliveryFormController.customerDto.setMobile(entity.getMobile());
                DeliveryFormController.customerDto.setAddress(entity.getAddress());
            } else {
                new Alert(Alert.AlertType.ERROR, "Customer Error");
            }
        }
        return false;
    }

    @Override
    public ArrayList<Customer> getAll() throws SQLException {
        ArrayList<Customer> customers = new ArrayList<>();

        ResultSet resultSet = SQLUtil.executeQuery("SELECT * FROM customer");
        while (resultSet.next()){
            Customer customer = new Customer(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            );
            customers.add(customer);
        }
        return customers;
    }

    @Override
    public boolean update(Customer dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public Customer dineAndPickUpCustomerSave(Customer entity) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customer VALUES(?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);

        boolean affectedRow = SQLUtil.executeQueryWithGeneratedKey(preparedStatement,entity.getId(),entity.getFName(),entity.getLName(),"No Address",entity.getMobile());
        if (affectedRow){
            new Alert(Alert.AlertType.INFORMATION,"Customer created successfully!");
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()){
                int generatedId = generatedKeys.getInt(1);
                if (generatedId != 0) {
                    entity.setId(generatedId);
                    DineInCustomerFormController.customerDto.setId(generatedId);
                    return entity;
                }
            }
        }else {
            new Alert(Alert.AlertType.ERROR,"Customer Error");
        }
        return null;
    }
}
