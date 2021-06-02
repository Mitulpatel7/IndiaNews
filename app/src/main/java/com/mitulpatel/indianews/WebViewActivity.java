package com.mitulpatel.indianews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class WebViewActivity extends AppCompatActivity {
    
    ImageView news_imgs;
    TextView news_title , news_desc , news_author;
    Context context;

    
    Button news_publish;

    WebView view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        view = findViewById(R.id.webview);

        WebSettings webSettings = view.getSettings();

        webSettings.setJavaScriptEnabled(true);

        String url = getIntent().getStringExtra("url");
        view.loadUrl(url);
        
//        news_author = findViewById(R.id.news_author);
//        news_desc = findViewById(R.id.news_description);
//        news_imgs = findViewById(R.id.news_img);
//        news_publish = findViewById(R.id.news_publish);
//        news_title = findViewById(R.id.news_title);
//
//
//        Intent intent = getIntent();
//        Bundle bundle = new Bundle();
//        bundle.getString("urlToImage");
//
//        Toast.makeText(WebViewActivity.this,  intent.getStringExtra("urlToImage"), Toast.LENGTH_SHORT).show();
//        Glide.with(WebViewActivity.this).load( bundle.toString()).into(news_imgs);
////        Glide.with(context).load(img).centerCrop().into(news_imgs);
//        news_author.setText(intent.getStringExtra("author"));
//        news_title.setText(intent.getStringExtra("title"));
//        news_desc.setText(intent.getStringExtra("content"));
//        news_publish.setText(intent.getStringExtra("publish"));


    }
}