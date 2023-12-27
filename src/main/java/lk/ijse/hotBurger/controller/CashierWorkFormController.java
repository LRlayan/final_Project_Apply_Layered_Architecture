package lk.ijse.hotBurger.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hotBurger.db.DbConnection;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CashierWorkFormController implements Initializable {

    @FXML
    AnchorPane orderAnchorPane;
    @FXML
    private AnchorPane cashierMainAnchorpane;
    @FXML
    private AnchorPane mainAnchorpane;
    private static CashierWorkFormController instance;
    private BurgerCategoryFormController burgerGrid;

    DuplicateMethodController duplicate = new DuplicateMethodController();

    public void onBurgerClick(ActionEvent actionEvent) throws IOException, SQLException {
        loadGrid(1);
        burgerGrid.ingrediantAnchorpane.setVisible(true);
        burgerGrid.toppingsAnchorpane.setVisible(true);
    }

    @FXML
    void onComboBoxClick(ActionEvent event) throws IOException, SQLException {
        loadGrid(2);
    }

    @FXML
    void onSnacksClick(ActionEvent event) throws SQLException {
        loadGrid(3);
    }

    @FXML
    void onSaucesClick(ActionEvent event) throws SQLException {
        loadGrid(4);
    }

    @FXML
    void onDrinksClick(ActionEvent event) throws SQLException {
        loadGrid(5);
    }

    @FXML
    void onOfferseClick(ActionEvent event) throws SQLException {
        loadGrid(6);
    }

    private void loadGrid(int categoryId) throws SQLException {
        if (burgerGrid != null) {
            burgerGrid.clickLoadGridPane(categoryId, "/view/gridPaneItem.fxml");
            burgerGrid.ingrediantAnchorpane.setVisible(false);
            burgerGrid.toppingsAnchorpane.setVisible(false);
        } else {
            System.out.println("burger grid ek null");
        }
    }


    public void cashierLogoutOnAction(MouseEvent mouseEvent) throws IOException {
        duplicate.navigate("/view/userLogin_form.fxml", cashierMainAnchorpane);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instance = this;
        try {
            BurgerCategoryFormController.pane = orderAnchorPane;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/burgerCategory_form.fxml"));
            Parent root = loader.load();
            burgerGrid = loader.getController();

            if (mainAnchorpane != null) {
                mainAnchorpane.getChildren().removeAll();
                mainAnchorpane.getChildren().setAll(root);
            } else {
                System.out.println("mainAnchorpane is null");
            }

            Parent parent = FXMLLoader.load(getClass().getResource("/view/cartTable.fxml"));
            orderAnchorPane.getChildren().clear();
            orderAnchorPane.getChildren().add(parent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    void reportsOnAction(ActionEvent event) throws JRException, SQLException {
        InputStream reportsAsStream = getClass().getResourceAsStream("/reports/hotBurgers.jrxml");
        JasperDesign load = JRXmlLoader.load(reportsAsStream);
        JasperReport jasperReport1 = JasperCompileManager.compileReport(load);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport1,
                null,
                DbConnection.getInstance().getConnection()

        );
        JasperViewer.viewReport(jasperPrint, false);
    }

    @FXML
    void btnMailBoxOnAction(ActionEvent event) throws IOException {
        duplicate.popUpWindow("/view/gmailItem_form.fxml");

    }
}
