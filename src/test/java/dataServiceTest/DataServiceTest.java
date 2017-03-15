package dataServiceTest;

import model.Adress;
import model.Company;
import model.StreetPrefix;
import model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.DataService;

import java.util.List;

public class DataServiceTest {
    private DataService dataService;
    private String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\" " +
            "standalone=\"yes\"?><User><login>kowalski</login><password>abc123</password></User>";
    private User user;
    private User userXML;
    private Company company;

    public DataServiceTest() {
    }

    @Before
    public void setUp() {
        company = new Company();
        company.setName("Biedronka");
        Adress adress = new Adress(StreetPrefix.STREET, "Cwiartki", "3", "4", "60-666", "Poznań", "Poland");
        company.setAdress(adress);
        company.setNip("342435353");
        dataService = new DataService();
        userXML = new User("kowalski", "abc123");
    }

    public void loadData() {
        user = dataService.loadData();
    }

    public void saveData() {
        dataService.saveData(xmlString);
    }

    @Test
    public void saveAndLoadData() {
        saveData();
        loadData();
        Assert.assertTrue(user.equals(userXML));
    }

    @Test

    public void printCompanyInfo() {

        List<String> companyInfo = dataService.printCompanyInfo(company);
        boolean resultAssert = true;
        resultAssert &= companyInfo.get(0).equals("Biedronka");
        resultAssert &= companyInfo.get(1).equals("ul. Cwiartki 3/4\n60-666 Poznań");
        resultAssert &= companyInfo.get(2).equals("342435353");
        for (String list : companyInfo) {
            System.out.println(list);
        }
        Assert.assertTrue(resultAssert);
    }

}
