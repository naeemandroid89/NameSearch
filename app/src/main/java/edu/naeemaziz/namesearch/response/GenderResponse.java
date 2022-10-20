package edu.naeemaziz.namesearch.response;

import java.util.List;

import edu.naeemaziz.namesearch.model.Gender;

public class GenderResponse {

    List<Gender> genderResponse;

    public List<Gender> getGenderResponse() {
        return genderResponse;
    }

    public void setGenderResponse(List<Gender> genderResponse) {
        this.genderResponse = genderResponse;
    }
}
