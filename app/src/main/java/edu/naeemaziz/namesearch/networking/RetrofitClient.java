package edu.naeemaziz.namesearch.networking;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitClient {

    private APIAge ageApi;
    private APICountry countryApi;
    private APIGender genderApi;

    public RetrofitClient() {
        //mapper to map single or list of responses, addConverterFactory(GsonConverterFactory.create()) does not work for both responses
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        final Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create(mapper));
        countryApi = retrofitBuilder.baseUrl("https://api.nationalize.io/").build().create(APICountry.class);
        genderApi = retrofitBuilder.baseUrl("https://api.genderize.io/").build().create(APIGender.class);
        ageApi = retrofitBuilder.baseUrl("https://api.agify.io/").build().create(APIAge.class);
    }

    public APIAge getAgeApi() {
        return ageApi;
    }

    public APICountry getCountryApi() {
        return countryApi;
    }

    public APIGender getGenderApi() {
        return genderApi;
    }

}
