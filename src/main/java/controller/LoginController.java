package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.User;
import service.UserService;

public class LoginController {

    @FXML
    private Button submit;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField loginTextField;

    @FXML
    void submitOnAction(ActionEvent event) {
        System.out.println(loginTextField.getText());
        System.out.println(passwordField.getText());
        boolean flag = true;
        while (flag) {
            User user = new User(loginTextField.getText(), passwordField.getText());
            UserService userService = new UserService();

            if (userService.authenticate(user)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Zalogowano");
                alert.show();
                flag = false;
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Bledne dane");
                alert.show();
                flag = false;
            }
        }
    }
}

