package lk.ijse.hotBurger.dao;

import lk.ijse.hotBurger.Entity.Order;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO<T> extends SuperDAO{
    boolean save(T dto) throws SQLException;
    List<T> getAll() throws SQLException;
    boolean update(T dto) throws SQLException;
    boolean delete(String id) throws SQLException;

}
