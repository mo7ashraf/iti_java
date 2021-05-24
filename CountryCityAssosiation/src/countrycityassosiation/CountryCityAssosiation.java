/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countrycityassosiation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author dell
 */
public class CountryCityAssosiation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CountryDAO countryDAO = new CountryDAO();
        ArrayList<Country> countriesDataList = countryDAO.getCountriesData();
        countriesDataList.forEach(country -> {
            String country_code = country.getCountry_code();
            String country_name = country.getCountry_name();
            ArrayList<City> city_list = country.getCity_list();
            System.out.println(String.format("country_code : %1$s, country_name : %2$s", country_code, country_name));
            city_list.forEach(city -> {
                System.out.println(String.format("city_code : %1$s, city_name : %2$s", city.getCode(), city.getName()));
            });
            System.out.println("----------------------------------------------------------------------");
        });
        System.out.println("****************Ordered Cities in Countries******************************");
        ArrayList<City> countryCitiesOrdered = countryDAO.getCountryCitiesOrdered("60010");
        countryCitiesOrdered.forEach(city -> {
            System.out.println(city.getName() + " , " + city.getPopulation());
        });
        System.out.println("****************Ordered Cities in Countries  USing Stream APIs ******************************");

        countryDAO.getAllCities().stream()
                .filter(c -> "60010".equals(c.getCountry_code()))
                .sorted(Comparator.comparingInt(c->c.getPopulation()))
                .collect(Collectors.toList())
                .forEach(c -> System.out.println(c.getName() + "," + c.getPopulation()));

        System.out.println("****************Lab 3 USing Stream APIs ******************************");

        System.out.println("******************* Get Highest Population City in each Country ******************");
        ArrayList<Country> countriesData = countryDAO.getCountriesData();
        countriesData.forEach(country -> {
            ArrayList<City> city_list = country.getCity_list();
            City highestCityPopulation = city_list.stream().max(Comparator.comparingInt(City::getPopulation)).get();
            System.out.println(String.format("Highest City Population :  %1$s by :  %2$s", highestCityPopulation.getName(), highestCityPopulation.getPopulation()));

        });
        System.out.println("******************* Get Highest Population City ******************");
        ArrayList<City> allCities = countryDAO.getAllCities();
        City highestCityPopulation = allCities.stream().max(Comparator.comparingInt(City::getPopulation)).get();
        System.out.println(String.format("Highest City Population :  %1$s by :  %2$s", highestCityPopulation.getName(), highestCityPopulation.getPopulation()));

        System.out.println("******************* Get Highest Population City in Contient ******************");
        allCities.stream().peek(c -> c.getContinent()).max(Comparator.comparing(c -> c.getPopulation())).stream().collect(Collectors.toList()).forEach(c -> System.out.println(c.getName()));
        allCities.stream()
                .max(Comparator.comparing(c -> c.getPopulation()))
                .stream()
                .collect(Collectors.groupingBy(c->c.getContinent()));
        
    }

}
