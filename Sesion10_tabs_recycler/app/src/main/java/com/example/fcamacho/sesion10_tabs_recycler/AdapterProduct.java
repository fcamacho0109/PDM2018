package com.example.fcamacho.sesion10_tabs_recycler;

import android.content.Context;
import android.support.v4.widget.TintableImageSourceView;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fcamacho.sesion10_tabs_recycler.beans.ItemProduct;

import java.util.ArrayList;

/**
 * Created by fcamacho on 2/26/18.
 */

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder> {
    ArrayList<ItemProduct> products;
    public AdapterProduct(ArrayList<ItemProduct> products){
        this.products = products;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTitle;
        public TextView mStore;
        public TextView mLocation;
        public TextView mPhone;
        public ImageView mLaptopLogo;

        public ViewHolder(View view){
            super(view);
            mTitle = view.findViewById(R.id.item_product_title);
            mStore = view.findViewById(R.id.item_product_store);
            mLocation = view.findViewById(R.id.item_product_location);
            mPhone = view.findViewById(R.id.item_product_phone);
            mLaptopLogo = view.findViewById(R.id.item_product_image);
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTitle.setText(products.get(position).getTitle());
        holder.mStore.setText(products.get(position).getStore());
        holder.mLocation.setText(products.get(position).getLocation());
        holder.mPhone.setText(products.get(position).getPhone());
        holder.mLaptopLogo.setImageDrawable(products.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

}
