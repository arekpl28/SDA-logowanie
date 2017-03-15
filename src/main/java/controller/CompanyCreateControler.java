package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.Adress;
import model.Company;
import model.StreetPrefix;


public class CompanyCreateControler {

    @FXML
    private TextField streetField;

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

    @FXML
    private RadioButton squareButton;
    private StreetPrefix streetPrefix;

    @FXML
    void choosePrefix(ActionEvent event) {
        if (event.getSource() instanceof RadioButton){
            RadioButton carenPrefixRdaioButton = (RadioButton) event.getSource();
            String buttonName = carenPrefixRdaioButton.getText();

            switch (buttonName){
                case "Ulica":
                    streetPrefix = StreetPrefix.STREET;
                    break;
                case "Aleja":
                    streetPrefix = StreetPrefix.AVENUE;
                case "Plac":
                    streetPrefix = StreetPrefix.SQUERE;
            }
        }
    }

    @FXML
    void addCompanyCreateControler(ActionEvent event) {
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
        System.out.println(company.toString());
    }

    @FXML
    void initializer(){
        ToggleGroup group = new ToggleGroup();
        streetButton.setToggleGroup(group);
        avenueButton.setToggleGroup(group);
        squareButton.setToggleGroup(group);

    }
}

