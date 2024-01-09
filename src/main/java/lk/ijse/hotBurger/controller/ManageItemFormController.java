package lk.ijse.hotBurger.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.hotBurger.bo.BOFactory;
import lk.ijse.hotBurger.bo.custom.ManageItemBO;
import lk.ijse.hotBurger.dto.ItemDto;
import lk.ijse.hotBurger.dto.tm.ItemTm;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class ManageItemFormController implements Initializable {

    @FXML
    private TableColumn<?, ?> colItemCategoryId;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colItemCost;

    @FXML
    private TableColumn<?, ?> colItemName;

    @FXML
    private TableColumn<?, ?> colItemPrice;

    @FXML
    private TableView<ItemTm> itemtable;

    @FXML
    private TextField txtSearchbar;

    @FXML
    private TableColumn<?, ?> colDelete;

    @FXML
    private TableColumn<?, ?> colUpdate;

    ManageItemBO manageItemBO = (ManageItemBO) BOFactory.getBoFactory().BOTypes(BOFactory.BOTypes.MANAGE_ITEM);
    DuplicateMethodController duplicate = new DuplicateMethodController();
    ObservableList<ItemTm> observableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setCellValueFactory();
        try {
            loadAllItem();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        searchBarItem();
    }
    private void setCellValueFactory(){
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colItemName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colItemPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colItemCost.setCellValueFactory(new PropertyValueFactory<>("unitCost"));
        colItemCategoryId.setCellValueFactory(new PropertyValueFactory<>("categoryId"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("update"));
        colUpdate.setCellValueFactory(new PropertyValueFactory<>("delete"));
    }

    public void loadAllItem() throws SQLException {

        try {
            ArrayList<ItemDto> dtoList = manageItemBO.getAllItem();
            for (ItemDto dto : dtoList) {
                observableList.add(new ItemTm(
                        dto.getId(),
                        dto.getItemCode(),
                        dto.getName(),
                        dto.getUnitPrice(),
                        dto.getUnitCost(),
                        dto.getCategoryId(),
                        new JFXButton("Update"),
                        new JFXButton("Delete")
                ));
            }
            itemtable.setItems(observableList);
        } catch (HeadlessException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < observableList.size(); i++) {
            observableList.get(i).getDelete().setTextFill(Color.WHITE);
            observableList.get(i).getDelete().setBackground(Background.fill(Color.RED));
            observableList.get(i).getDelete().setAlignment(Pos.CENTER);
            observableList.get(i).getUpdate().setTextFill(Color.WHITE);
            observableList.get(i).getUpdate().setBackground(Background.fill(Color.GREEN));
            observableList.get(i).getUpdate().setAlignment(Pos.CENTER);

            int id = observableList.get(i).getId();
            String name = observableList.get(i).getName();
            String categoryId = observableList.get(i).getCategoryId();
            String itemCode = observableList.get(i).getItemCode();
            String unitPrice = String.valueOf(observableList.get(i).getUnitPrice());
            String unitCost = String.valueOf(observableList.get(i).getUnitCost());

            observableList.get(i).getUpdate().setOnAction(event -> {

            UpdateItemPopWindowController.id = id;
            UpdateItemPopWindowController.name = name;
            UpdateItemPopWindowController.categoryId = categoryId;
            UpdateItemPopWindowController.itemCode = itemCode;
            UpdateItemPopWindowController.unitCost = unitCost;
            UpdateItemPopWindowController.unitPrice = unitPrice;

                try {
                    duplicate.popUpWindow("/view/updateItemPopWindow.fxml");
                    itemtable.refresh();
                    loadAllItem();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });

            observableList.get(i).getDelete().setOnAction(event -> {
                ButtonType yes = new ButtonType("Yes" , ButtonBar.ButtonData.OK_DONE);
                ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

                Optional<ButtonType> type = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure delete item!",yes,no).showAndWait();
                if (type.get().getText() == "Yes"){
                    deleteItemData(itemCode);
                }
                itemtable.refresh();
                try {
                    loadAllItem();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    private void deleteItemData(String itemCode){

        try{
            boolean isDelete = manageItemBO.deleteItem(itemCode);
            if (isDelete){
                new Alert(Alert.AlertType.CONFIRMATION,"Delete Successfully!").show();
            }
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }
    public void clickNewItemBtnOnActon(ActionEvent actionEvent) throws IOException, SQLException {
        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/addNewItem.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.showAndWait();
        loadAllItem();
        itemtable.refresh();
    }

    public void searchBarItem(){ //item Search logic

        FilteredList<ItemTm> filteredList = new FilteredList<>(observableList, b -> true);
        txtSearchbar.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(itemDto -> {
                if (newValue == null || newValue.isEmpty() || newValue.isBlank()) {
                    return true;
                }
                String searchKeyword = newValue.toLowerCase();

                String itemCode = itemDto.getItemCode();
                String categoryId = itemDto.getCategoryId();
                String itemName = itemDto.getName();

                if (itemCode != null && itemCode.toLowerCase().contains(searchKeyword)
                        || categoryId != null && categoryId.toLowerCase().contains(searchKeyword)
                        || itemName != null && itemName.toLowerCase().contains(searchKeyword)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        SortedList<ItemTm> sortedData = new SortedList<>(filteredList);
        sortedData.comparatorProperty().bind(itemtable.comparatorProperty());
        itemtable.setItems(sortedData);
    }
}
