package com.example.lesson1android3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    private ArrayList<Book> list;
    private Context context;
    protected OnItemClickListener listener;

    public BookAdapter(ArrayList<Book> list, Context context, OnItemClickListener listener) {
        this.list = list;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_book,
                parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getImageBook()).circleCrop().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageBook_listBook);
            textView = itemView.findViewById(R.id.textBook_listBook);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.openActivity(getAdapterPosition());
                }
            });
        }
    }
}
