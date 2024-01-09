package lk.ijse.hotBurger.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import lk.ijse.hotBurger.bo.BOFactory;
import lk.ijse.hotBurger.bo.custom.BurgerCategoryBO;
import lk.ijse.hotBurger.dto.ItemDto;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class BurgerCategoryFormController implements Initializable {
    public static AnchorPane pane;

    private static BurgerCategoryFormController instance;

    public static BurgerCategoryFormController getInstance() {
        return instance;
    }

    public GridPane gridpane;

    @FXML
    protected AnchorPane ingrediantAnchorpane;

    @FXML
    protected AnchorPane toppingsAnchorpane;

    DuplicateMethodController duplicate = new DuplicateMethodController();
    BurgerCategoryBO burgerCategoryBO = (BurgerCategoryBO) BOFactory.getBoFactory().BOTypes(BOFactory.BOTypes.BURGER_CATEGORY);
    List<ItemDto> itemDto;

    public void initializeLoadGridPane(int categoryId) throws SQLException {
        //itemDto = ItemModel.loadAllItemCategoryVise(categoryId);
        itemDto = burgerCategoryBO.loadAllItemCategoryVise(categoryId);

        int column = 0;
        int row = 0;
        for (int i = 0; i < itemDto.size(); i++) {
            GridPaneItemController.x = i;
            GridPaneItemController.categoryId = categoryId;
            GridPaneItemController.anchorPane = pane;
            try {
                Parent parent = FXMLLoader.load(getClass().getResource("/view/gridPaneItem.fxml"));
                gridpane.add(parent,column,row++);
                GridPane.setMargin(parent,new Insets(6,6,6,6));

            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    protected void clickLoadGridPane(int categoryId , String fxml) throws SQLException {

        if (gridpane == null) {
            System.out.println("burgerGridPane is null");
            return;
        }
        gridpane.getChildren().clear();
        //itemDto = burgerCategoryBO.loadAllItemCategoryVise(categoryId);
        itemDto = ItemModel.loadAllItemCategoryVise(categoryId);

        if (itemDto != null){
            System.out.println("dto not null");
        for (int i = 0; i < itemDto.size(); i++) {
            if (itemDto.get(i).getImage() == null) {
                System.out.println("image is null");
                return;
            }
        }
        }

        int column = 0;
        int row = 0;
        for (int i = 0; i < itemDto.size(); i++) {
            GridPaneItemController.x = i;
            GridPaneItemController.categoryId = categoryId;

            try {
                Parent parent = FXMLLoader.load(getClass().getResource(fxml));

                if (parent != null) {
                    gridpane.add(parent, column, row++);
                    GridPane.setMargin(parent, new Insets(6, 6, 6, 6));
                } else {
                    System.out.println("FXMLLoader failed to load parent");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instance = this;
        try {
            duplicate.changeOnlyAnchorPane("/view/removeIngrediant_form.fxml" , ingrediantAnchorpane);
            duplicate.changeOnlyAnchorPane("/view/toppings_form.fxml" , toppingsAnchorpane);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            initializeLoadGridPane(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
