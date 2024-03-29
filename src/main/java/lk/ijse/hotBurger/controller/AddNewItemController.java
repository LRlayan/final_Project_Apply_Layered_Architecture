package lk.ijse.hotBurger.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.hotBurger.bo.BOFactory;
import lk.ijse.hotBurger.bo.custom.AddNewItemBO;
import lk.ijse.hotBurger.dto.AddNewItemDto;

import java.sql.SQLException;
import java.util.regex.Pattern;

public class AddNewItemController {

    @FXML
    private TextField txtItemCategory;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtItemName;

    @FXML
    private TextField txtUnitCost;

    @FXML
    private TextField txtUnitPrice;

    @FXML
    private JFXButton btnCreate;

    @FXML
    private JFXButton closeButton;

    DuplicateMethodController duplicate = new DuplicateMethodController();
    AddNewItemBO addNewItemBO = (AddNewItemBO) BOFactory.getBoFactory().BOTypes(BOFactory.BOTypes.ADD_NEW_ITEM);

    public void createBtnOnAction(ActionEvent actionEvent) {
        String code = txtItemCode.getText();
        String name = txtItemName.getText();

        boolean matches = Pattern.matches("\\S+\\s+\\S+", name);

        if (matches){
            double unitPrice = Double.parseDouble(txtUnitPrice.getText());
            double unitCost = Double.parseDouble(txtUnitCost.getText());
            String categoryId = txtItemCategory.getText();

            var newItemDto = new AddNewItemDto(code,name,unitPrice,unitCost,categoryId);
            try{
                boolean isAdd = addNewItemBO.saveNewItem(newItemDto);
                if (isAdd){
                    duplicate.clickButtonCloseWindow(btnCreate);
                    new Alert(Alert.AlertType.CONFIRMATION,"Added Successfully!").show();
                }
            }catch (SQLException e){
                new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            }
        }else {
            new Alert(Alert.AlertType.ERROR,"Name Field cannot be null").show();
        }
    }

    @FXML
    void btnCloseOnAction(ActionEvent event) {
        duplicate.clickButtonCloseWindow(closeButton);
    }
}
