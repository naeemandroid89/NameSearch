package edu.naeemaziz.namesearch.networking;

import java.util.List;

import edu.naeemaziz.namesearch.model.Gender;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface APIGender {

    @GET
    Call<List<Gender>> getGender(@Url String name);
}
