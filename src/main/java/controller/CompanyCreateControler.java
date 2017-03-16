package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Adress;
import model.Company;
import pdf.PdfFactory;
import service.DataService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CompanyCreateControler extends Controller {

    @FXML
    private TextField streetField;

    @FXML
    private Button dodajButton;

    @FXML
    private Button makePDFButton;

    @FXML
    private RadioButton avenueButton;

    @FXML
    private TextField comapanyField;

    @FXML
    private TextField houseNumberField;

    @FXML
    private TextField cityField;

    @FXML
    private RadioButton streetButton;

    @FXML
    private TextField nipfield;

    @FXML
    private TextField zipCodeField;

    @FXML
    private TextField localNumberField;
    private Adress.StreetPrefix streetPrefix;

    @FXML
    private RadioButton squareButton;

    @FXML
    void choosePrefix(ActionEvent event) {
        if (event.getSource() instanceof RadioButton) {
            RadioButton curentPrefixRadioButton = (RadioButton) event.getSource();
            String buttonName = curentPrefixRadioButton.getText();

            switch (buttonName) {
                case "Ulica":
                    streetPrefix = Adress.StreetPrefix.STREET;
                    break;
                case "Aleja":
                    streetPrefix = Adress.StreetPrefix.AVENUE;
                    break;
                case "Plac":
                    streetPrefix = Adress.StreetPrefix.SQUERE;
                    break;
                default:
                    break;
            }
        }
    }

    @FXML
    Company addCompanyCreateControler() {
        return bindToModelCompany();
    }

    private Company bindToModelCompany() {
        DataService dataService = new DataService();
        Company company = new Company();
        company.setName(comapanyField.getText());
        Adress adress = new Adress();
        adress.setStreetPrefix(streetPrefix);
        adress.setStreetName(streetField.getText());
        adress.setHouseNumber(houseNumberField.getText());
        adress.setFlatNumber(localNumberField.getText());
        adress.setPostalCode(zipCodeField.getText());
        adress.setCity(cityField.getText());
        company.setAdress(adress);
        company.setNip(nipfield.getText());
        dataService.printOutCompanyInfo(company);
        return company;
    }

    @FXML
    void initialize() {
        ToggleGroup group = new ToggleGroup();
        streetButton.setToggleGroup(group);
        avenueButton.setToggleGroup(group);
        squareButton.setToggleGroup(group);
    }

    private void validatePostalCode() {
        Pattern zipPatern = Pattern.compile("(^\\d{2}-\\d{3}$)");
        Matcher zipMatcher = zipPatern.matcher(zipCodeField.getText());
        if (zipMatcher.find()) {
            String zip = zipMatcher.group(1);
            showConfirmation("Ewerything alright");
        } else {
            showErrorAlert("Soory! Wrong postal code.");
        }
    }

    @FXML
    void makePdfOnAction(ActionEvent event) {
        PdfFactory pdfFactory = new PdfFactory();
        pdfFactory.pdfFromCompany(addCompanyCreateControler());
    }

    @FXML
    void ValidateOnAction(ActionEvent event) {
        validatePostalCode();
    }
}

