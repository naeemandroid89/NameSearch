package edu.naeemaziz.namesearch.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Country {

    @JsonProperty("country")
    public List<Country_child> country;

    @JsonProperty("name")
    public String name;

    public List<Country_child> getCountryList() {
        return country;
    }

    public void setCountryList(List<Country_child> country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
