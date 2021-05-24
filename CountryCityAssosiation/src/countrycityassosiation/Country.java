/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countrycityassosiation;

import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class Country {
    private String country_code;
    private String country_name;
    private ArrayList<City> city_list;

    public Country(String country_name,String country_code, ArrayList<City> city_list) {
        this.country_code = country_code;
        this.city_list = city_list;
        this.country_name=country_name;
    }

    /**
     * @return the country_code
     */
    public String getCountry_code() {
        return country_code;
    }

    /**
     * @param country_code the country_code to set
     */
    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    /**
     * @return the city_list
     */
    public ArrayList<City> getCity_list() {
        return city_list;
    }

    /**
     * @param city_list the city_list to set
     */
    public void setCity_list(ArrayList<City> city_list) {
        this.city_list = city_list;
    }

    /**
     * @return the country_name
     */
    public String getCountry_name() {
        return country_name;
    }

    /**
     * @param country_name the country_name to set
     */
    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }
}
