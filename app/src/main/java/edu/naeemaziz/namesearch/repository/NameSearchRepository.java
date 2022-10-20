package edu.naeemaziz.namesearch.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import edu.naeemaziz.namesearch.model.Age;
import edu.naeemaziz.namesearch.model.Country;
import edu.naeemaziz.namesearch.model.Gender;
import edu.naeemaziz.namesearch.networking.RetrofitClient;
import edu.naeemaziz.namesearch.response.AgeResponse;
import edu.naeemaziz.namesearch.response.CountryResponse;
import edu.naeemaziz.namesearch.response.GenderResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NameSearchRepository {

    MutableLiveData<GenderResponse> genderData = new MutableLiveData<>();
    MutableLiveData<AgeResponse> ageData = new MutableLiveData<>();
    MutableLiveData<CountryResponse> countryData = new MutableLiveData<>();
    RetrofitClient client;

    public NameSearchRepository() {
        client = new RetrofitClient();
    }

    public LiveData<AgeResponse> getAgeResponse(String nameQuery) {

        client.getAgeApi().getAge(nameQuery).enqueue(new Callback<List<Age>>() {
            @Override
            public void onResponse(Call<List<Age>> call, Response<List<Age>> response) {
                if (response != null && response.isSuccessful()) {
                    AgeResponse ageResponse = new AgeResponse();
                    ageResponse.setAgeResponse(response.body());
                    ageData.setValue(ageResponse);
                }
            }

            @Override
            public void onFailure(Call<List<Age>> call, Throwable t) {
                ageData.setValue(null);
            }
        });
        return ageData;
    }

    public LiveData<CountryResponse> getCountryResponse(String nameQuery) {

        client.getCountryApi().getCountry(nameQuery).enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                if (response != null && response.isSuccessful()) {
                    CountryResponse countryResponse = new CountryResponse();
                    countryResponse.setCountryResponse(response.body());
                    countryData.setValue(countryResponse);
                }
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                countryData.setValue(null);
            }
        });
        return countryData;
    }

    public LiveData<GenderResponse> getGenderResponse(String nameQuery) {

        client.getGenderApi().getGender(nameQuery).enqueue(new Callback<List<Gender>>() {
            @Override
            public void onResponse(Call<List<Gender>> call, Response<List<Gender>> response) {
                if (response != null && response.isSuccessful()) {
                    GenderResponse genderResponse = new GenderResponse();
                    genderResponse.setGenderResponse(response.body());
                    genderData.setValue(genderResponse);
                }
            }

            @Override
            public void onFailure(Call<List<Gender>> call, Throwable t) {
                genderData.setValue(null);
            }
        });

        return genderData;
    }
}
