package lk.ijse.hotBurger.bo.custom.impl;

import lk.ijse.hotBurger.Entity.Customer;
import lk.ijse.hotBurger.Entity.DeliveryDetail;
import lk.ijse.hotBurger.bo.custom.DeliveryBO;
import lk.ijse.hotBurger.dao.DAOFactory;
import lk.ijse.hotBurger.dao.custom.CustomerDAO;
import lk.ijse.hotBurger.dao.custom.DeliveryDetailDAO;
import lk.ijse.hotBurger.dao.custom.impl.DeliveryDetailDAOImpl;
import lk.ijse.hotBurger.dto.CustomerDto;
import lk.ijse.hotBurger.dto.DeliveryDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryBOImpl implements DeliveryBO {
    DeliveryDetailDAO deliveryDetailDAO = (DeliveryDetailDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.DELIVERY);

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public boolean saveDelivery(DeliveryDto entity) throws SQLException {
        return deliveryDetailDAO.save(new DeliveryDetail(entity.getId(),entity.getAdditionalMobileNo(),entity.getAddress(),entity.getCustomerId()));
    }

    @Override
    public ArrayList<CustomerDto> customerGetAll() throws SQLException {
        List<Customer> getAllCustomer = customerDAO.getAll();
        ArrayList<CustomerDto> customerDto = new ArrayList<>();

        for (Customer customers : getAllCustomer) {
            customerDto.add(new CustomerDto(customers.getId(), customers.getFName(), customers.getLName(), customers.getMobile() , customers.getAddress()));
        }
        return customerDto;
    }

    @Override
    public boolean updateDeliveryDetail(DeliveryDto dto) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteDeliveryDetail(String id) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<DeliveryDetail> getAllDelivery() throws SQLException {
        return null;
    }
}
