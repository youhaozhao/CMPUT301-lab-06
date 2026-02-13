package com.example.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     *
     * @param city This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     *
     * @return Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This returns a boolean to represent the given city is in the cityList or not
     *
     * @param city The city need to query
     * @return true if city is in the list else false
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * This is used to delete city from cityList, if city is not in the list, throw a exception
     *
     * @param city The city need to be deleted
     */
    public void deleteCity(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException();
        } else {
            cities.remove(city);
        }
    }

    /**
     * This returns count of cities in cityList
     *
     * @return the count of cities in cityList
     */
    public int countCities() {
        return cities.size();
    }
}