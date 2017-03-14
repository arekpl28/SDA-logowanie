package service;

import model.User;
import org.apache.commons.io.FileUtils;
import xml.XMLFactory;

import java.io.File;
import java.io.IOException;

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
}
