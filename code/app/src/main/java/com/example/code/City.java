package com.example.code;

/**
 * This is a class that store information of a City, including City's name and province
 */
public class City implements Comparable<City> {
    private String name;
    private String province;

    /**
     * This is constructor to initialize City class
     *
     * @param name the city's name
     * @param province province the city belongs to
     */
    public City(String name, String province) {
        this.name = name;
        this.province = province;
    }

    /**
     * Getter method for name
     *
     * @return name of City
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for name
     *
     * @param name name of City
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for province
     *
     * @return province province that city belongs to
     */
    public String getProvince() {
        return province;
    }

    /**
     * Setter method for province
     *
     * @param province province province that city belongs to
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * CompareTo function used to compare the priority of two City instances
     *
     * @param city Instance of City Class to be compared with
     * @return negative for smaller, 0 for equal, positive for larger
     */
    @Override
    public int compareTo(City city) {
        return this.name.compareTo(city.getName());
    }
}