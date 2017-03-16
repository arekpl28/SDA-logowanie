package controller;

import javafx.scene.control.Alert;

public class Controller {

    protected void showErrorAlert(String message) {
        showAllert(Alert.AlertType.ERROR, message);
    }

    protected void showConfirmation(String message) {
        showAllert(Alert.AlertType.CONFIRMATION, message);
    }

    private void showAllert(Alert.AlertType alertType, String message) {
        new Alert(alertType, message).show();
    }
}
