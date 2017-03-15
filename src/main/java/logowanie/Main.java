package logowanie;

import model.User;
import service.DataService;
import service.UserService;
import xml.XMLFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        login(scanner);
//        DataService dataService = new DataService();
//        User user = new User("arek", "arek123");
//        XMLFactory<User> xmlFactory = new XMLFactory<User>(User.class);
//        String xmlUser = xmlFactory.objectToXML(user);
//        dataService.saveData(xmlUser);

//        DataService dataService = new DataService();
//        User user = new User("Arkadiusz","taklavdsvs");
//        XMLFactory<User> xmlFactory = new XMLFactory<>(User.class);
//        String xmlUser = xmlFactory.objectToXML(user);
//
//
////        System.out.println(user);
//
//        dataService.saveData(xmlUser);

    }

    private static void login(Scanner scanner) {
        boolean flag = true;
        while (flag) {
            System.out.println("Podaj login: ");
            String login = scanner.nextLine();

            System.out.println("Podaj haslo: ");
            String password = scanner.nextLine();

            User user = new User(login, password);

            UserService userService = new UserService();

            if (userService.authenticate(user)) {
                System.out.println("Zalogowany");
                flag = false;
            } else {
                System.out.println("Nie prawidlowe haslo");
            }
        }
    }
}
