package com.example.lesson1android3.ui.post;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson1android3.R;
import com.example.lesson1android3.adapter.PostAdapter;
import com.example.lesson1android3.data.network.PostApiCallback;
import com.example.lesson1android3.data.network.PostApiService;
import com.example.lesson1android3.model.PostsModel;

import java.util.ArrayList;
import java.util.List;

public class PostFragment extends Fragment {
    protected ArrayList<PostsModel> listModel;
    protected PostsModel model;
    protected PostApiService postApiService;
    protected RecyclerView recyclerView;
    protected PostAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        setAdapter();
    }

    private void setAdapter() {
        recyclerView.setAdapter(adapter);
    }

    private void init(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
        listModel = new ArrayList<>();
        adapter = new PostAdapter(listModel);
        model = new PostsModel();
    }
}