package edu.naeemaziz.namesearch.viewmodel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import edu.naeemaziz.namesearch.repository.NameSearchRepository;
import edu.naeemaziz.namesearch.response.AgeResponse;
import edu.naeemaziz.namesearch.response.CountryResponse;
import edu.naeemaziz.namesearch.response.GenderResponse;

public class NameSearchViewModel extends ViewModel {

    NameSearchRepository nameSearchRepository = new NameSearchRepository();

    public LiveData<AgeResponse> getAgeResponse(String nameQuery) {
        return nameSearchRepository.getAgeResponse(nameQuery);
    }

    public LiveData<CountryResponse> getCountryResponse(String nameQuery) {
        return nameSearchRepository.getCountryResponse(nameQuery);
    }

    public LiveData<GenderResponse> getGenderResponse(String nameQuery) {
        return nameSearchRepository.getGenderResponse(nameQuery);
    }

}
