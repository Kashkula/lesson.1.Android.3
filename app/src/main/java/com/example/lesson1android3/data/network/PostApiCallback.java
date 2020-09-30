package com.example.lesson1android3.data.network;

import com.example.lesson1android3.model.PostsModel;

import java.util.List;

public interface PostApiCallback {
    void onSuccess(List<PostsModel> models);

    void onFail(Throwable throwable);
}
