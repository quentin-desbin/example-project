package com.example.project;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JsonReader {

    private JsonReader() {
        throw new IllegalStateException("Utility class");
    }

    static final ObjectMapper mapper = new ObjectMapper();

    static List<User> readUsersManual() throws IOException {
        List<User> users = new ArrayList<>();
        try (InputStream inJson = Application.class.getResourceAsStream("/users.json")) {
            final JsonNode objectNode = mapper.readTree(inJson);
            if (objectNode.isArray()) {
                for (JsonNode node : objectNode) {
                    final String firstName = node.get("firstName").asText();
                    final String lastName = node.get("lastName").asText();
                    final String email = node.get("email").asText();
                    final JsonNode cityNode = node.get("city");
                    final String cityName = cityNode.get("name").asText();
                    final City.Country country = City.Country.valueOf(cityNode.get("country").asText());
                    final City city = new City(cityName, country);
                    final User user = new User(firstName, lastName, email, city);
                    users.add(user);
                }
            }
        }

        return users;
    }

    static List<User> readUsersAutomatic() throws IOException {
        try (InputStream inJson = Application.class.getResourceAsStream("/users.json")) {
            return mapper.readValue(inJson, new TypeReference<>() {});
        }
    }
}
