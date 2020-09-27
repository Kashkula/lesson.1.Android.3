package com.example.lesson1android3.api;

import com.example.lesson1android3.model.FilmModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FilmApi {
    @GET("films")
    Call<List<FilmModel>> getFilms();
}
