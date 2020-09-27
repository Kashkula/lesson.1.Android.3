package com.example.lesson1android3.api;

import com.example.lesson1android3.model.FilmModel;

import java.util.List;

public interface FilmApiCallback {
    void onSuccessList(List<FilmModel> models);

    void onFailList(Throwable throwable);

}
