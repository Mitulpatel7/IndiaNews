package com.mitulpatel.indianews;

import android.widget.ImageView;

public class Listitem {

    public String title;
    public ImageView Image;

    public Listitem(String title, ImageView image) {
        this.title = title;
        Image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ImageView getImage() {
        return Image;
    }

    public void setImage(ImageView image) {
        Image = image;
    }
}
