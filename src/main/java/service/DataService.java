package service;

import model.Company;
import model.User;
import org.apache.commons.io.FileUtils;
import xml.XMLFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DataService {

    private File file;

    public DataService() {
        this.file = new File("C:\\Users\\RENT\\Desktop\\projekt\\SDA-logowanie\\src\\main\\resources\\data.dat");
    }

    public void saveData(String xmlString) {
        try {
            FileUtils.touch(file);
            FileUtils.writeStringToFile(file, xmlString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User loadData() {
        User user = null;
        XMLFactory<User> xmlFactory = new XMLFactory<>(User.class);
        try {
            String xml = FileUtils.readFileToString(file, "UTF-8");
            user = xmlFactory.xmlToObject(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<String> printCompanyInfo(Company company) {
        List<String> result = new ArrayList<>();
        result.add(company.getName());
        result.add(company.getAdress().toString());
        result.add(company.getNip());
        return result;
    }

    public void printOutCompanyInfo(Company company) {
        List<String> listInfo = printCompanyInfo(company);
        for (String line : listInfo) {
            System.out.println(line);
        }
    }

    public static Properties loadProperties() {
        Properties result = new Properties();
        InputStream inputStream = DataService.class.getClassLoader().getResourceAsStream("data.properties");
        try {
            result.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
