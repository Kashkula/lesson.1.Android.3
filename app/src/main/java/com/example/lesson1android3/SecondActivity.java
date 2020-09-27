package com.example.lesson1android3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lesson1android3.api.FilmApiCallback;
import com.example.lesson1android3.api.FilmApiService;
import com.example.lesson1android3.model.FilmModel;

import java.util.List;

public class SecondActivity extends AppCompatActivity {
    protected int position;
    protected TextView textTitle;
    protected TextView textDesc;
    private List<FilmModel> model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        FilmApiService filmApiService = new FilmApiService();
        filmApiService.getBook(new FilmApiCallback() {
            @Override
            public void onSuccessList(List<FilmModel> models) {
                model = models;
                textTitle.setText(models.get(position).getTitle());
                textDesc.setText(models.get(position).getDescription());
            }

            @Override
            public void onFailList(Throwable throwable) {
                Log.e("TAG", "onFailList: " + throwable);
            }
        });
        Intent intent = getIntent();
        position = intent.getIntExtra("position", 0);
        textTitle = findViewById(R.id.textTitle_secondActivity);
        textDesc = findViewById(R.id.textDesc_secondActivity);

    }
}