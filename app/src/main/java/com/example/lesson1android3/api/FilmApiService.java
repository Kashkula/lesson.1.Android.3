package com.example.lesson1android3.api;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.lesson1android3.model.FilmModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FilmApiService {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://ghibliapi.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    FilmApi api = retrofit.create(FilmApi.class);

    public void getBook(@NonNull final FilmApiCallback callback) {
        api.getFilms().enqueue(new Callback<List<FilmModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<FilmModel>> call, @NonNull Response<List<FilmModel>> response) {
                Log.e("TAG", "onResponse: " + response.body());
                assert response.body() != null;
                callback.onSuccessList(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<FilmModel>> call, @NonNull Throwable t) {
                Log.e("TAG", "onFailure: " + t.getLocalizedMessage());
                callback.onFailList(t);
            }
        });
    }
}
