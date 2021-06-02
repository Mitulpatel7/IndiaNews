package com.mitulpatel.indianews;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class News {

    @SerializedName("articles")
    private String title;
    private String URL;
    private String urlToImage;
    private String content;
    private String publishedAt;
    private String author;

    public News(String title, String URL, String urlToImage, String content, String publishedAt,String author) {
        this.title = title;
        this.URL = URL;
        this.urlToImage = urlToImage;
        this.content = content;
        this.publishedAt = publishedAt;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }
}

