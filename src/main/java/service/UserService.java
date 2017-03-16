package service;

import model.User;

public class UserService {



    public UserService() {
    }

    public boolean authenticate(User user) {
        DataService dataService = new DataService();
        User userFromFile = dataService.loadData();

        return user.equals(userFromFile);
    }
}
