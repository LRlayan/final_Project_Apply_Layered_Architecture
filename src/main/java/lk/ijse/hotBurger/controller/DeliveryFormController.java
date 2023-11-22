package lk.ijse.hotBurger.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lk.ijse.hotBurger.dto.CustomerDto;
import lk.ijse.hotBurger.dto.tm.CustomerTm;
import lk.ijse.hotBurger.model.CustomerModel;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeliveryFormController {

    @FXML
    private JFXTextArea additionalAddress;

    @FXML
    private CheckBox checkBoNewCustomer;

    @FXML
    private CheckBox checkboxPrimaryAndDeliveryAddress;

    @FXML
    private JFXButton btnConfirm;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtAdditionalMobile;

    @FXML
    private TextArea txtAreaAddress;

    @FXML
    private TextField searchBarAutoTextField;

    @FXML
    private TextField learnTextField;

    private TextField txtMobileNo;

    @FXML
    private Label lblNewAddress;


    @FXML
    private JFXButton btnClose;

    public DeliveryFormController() throws SQLException {
    }

    DuplicateMethodController duplicate = new DuplicateMethodController();

    CustomerModel customerModel = new CustomerModel();

    private AutoCompletionBinding<String> autoCompletionBinding;

    private List<CustomerDto> customerDtoList = customerModel.getAllCustomer();

    private Set<String> _customerDtoLis = new HashSet<>();

    public void initialize() throws IOException {
        customerDtoList.forEach(customerDto -> {
            _customerDtoLis.add(customerDto.getId()+ " - " +customerDto.getfName() + " " + customerDto.getlName());
        });
        setCheckBoxDefaultSelected();
        searchBarAutoTextField.setVisible(false);
        additionalAddress.setVisible(false);
        lblNewAddress.setVisible(false);


        TextFields.bindAutoCompletion(searchBarAutoTextField,_customerDtoLis);
        autoCompletionBinding = TextFields.bindAutoCompletion( learnTextField,_customerDtoLis);
        learnTextField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()){
                    case ENTER:
                    autoCompletionLearnword(learnTextField.getText().trim());
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void autoCompletionLearnword(String newWord){
        System.out.println(customerDtoList);
        _customerDtoLis.add(newWord);

        if (autoCompletionBinding != null){
            autoCompletionBinding.dispose();
        }
        autoCompletionBinding = TextFields.bindAutoCompletion(learnTextField , _customerDtoLis);
    }
    public void deliveryDetailConfirmBtnOnAction(javafx.event.ActionEvent actionEvent) {
       //duplicate.clickButtonCloseWindow(btnConfirm);

    }


    @FXML
    void deliveryWindowClose(ActionEvent event) {
        duplicate.clickButtonCloseWindow(btnClose);
    }
    public void setCheckBoxDefaultSelected() {
        checkBoNewCustomer.setSelected(true);
        checkboxPrimaryAndDeliveryAddress.setSelected(true);
    }
    public void clearField () {
        txtFirstName.setText("");
        txtLastName.setText("");
        txtAreaAddress.setText("");
        txtMobileNo.setText("");
        txtAdditionalMobile.setText("");
    }

    public void newCustomerCheckBoxOnAction(MouseEvent mouseEvent) throws IOException {
        if (!checkBoNewCustomer.isSelected()){
            searchBarAutoTextField.setVisible(true);
           txtFirstName.setEditable(false);
           txtLastName.setEditable(false);
           txtMobileNo.setEditable(false);
           txtAreaAddress.setEditable(false);

        }else if(checkBoNewCustomer.isSelected()){
            searchBarAutoTextField.setVisible(false);
            txtFirstName.setEditable(true);
            txtLastName.setEditable(true);
            txtMobileNo.setEditable(true);
            txtAreaAddress.setEditable(true);
        }
    }

    public void primaryAndDeliveryAddressCheckBox(MouseEvent mouseEvent) throws IOException {

        if (!checkboxPrimaryAndDeliveryAddress.isSelected()) {
           additionalAddress.setVisible(true);
           lblNewAddress.setVisible(true);
        } else if (checkboxPrimaryAndDeliveryAddress.isSelected()) {
            additionalAddress.setVisible(false);
            lblNewAddress.setVisible(false);
        }
    }
}
