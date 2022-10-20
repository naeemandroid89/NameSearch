package edu.naeemaziz.namesearch.networking;

import java.util.List;

import edu.naeemaziz.namesearch.model.Age;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface APIAge {

    @GET
    Call<List<Age>> getAge(@Url String name);

    //https://api.agify.io/
    // @GET("?name[]=michael&name[]=matthew&name[]=jane")
}
