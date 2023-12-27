package lk.ijse.hotBurger.bo.custom.impl;

import lk.ijse.hotBurger.bo.custom.DeliveryBO;
import lk.ijse.hotBurger.dto.DeliveryDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class DeliveryBOImpl implements DeliveryBO {
    @Override
    public boolean save(DeliveryDto entity) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<DeliveryDto> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean update(DeliveryDto dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }
}
