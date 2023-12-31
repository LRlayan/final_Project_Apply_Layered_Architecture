package lk.ijse.hotBurger.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.hotBurger.bo.BOFactory;
import lk.ijse.hotBurger.bo.custom.ManageItemBO;
import lk.ijse.hotBurger.dto.ItemDto;
import lk.ijse.hotBurger.dto.tm.ItemTm;
import lk.ijse.hotBurger.model.ItemModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class UpdateItemPopWindowController implements Initializable {
    public static int id;
    public static String categoryId;
    public static String itemCode;
    public static String name;
    public static String unitPrice;
    public static String unitCost;

    @FXML
    private TextField txtCategoryId;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtItemName;

    @FXML
    private TextField txtUnitCost;

    @FXML
    private TextField txtUnitPrice;


    @FXML
    private JFXButton itemUpdateClose;

    DuplicateMethodController duplicate = new DuplicateMethodController();

    ItemModel itemModel = new ItemModel();
   // ManageItemBO manageItemBO = (ManageItemBO) BOFactory.getBoFactory().BOTypes(BOFactory.BOTypes.MANAGE_ITEM);
   // private List<ItemDto> dtoList;

    @FXML
    void closeButtonOnAction(ActionEvent event) {
        duplicate.clickButtonCloseWindow(itemUpdateClose);
    }

    public void updateOnAction(ActionEvent actionEvent) {

            int itemId = id;
            String categoryId = txtCategoryId.getText();
            String itemCode = txtItemCode.getText();
            String itemName = txtItemName.getText();
            double unitPrice = Double.parseDouble(txtUnitPrice.getText());
            double unitCost = Double.parseDouble(txtUnitCost.getText());

            var itemDto = new ItemDto( itemId,itemCode,itemName,unitPrice,unitCost,categoryId);
            try{
                 boolean isUpdate = itemModel.updateItem(itemDto);
                 if (isUpdate){
                     new Alert(Alert.AlertType.INFORMATION,"Update Successfully").show();
                 }
            }catch (SQLException e){
                new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //loadDataTextField();
        setData();
    }

    public void loadDataTextField() throws SQLException {
        //initialize weddima item table eke select karana row eke data tika updateItemPopWindow ekata set wela thiyenna one
        List<ItemDto> dtoList = itemModel.getAllItem();

          for (int i = 0; i < dtoList.size(); i++) {
            txtItemCode.setText(dtoList.get(i).getItemCode());
            txtItemName.setText(dtoList.get(i).getName());
            txtCategoryId.setText(dtoList.get(i).getCategoryId());
            txtUnitCost.setText(String.valueOf(dtoList.get(i).getUnitCost()));
            txtUnitPrice.setText(String.valueOf(dtoList.get(i).getUnitPrice()));
        }
    }

    public void setData(){
        txtCategoryId.setText(categoryId);
        txtItemName.setText(name);
        txtUnitPrice.setText(String.valueOf(unitPrice));
        txtUnitCost.setText(String.valueOf(unitCost));
        txtItemCode.setText(itemCode);
    }
}
