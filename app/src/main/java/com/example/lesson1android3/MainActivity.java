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
    protected int position;
    protected ArrayList<Book> list;

    protected String[] names = {"Rahat", "Shantaram", "Everybody",
            "Baby girl", "Googlebaby", "Talgar",
            "Sazhi", "Kim kardashyan", "Aze"};
    protected String[] descriptions = {"Rahat", "Shantaram", "Everybody",
            "Baby girl", "Googlebaby", "Talgar",
            "Sazhi", "Kim kardashyan", "Aze"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recylcerMethod();
    }

    private void recylcerMethod() {
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        if (list == null)
            list = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            assert list != null;
            list.add(new Book(names[i], descriptions[i]));
        }
        adapter = new BookAdapter(list, this, this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void openActivity(int position) {
        this.position = position;
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("position", this.position);
        startActivity(intent);
        Toast.makeText(this, "Succes", Toast.LENGTH_SHORT).show();
    }
}