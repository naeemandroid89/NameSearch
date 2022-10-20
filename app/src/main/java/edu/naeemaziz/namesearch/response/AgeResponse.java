package edu.naeemaziz.namesearch.response;

import java.util.List;

import edu.naeemaziz.namesearch.model.Age;

public class AgeResponse {

    List<Age> ageResponse;

    public List<Age> getAgeResponse() {
        return ageResponse;
    }

    public void setAgeResponse(List<Age> ageResponse) {
        this.ageResponse = ageResponse;
    }
}
