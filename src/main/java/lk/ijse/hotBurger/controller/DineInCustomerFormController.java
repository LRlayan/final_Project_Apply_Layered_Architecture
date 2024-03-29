package lk.ijse.hotBurger.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.hotBurger.Entity.Customer;
import lk.ijse.hotBurger.dto.CustomerDto;

import java.util.regex.Pattern;

public class DineInCustomerFormController {

    @FXML
    private JFXButton closeButton;

    @FXML
    private TextField dineInCusFName;

    @FXML
    private TextField dineInCusLName;

    @FXML
    private TextField dineInCusMobileNo;

    @FXML
    private JFXButton confirmBtn;

    public static CustomerDto customerDto = new CustomerDto();

    DuplicateMethodController duplicate = new DuplicateMethodController();

    public void dineInCloseButtonOnAction(ActionEvent actionEvent) {
        duplicate.clickButtonCloseWindow(closeButton);
    }

    public void DineInConfirmOnAction(ActionEvent actionEvent) {
        String mobileNo = (dineInCusMobileNo.getText());

        customerDto.setId(0);
        customerDto.setFName(dineInCusFName.getText());
        customerDto.setLName(dineInCusLName.getText());
        customerDto.setMobile(dineInCusMobileNo.getText());

        if(!dineInCusFName.getText().isEmpty() && !dineInCusLName.getText().isEmpty()){
            new Alert(Alert.AlertType.INFORMATION,"Customer detail added successfully!").show();
            duplicate.clickButtonCloseWindow(confirmBtn);
            clearField();
        }
    }

    public void clearField(){
        dineInCusFName.setText("");
        dineInCusLName.setText("");
        dineInCusMobileNo.setText("");
    }
}







/*
  boolean matches = Pattern.matches("^(?:\\\\+94|0)([1-9])\\\\d{8}$",mobileNo);
 */