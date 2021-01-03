package com.example.viewbindingu4universe.RecyclerViewActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.viewbindingu4universe.R;
import com.example.viewbindingu4universe.RecyclerViewActivity.covid.CovidResponse;
import com.example.viewbindingu4universe.RecyclerViewActivity.covid.StateWise;
import com.example.viewbindingu4universe.databinding.ActivityRecyclerViewBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerViewActivity extends AppCompatActivity {

    ActivityRecyclerViewBinding activityBinding;
    StateRecyclerAdapter stateRecyclerAdapter;
    String stateCode, state, active, confirmed, deaths, recovered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_recycler_view);
        activityBinding = ActivityRecyclerViewBinding.inflate(getLayoutInflater());
        setContentView(activityBinding.getRoot());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        activityBinding.rvUser.setLayoutManager(layoutManager);

        getCovidDetails();

    }


    private void getCovidDetails() {

        CovidApi covidApi = CovidBaseClient.getBaseClient().create(CovidApi.class);
        Call<CovidResponse> call = covidApi.getCovidDetails();
        call.enqueue(new Callback<CovidResponse>() {
            @Override
            public void onResponse(Call<CovidResponse> call, Response<CovidResponse> response) {
                if (response.isSuccessful()) {
//                    Toast.makeText(getActivity(), "Response Success", Toast.LENGTH_SHORT).show();
                    CovidResponse covidResponse = response.body();
                    List<StateWise> stateWises = covidResponse.getStatewise();

                    stateRecyclerAdapter = new StateRecyclerAdapter(covidResponse.getStatewise(), RecyclerViewActivity.this);
                    activityBinding.rvUser.setAdapter(stateRecyclerAdapter);

                } else {
                    Toast.makeText(RecyclerViewActivity.this, "Something is wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CovidResponse> call, Throwable t) {
                Toast.makeText(RecyclerViewActivity.this, "in On Failre", Toast.LENGTH_SHORT).show();
            }
        });
    }
}