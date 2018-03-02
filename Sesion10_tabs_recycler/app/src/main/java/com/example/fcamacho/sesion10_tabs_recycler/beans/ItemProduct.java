package com.example.fcamacho.sesion10_tabs_recycler.beans;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.View;
import android.widget.ImageView;

import com.example.fcamacho.sesion10_tabs_recycler.R;

/**
 * Created by fcamacho on 2/26/18.
 */

public class ItemProduct {
    private String title;
    private String store;
    private String location;
    private String phone;
    private Drawable image;

    public String getTitle() {
        return title;
    }

    public String getStore() {
        return store;
    }

    public String getLocation() {
        return location;
    }

    public String getPhone() {
        return phone;
    }

    public Drawable getImage(){
        return image;
    }
    public void setStore(String store) {
        this.store = store;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(Drawable image){
        this.image = image;
    }

    public ItemProduct(String title, String store, String location, String phone, Drawable image) {
        this.title = title;
        this.store = store;
        this.location = location;
        this.phone = phone;
        this.image = image;
    }

}
