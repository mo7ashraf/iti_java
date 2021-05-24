/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countrycityassosiation;

/**
 *
 * @author dell
 */
public class City {
    private String code;
    private String name;
    private String continent;
    private float area;
    private int population;
    private String country_code;
    private boolean isCapital;

    public City(String code, String name, String continent, float area, int population, String country_code,boolean isCapital) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.area = area;
        this.population = population;
        this.country_code = country_code;
        this.isCapital=isCapital;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the continent
     */
    public String getContinent() {
        return continent;
    }

    /**
     * @param continent the continent to set
     */
    public void setContinent(String continent) {
        this.continent = continent;
    }

    /**
     * @return the area
     */
    public float getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(float area) {
        this.area = area;
    }

    /**
     * @return the population
     */
    public int getPopulation() {
        return population;
    }

    /**
     * @param population the population to set
     */
    public void setPopulation(int population) {
        this.population = population;
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
     * @return the isCapital
     */
    public boolean isIsCapital() {
        return isCapital;
    }

    /**
     * @param isCapital the isCapital to set
     */
    public void setIsCapital(boolean isCapital) {
        this.isCapital = isCapital;
    }
}
