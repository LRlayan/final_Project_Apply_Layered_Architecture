package lk.ijse.hotBurger.dao;

import lk.ijse.hotBurger.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {}

    public DAOFactory getDaoFactory(){
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes{
        CUSTOMER,DELIVERY,ITEM,ITEM_CATEGORY,ORDER,ORDER_DETAIL,USER
    }

    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case CUSTOMER:
                return new CustomerDAOImpl();
            case DELIVERY:
                return new DeliveryDetailDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case ITEM_CATEGORY:
                return new ItemCategoryDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            case ORDER_DETAIL:
                return new OrderDetailDAOImpl();
            case USER:
                return new UserDAOImpl();
            default:
                return null;
        }
    }
}
