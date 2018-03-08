package com.example.fcamacho.sesion10_tabs_recycler.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fcamacho.sesion10_tabs_recycler.ActivityProduct;
import com.example.fcamacho.sesion10_tabs_recycler.R;
import com.example.fcamacho.sesion10_tabs_recycler.beans.ItemProduct;

import java.util.ArrayList;

/**
 * Created by fcamacho on 2/26/18.
 */

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder> {
    static Context context;
    private static ArrayList<ItemProduct> products;
    public AdapterProduct(ArrayList<ItemProduct> products, Context context){
        this.products = products;
        this.context = context;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView mTitle;
        public TextView mStore;
        public TextView mLocation;
        public TextView mPhone;
        public ImageView mLaptopLogo;
        public RelativeLayout mLayout;

        public ViewHolder(View view){
            super(view);

            mTitle = view.findViewById(R.id.item_product_title);
            mStore = view.findViewById(R.id.item_product_store);
            mLocation = view.findViewById(R.id.item_product_location);
            mPhone = view.findViewById(R.id.item_product_phone);
            mLaptopLogo = view.findViewById(R.id.item_product_image);
            mLayout = view.findViewById(R.id.item_product_layout);
            mPhone.setOnClickListener(this);
            mLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent;
            switch (view.getId()) {
                case R.id.item_product_phone:
                    intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+mPhone.getText().toString()));
                    context.startActivity(intent);
                    break;
                case R.id.item_product_layout:
                    int item = getAdapterPosition();
                    intent = new Intent(context, ActivityProduct.class);
                    intent.putExtra("ITEM",products.get(item));
                    context.startActivity(intent);
                    Toast.makeText(context, products.get(item).toString(), Toast.LENGTH_SHORT).show();
                    break;
            }
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
        holder.mLaptopLogo.setImageResource(products.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

}
