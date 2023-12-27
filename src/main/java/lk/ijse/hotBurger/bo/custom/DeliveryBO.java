package lk.ijse.hotBurger.bo.custom;

import lk.ijse.hotBurger.Entity.DeliveryDetail;
import lk.ijse.hotBurger.bo.SuperBO;
import lk.ijse.hotBurger.dto.DeliveryDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DeliveryBO extends SuperBO {
    boolean save(DeliveryDto entity) throws SQLException;
    ArrayList<DeliveryDto> getAll() throws SQLException;
    boolean update(DeliveryDto dto) throws SQLException;
    boolean delete(String id) throws SQLException;
}
