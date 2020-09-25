package com.example.lesson1android3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {
    protected RecyclerView recyclerView;
    protected BookAdapter adapter;
    protected ArrayList<Book> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        recylcerMethod();

    }

    private void recylcerMethod() {
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        list = new ArrayList<>();
        list.add(new Book("Rahat"));
        list.add(new Book("Shantaram"));
        list.add(new Book("Everybody"));
        list.add(new Book("Baby Girl"));
        list.add(new Book("Googlebaby"));
        list.add(new Book("Talgar"));
        list.add(new Book("Sazhi"));
        list.add(new Book("Kim kardashyan"));
        list.add(new Book("Azez"));
        adapter = new BookAdapter(list, this, this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void openActivity(int position) {
        startActivity(new Intent(this, SecondActivity.class));
        Toast.makeText(this, "Succes", Toast.LENGTH_SHORT).show();
    }
}