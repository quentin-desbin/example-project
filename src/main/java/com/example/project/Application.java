package com.example.project;

import java.io.IOException;
import java.util.List;

public class Application {

    public static void main(String[] args) throws IOException {
        /*final User user = new User("John", "Doe", "john.doe@example.com", new City("Paris", City.Country.FRANCE));
        final User user2 = new User("Jane", "Roe", "john.roe@example2.com", new City("London", City.Country.UNITED_KINGDOM));
        final List<User> users = List.of(user, user2);
        //System.out.println(users);

        final List<User> usersFromJson = JsonReader.readUsersManual();
        System.out.println(usersFromJson);*/

        final List<User> usersAutomatic = JsonReader.readUsersAutomatic();
        System.out.println(usersAutomatic);
    }
}
