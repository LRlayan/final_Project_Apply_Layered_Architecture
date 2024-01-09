package lk.ijse.hotBurger.bo.custom;

import lk.ijse.hotBurger.Entity.DeliveryDetail;
import lk.ijse.hotBurger.bo.SuperBO;
import lk.ijse.hotBurger.dto.CustomerDto;
import lk.ijse.hotBurger.dto.DeliveryDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DeliveryBO extends SuperBO {
    boolean saveDelivery(DeliveryDto entity) throws SQLException;
    ArrayList<CustomerDto> customerGetAll() throws SQLException;
    boolean updateDeliveryDetail(DeliveryDto dto) throws SQLException;
    boolean deleteDeliveryDetail(String id) throws SQLException;
    ArrayList<DeliveryDetail> getAllDelivery() throws SQLException;
}
