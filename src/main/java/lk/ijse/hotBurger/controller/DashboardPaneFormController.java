package lk.ijse.hotBurger.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import lk.ijse.hotBurger.Entity.Order;
import lk.ijse.hotBurger.dao.DAOFactory;
import lk.ijse.hotBurger.dao.custom.OrderDAO;
import lk.ijse.hotBurger.dao.custom.impl.OrderDAOImpl;
import lk.ijse.hotBurger.dto.OrderDto;
import lk.ijse.hotBurger.model.OrderModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class DashboardPaneFormController implements Initializable {

    @FXML
    private Label lblProfit;

    @FXML
    private Label lblTotalSales;

    @FXML
    private Label lblTotalSalesAmount;

    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        totalSalesAmount();
    }

    public void totalSalesAmount(){
        try{
            Order orderDto = orderDAO.totalSalesAmount();
            lblTotalSalesAmount.setText("Rs . " + orderDto.getTotal());

            int totalSales = orderDAO.totalSales();
            lblTotalSales.setText(String.valueOf(totalSales));

            Order orderDto3 = orderDAO.profit();
            lblProfit.setText("Rs . " + 12520.00);
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage());
        }
    }
}
