package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "http://localhost/IS_LAB6_REST/Cities/read/";

        try {
            CityService cityService = new CityService();
            List<City> cities = cityService.fetchCities(url);
            for (City city : cities) {
                city.display();
            }
        } catch (Exception e) {
            System.err.println("Wystąpił nieoczekiwany błąd!!!");
            e.printStackTrace(System.err);
        }
    }
}
