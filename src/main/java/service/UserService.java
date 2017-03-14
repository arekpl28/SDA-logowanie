package service;

import model.User;
import xml.XMLFactory;

public class UserService {



    public UserService() {
    }

    public boolean authenticate(User user) {
        DataService dataService = new DataService();
        User userFromFile = dataService.loadData();

        return user.equals(userFromFile);
    }
}
