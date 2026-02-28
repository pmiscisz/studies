package org.example;

import org.json.JSONObject;

public class City {
    private final JSONObject data;

    public City(JSONObject data) {
        this.data = data;
    }

    public void display() {
        System.out.println("=== Miasto ===");
        for (String key : data.keySet()) {
            System.out.println(key + ": " + data.get(key));
        }
    }
}
