package com.example.fcamacho.sesion10_tabs_recycler.beans;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fcamacho on 2/26/18.
 */

public class ItemProduct implements Parcelable{
    private String title;
    private String store;
    private String location;
    private String phone;
    private int image;
    private int code;

    protected ItemProduct(Parcel in) {
        image = in.readInt();
        title = in.readString();
        store = in.readString();
        location = in.readString();
        phone = in.readString();
        code = in.readInt();
    }

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

    public int getImage(){
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

    public void setImage(int image){
        this.image = image;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ItemProduct(String title, String store, String location, String phone, int image, int code) {
        this.title = title;
        this.store = store;
        this.location = location;
        this.phone = phone;
        this.image = image;
        this.code = code;
    }

    @Override
    public String toString() {
        return "ItemProduct{" +
                "title='" + title + "\n" +
                ", store='" + store + "\n" +
                ", location='" + location + "\n" +
                ", phone='" + phone + "\n" +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(image);
        parcel.writeString(title);
        parcel.writeString(store);
        parcel.writeString(location);
        parcel.writeString(phone);
        parcel.writeInt(code);
    }

    public static final Parcelable.Creator<ItemProduct> CREATOR = new Parcelable.Creator<ItemProduct>(){

        @Override
        public ItemProduct createFromParcel(Parcel parcel) {
            return new ItemProduct(parcel);
        }

        @Override
        public ItemProduct[] newArray(int i) {
            return new ItemProduct[i];
        }
    };

}
