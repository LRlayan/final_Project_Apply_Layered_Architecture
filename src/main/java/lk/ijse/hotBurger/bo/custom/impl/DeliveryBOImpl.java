package lk.ijse.hotBurger.bo.custom.impl;

import lk.ijse.hotBurger.Entity.DeliveryDetail;
import lk.ijse.hotBurger.bo.custom.DeliveryBO;
import lk.ijse.hotBurger.dao.DAOFactory;
import lk.ijse.hotBurger.dao.custom.DeliveryDetailDAO;
import lk.ijse.hotBurger.dao.custom.impl.DeliveryDetailDAOImpl;
import lk.ijse.hotBurger.dto.DeliveryDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class DeliveryBOImpl implements DeliveryBO {
    DeliveryDetailDAO deliveryDetailDAO = (DeliveryDetailDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.DELIVERY);

    @Override
    public boolean save(DeliveryDto entity) throws SQLException {
        return deliveryDetailDAO.save(new DeliveryDetail(entity.getId(),entity.getAdditionalMobileNo(),entity.getAddress(),entity.getCustomerId()));
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
