package lk.ijse.hotBurger.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hotBurger.bo.BOFactory;
import lk.ijse.hotBurger.bo.custom.GridPaneItemBO;
import lk.ijse.hotBurger.dto.ItemDto;
import lk.ijse.hotBurger.dto.OrderDetailsDto;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;

import static java.lang.Integer.parseInt;

public class GridPaneItemController implements Initializable {
    public static AnchorPane anchorPane;

    @FXML
    private ImageView img;

    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLabel;

    public static int x;

    public static int categoryId;
    List<ItemDto> itemDto = new ArrayList<>();
    GridPaneItemBO gridPaneItemBO = (GridPaneItemBO) BOFactory.getBoFactory().BOTypes(BOFactory.BOTypes.GRID_PANE_ITEM);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            setImgAndNameAndPrice();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setImgAndNameAndPrice() throws SQLException {
        itemDto = ItemModel.loadAllItemCategoryVise(categoryId);
        itemDto = ItemModel.loadAllItemCategoryVise(categoryId);

                Image image = new Image(itemDto.get(x).getImage());
                ImageView imageView = new ImageView(image);

                img.setImage(imageView.getImage());
                nameLabel.setText(itemDto.get(x).getName());
                priceLabel.setText(String.valueOf(itemDto.get(x).getUnitPrice()));

    }

    @FXML
    void allItemButtonOnAction(ActionEvent event) throws IOException, SQLException {
        getClickItemDetails();
    }

    public void getClickItemDetails() {

        try {
            OrderDetailsDto dto = new OrderDetailsDto();
            Optional<ItemDto> first = itemDto.stream().filter(itemDto1 -> itemDto1.getName() == nameLabel.getText()).findFirst();
            if (first.isPresent()) {
                boolean isAlreadyAdded = false;
                for (OrderDetailsDto itemDto1 : CartTableController.orderDetails) {
                    if (itemDto1.getItemCode() == first.get().getItemCode()) {
                        itemDto1.setQty(itemDto1.getQty() + 1);
                        itemDto1.setTotal(itemDto1.getQty() * itemDto1.getUnitPrice());
                        CartTableController.order.setSubTotal(CartTableController.order.getSubTotal() + itemDto1.getUnitPrice());
                        isAlreadyAdded = true;
                    }
                }
                if (!isAlreadyAdded) {
                    dto.setId(first.get().getId());
                    dto.setItemCode(first.get().getItemCode());
                    dto.setUnitPrice(first.get().getUnitPrice());
                    dto.setName(first.get().getName());
                    dto.setQty(1);
                    dto.setTotal(dto.getQty() * dto.getUnitPrice());

                    CartTableController.orderDetails.add(dto);
                    CartTableController.order.setOrderItem(CartTableController.orderDetails);
                    CartTableController.order.setSubTotal(CartTableController.order.getSubTotal() + dto.getTotal());
                }
            }
            Parent parent = FXMLLoader.load(getClass().getResource("/view/cartTable.fxml"));
            anchorPane.getChildren().clear();
            anchorPane.getChildren().add(parent);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
