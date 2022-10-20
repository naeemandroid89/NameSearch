package edu.naeemaziz.namesearch.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Gender {

    @JsonProperty("count")
    private Integer count;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("name")
    private String name;

    @JsonProperty("probability")
    private Double probability;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }
}
