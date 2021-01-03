package com.example.viewbindingu4universe.RecyclerViewActivity;


import com.example.viewbindingu4universe.RecyclerViewActivity.covid.CovidResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CovidApi {



    @GET("data.json")
    Call<CovidResponse> getCovidDetails();
}
