package com.example.cattest2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private String BASE_URL = "https://cat-fact.herokuapp.com/";
    private CatAPI catAPI;
    private CatRecyclerViewAdapter catRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        catAPI = retrofit.create(CatAPI.class);

        catAPI.getCatDataFacts().enqueue(new Callback<CatDataFacts>() {
            @Override
            public void onResponse(Call<CatDataFacts> call, Response<CatDataFacts> response) {
                configureAdapter(response.body().getAll());
            }

            @Override
            public void onFailure(Call<CatDataFacts> call, Throwable t) {

            }
        });
    }

    private void configureAdapter(List<CatData> data) {
        RecyclerView recyclerView = findViewById(R.id.parent_rview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        catRecyclerViewAdapter = new CatRecyclerViewAdapter(data);
        recyclerView.setAdapter(catRecyclerViewAdapter);
    }
}
