package lk.ijse.hotBurger.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hotBurger.bo.BOFactory;
import lk.ijse.hotBurger.bo.custom.UserBO;
import lk.ijse.hotBurger.dto.UserDto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class UserLoginFormController {
    public AnchorPane loginAnchorPane;

    public javafx.scene.control.Label lblPassword;

    public javafx.scene.control.Label lblUsername;

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPasswordField;

    DuplicateMethodController navigate = new DuplicateMethodController();
    UserBO userBO = (UserBO) BOFactory.getBoFactory().BOTypes(BOFactory.BOTypes.USER);

    ArrayList<UserDto> allUsers;

    {
        try {
            allUsers = userBO.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void ClickOnLogingBtn(ActionEvent actionEvent) throws IOException, SQLException {
        String username = txtUsername.getText();
        String password = txtPasswordField.getText();

        for (int i = 0; i < allUsers.size(); i++) {
            if (username.equals(allUsers.get(i).getUsername()) && password.equals(allUsers.get(i).getPassword()) && allUsers.get(i).getType().equals("admin")) {
                AccountInfoFormController.userId = allUsers.get(i).getId();
                navigate.navigate("/view/mainDashboard_form.fxml", loginAnchorPane);

            } else if (username.equals(allUsers.get(i).getUsername()) && password.equals(allUsers.get(i).getPassword()) && allUsers.get(i).getType().equals("cashier")){
                AccountInfoFormController.userId = allUsers.get(i).getId();
                navigate.navigate("/view/CashierWork_form.fxml", loginAnchorPane);
            }
        }
    }

    public void onEnterKeyUsername(KeyEvent keyEvent) throws IOException, SQLException {
        //ArrayList<UserDto> allUsers = UserModel.getAllUsers();
        String username = txtUsername.getText();
        navigate.incorrectCredential(allUsers , username , "Incorrect Username" , lblUsername);
    }

    @FXML
    void OnEnterPassword(KeyEvent event) throws SQLException {
        //ArrayList<UserDto> allUsers = UserModel.getAllUsers();
        String password = txtPasswordField.getText();
        navigate.incorrectCredential(allUsers , password , "Incorrect Password" , lblPassword);
    }

    public void forgerPasswordOnAction(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        navigate.changeOnlyAnchorPane("/view/forgetPassword.fxml",loginAnchorPane);
    }
}