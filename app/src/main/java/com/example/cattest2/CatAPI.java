package com.example.cattest2;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CatAPI {
    @GET("facts")
    Call<CatDataFacts> getCatDataFacts();

}
