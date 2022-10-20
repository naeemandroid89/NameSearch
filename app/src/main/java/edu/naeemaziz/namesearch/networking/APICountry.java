package edu.naeemaziz.namesearch.networking;

import java.util.List;

import edu.naeemaziz.namesearch.model.Country;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface APICountry {

    @GET
    Call<List<Country>> getCountry(@Url String name);
}
