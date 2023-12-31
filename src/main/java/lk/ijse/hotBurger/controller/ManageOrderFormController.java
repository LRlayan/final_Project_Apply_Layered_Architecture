package lk.ijse.hotBurger.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hotBurger.Entity.Order;
import lk.ijse.hotBurger.dao.custom.OrderDAO;
import lk.ijse.hotBurger.dao.custom.impl.OrderDAOImpl;
import lk.ijse.hotBurger.dto.OrderDto;
import lk.ijse.hotBurger.dto.tm.OrderTm;
import lk.ijse.hotBurger.model.OrderModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ManageOrderFormController implements Initializable {

    @FXML
    private TableColumn<?, ?> colCustomerID;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colDeliveryCharge;

    @FXML
    private TableColumn<?, ?> colDiscount;

    @FXML
    private TableColumn<?, ?> colOrderId;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colSubTotal;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private TableView<OrderTm> orderTable;

    @FXML
    private Label lblProfit;

    @FXML
    private Label lblTotalAmount;

    @FXML
    private Label lblTotalSale;

    @FXML
    private TextField orderSearch;

    //OrderModel orderModel = new OrderModel();
    OrderDAO orderDAO = new OrderDAOImpl();
    ObservableList<OrderTm> obList = FXCollections.observableArrayList();

    public void loadAllOrders(){
        try{
          List<Order> order = orderDAO.getAll();
            for (Order dto : order) {
                 obList.add(new OrderTm(
                    dto.getId(),
                    dto.getSubTotal(),
                    dto.getDeliveryCharge(),
                    dto.getDiscount(),
                    dto.getTotal(),
                    dto.getDate(),
                    dto.getCustomerId(),
                    dto.getType()
                 ));
            }
            orderTable.setItems(obList);
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void setCellValueFactory(){
        colOrderId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colSubTotal.setCellValueFactory(new PropertyValueFactory<>("SubTotal"));
        colDeliveryCharge.setCellValueFactory(new PropertyValueFactory<>("deliveryCharge"));
        colDiscount.setCellValueFactory(new PropertyValueFactory<>("discount"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("total"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colCustomerID.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadAllOrders();
        setCellValueFactory();
        setTextLabelSales();
        orderSearch();
    }

    public void setTextLabelSales(){
        try{
            Order orderDto = orderDAO.totalSalesAmount();
            lblTotalAmount.setText("Rs . " + orderDto.getTotal());

            int totalSales = orderDAO.totalSales();
            lblTotalSale.setText(String.valueOf(totalSales));

            Order orderDto3 = orderDAO.profit();
            lblProfit.setText("Rs . " + 12520.00);
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage());
        }
    }

    public void orderSearch(){
        FilteredList<OrderTm> filteredList = new FilteredList<>(obList, b -> true);
        orderSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(orderDto -> {
                if (newValue == null || newValue.isEmpty() || newValue.isBlank()) {
                    return true;
                }
                String searchKeyword = newValue.toLowerCase();

                String orderType = orderDto.getType();
                String date = orderDto.getDate();
                int orderId = orderDto.getId();

                if (orderType != null && orderType.toLowerCase().contains(searchKeyword)
                        || date != null && date.toLowerCase().contains(searchKeyword)
                        || orderId != 0 && String.valueOf(orderId) == searchKeyword) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<OrderTm> sortedData = new SortedList<>(filteredList);
        sortedData.comparatorProperty().bind(orderTable.comparatorProperty());
        orderTable.setItems(sortedData);
    }
}
