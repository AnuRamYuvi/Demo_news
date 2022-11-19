package com.example.demo_news.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.demo_news.R;

public class MainActivity2 extends AppCompatActivity {

    private  ImageView imgViewCover;
    private  ImageView imgViewShare;
    private  TextView tvDescription;
    private  TextView tvTitle;
    private String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imgViewCover=(ImageView) findViewById(R.id.imgViewCover);
        imgViewShare=(ImageView) findViewById(R.id.imgViewShare);
        tvDescription=(TextView) findViewById(R.id.tvDescription);
        tvTitle=(TextView) findViewById(R.id.tvTitle);
        Intent intent = getIntent();
        Glide.with(this)
                .load(intent.getStringExtra("url"))
                .into(imgViewCover);
        tvDescription.setText(intent.getStringExtra("desc"));
        tvTitle.setText(intent.getStringExtra("name"));

        url = intent.getStringExtra("url");


        imgViewShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT,url);
                startActivity(shareIntent);
            }
        });



    }
}