package com.example.project;

public class City {
    private String name;
    private Country country;

    public enum Country {
        FRANCE,
        GERMANY,
        ITALY,
        SPAIN,
        UNITED_KINGDOM
    }

    public City() {

    }

    public City(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}
