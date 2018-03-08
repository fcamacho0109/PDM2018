package com.example.fcamacho.sesion10_tabs_recycler;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.fcamacho.sesion10_tabs_recycler.beans.ItemProduct;

public class ActivityProduct extends AppCompatActivity {
    EditText title,store,location,phone;
    ImageView image;
    ItemProduct itemProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        itemProduct = getIntent().getParcelableExtra("ITEM");
        title = findViewById(R.id.text_input_title);
        store = findViewById(R.id.text_input_store);
        location = findViewById(R.id.text_input_location);
        phone = findViewById(R.id.text_input_phone);
        image = findViewById(R.id.activity_detail_image);

        title.setText(itemProduct.getTitle());
        store.setText(itemProduct.getStore());
        location.setText(itemProduct.getLocation());
        phone.setText(itemProduct.getPhone());
        image.setImageResource(itemProduct.getImage());
    }

    public void onClick(View view) {
        if(view.getId() == R.id.btn_save){
           itemProduct.setTitle(title.getText().toString());
           itemProduct.setStore(store.getText().toString());
           itemProduct.setLocation(location.getText().toString());
           itemProduct.setPhone(phone.getText().toString());

            Intent intent = new Intent();
            intent.putExtra("ITEM",itemProduct);
            setResult(Activity.RESULT_OK,intent);
            finish();
        }
        else if (view.getId() == R.id.btn_cancel) {
            Intent intent = new Intent();
            intent.putExtra("ITEM",itemProduct);
            setResult(Activity.RESULT_CANCELED,intent);
            finish();
        }
        else{

        }
    }
}
