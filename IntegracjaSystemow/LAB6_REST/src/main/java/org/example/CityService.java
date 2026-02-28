package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CityService {
    public List<City> fetchCities(String urlString) throws Exception {
        URL url = new URL(urlString);
        InputStream is = url.openStream();
        String source = new BufferedReader(new InputStreamReader(is))
                .lines().collect(Collectors.joining("\n"));
        JSONObject json = new JSONObject(source);
        JSONArray data = json.getJSONArray("cities");

        List<City> cities = new ArrayList<>();
        for (Object obj : data) {
            JSONObject cityJson = (JSONObject) obj;
            cities.add(new City(cityJson));
        }
        return cities;
    }
}
