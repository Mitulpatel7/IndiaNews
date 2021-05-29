package com.mitulpatel.indianews;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class News {

    @SerializedName("articles")
    private String title;
    private String URL;
    private String urlToImage;

    public News(String title, String url) {
        this.title = title;
        this.URL = url;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return URL;
    }

    public void setUrl(String url) {
        this.URL = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }
}

