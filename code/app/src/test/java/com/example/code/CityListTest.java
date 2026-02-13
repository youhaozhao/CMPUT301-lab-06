package com.example.code;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();

        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = mockCityList();

        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();

        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testHasCities() {
        CityList cityList = mockCityList();
        // Create a new city without saving it to cityList. In this case, the expected result is false
        City city = new City("Charlottetown", "Prince Edward Island");
        assertEquals(false, cityList.hasCity(city));

        // Add the city to cityList. In this case the expected result is true
        cityList.add(city);
        assertEquals(true, cityList.hasCity(city));
    }

    @Test
    public void testDeleteCity() {
        CityList cityList = mockCityList();
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Since city has been added to cityList, the expected result below is true
        assertEquals(true, cityList.hasCity(city));

        // Remove the city we just added, now the expected result below is false, since the city is not in the cityList
        cityList.deleteCity(city);
        assertEquals(false, cityList.hasCity(city));

        // The exception should throw out since city is not in cityList now
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.deleteCity(city);
        });
    }

    @Test
    public void testCountCities() {
        CityList cityList = new CityList();

        // Now cityList is empty, countCities should return 0
        assertEquals(0, cityList.countCities());

        // Add City 1, countCities should return 1
        City city1 = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city1);
        assertEquals(1, cityList.countCities());

        // Add City 2, countCities should return 2
        City city2 = new City("Yellowknife", "Northwest Territories");
        cityList.add(city2);
        assertEquals(2, cityList.countCities());

        // Delete City 2, countCities should return 1
        cityList.deleteCity(city2);
        assertEquals(1, cityList.countCities());
    }
}