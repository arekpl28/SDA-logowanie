package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.BillItem;
import service.BillItemService;
import xml.JsonFactory;

import java.util.List;


public class BillItemController extends Controller {

    @FXML
    private TextField productTextField;

    @FXML
    private TextField codeTextField;

    @FXML
    private TextField priceTextField;

    @FXML
    private TextField amountTextField;

    @FXML
    private Button addProductButton;

    @FXML
    private TextField taxTextField;

    @FXML
    private TextArea descriptionTextField;

    @FXML
    void addProductController(ActionEvent event) {
        addNewProductToDatabase();
    }


    private List<BillItem> addNewProductToDatabase() {
        JsonFactory jsonFactory = new JsonFactory();
        BillItemService billItemService = BillItemService.getInstance();
        List<BillItem> billitemList = billItemService.getBillItemList();
        BillItem billItem = new BillItem();
        billItem.setItemName(productTextField.getText());
        billItem.setDescription(descriptionTextField.getText());
        billItem.setAmount(amountTextField.getPrefColumnCount());
        billItem.setPrice(priceTextField.getPrefColumnCount());
        billItem.setTax(taxTextField.getPrefColumnCount());
        billItem.setCode(codeTextField.getText());
        billitemList.add(billItem);
        String listInJSon = jsonFactory.listToJSon(billitemList);
        jsonFactory.saveData(listInJSon);

        return billitemList;
    }
}
