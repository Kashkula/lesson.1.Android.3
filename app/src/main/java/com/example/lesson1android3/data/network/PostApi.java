package com.example.lesson1android3.data.network;

import com.example.lesson1android3.model.PostsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PostApi {
    @GET("posts")
    Call<List<PostsModel>> getPosts();

    @POST("posts")
    Call<PostsModel> postData(@Body PostsModel model);

    @GET("posts/{postId}")
    Call<PostsModel> deleteData(@Path("postId") Integer postId);
}
