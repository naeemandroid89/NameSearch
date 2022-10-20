package edu.naeemaziz.namesearch.response;

import java.util.List;

import edu.naeemaziz.namesearch.model.Country;

public class CountryResponse {

    List<Country> countryResponse;

    public List<Country> getCountryResponse() {
        return countryResponse;
    }

    public void setCountryResponse(List<Country> countryResponse) {
        this.countryResponse = countryResponse;
    }
}
