package com.example.demo_news.adapter;



import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.example.demo_news.R;
import com.example.demo_news.model.Source;
import com.example.demo_news.view.MainActivity2;

import java.util.ArrayList;

public class MovieArticleAdapter extends RecyclerView.Adapter<MovieArticleAdapter.ViewHolder> {

    private Context context;
    ArrayList<Source> articleArrayList;

    public MovieArticleAdapter(Context context, ArrayList<Source> articleArrayList) {
        this.context = context;
        this.articleArrayList = articleArrayList;
    }

    @NonNull
    @Override
    public MovieArticleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_each_row_movie_article,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieArticleAdapter.ViewHolder viewHolder, int i) {
        Source article=articleArrayList.get(i);
        viewHolder.tvDescription.setText(article.getDescription());
        Glide.with(context)
                .load(article.getUrl())
                .into(viewHolder.imgViewCover);

        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity2.class);
                intent.putExtra("url",article.getUrl());
                intent.putExtra("desc",article.getDescription());
                intent.putExtra("title",article.getCategory());
                intent.putExtra("name",article.getName());
                intent.putExtra("country",article.getCountry());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articleArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgViewCover;
        private final TextView tvDescription;
        private final LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgViewCover=(ImageView) itemView.findViewById(R.id.imgViewCover);
            tvDescription=(TextView) itemView.findViewById(R.id.tvDescription);
            linearLayout=(LinearLayout) itemView.findViewById(R.id.linearLayout);
        }
    }
}