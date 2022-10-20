package edu.naeemaziz.namesearch.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Country_child {

    @JsonProperty("country_id")
    private String ID;

    @JsonProperty("probability")
    private double Probability;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getProbability() {
        return Probability;
    }

    public void setProbability(double probability) {
        Probability = probability;
    }
}
