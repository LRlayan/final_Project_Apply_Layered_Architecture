package lk.ijse.hotBurger.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import lk.ijse.hotBurger.Entity.Order;
import lk.ijse.hotBurger.bo.BOFactory;
import lk.ijse.hotBurger.bo.custom.DashboardPaneBO;
import lk.ijse.hotBurger.dto.OrderDto;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DashboardPaneFormController implements Initializable {

    @FXML
    private Label lblProfit;

    @FXML
    private Label lblTotalSales;

    @FXML
    private Label lblTotalSalesAmount;

  //  OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    DashboardPaneBO dashboardPaneBO = (DashboardPaneBO) BOFactory.getBoFactory().BOTypes(BOFactory.BOTypes.DASHBOARD_PANE);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        totalSalesAmount();
    }

    public void totalSalesAmount(){
        try{
            OrderDto orderDto = dashboardPaneBO.totalSalesAmount();
            lblTotalSalesAmount.setText("Rs . " + orderDto.getTotal());

            int totalSales = dashboardPaneBO.totalSales();
            lblTotalSales.setText(String.valueOf(totalSales));

            Order orderDto3 = dashboardPaneBO.profit();
            lblProfit.setText("Rs . " + 12520.00);
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage());
        }
    }
}
