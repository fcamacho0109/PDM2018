package com.example.fcamacho.tarea2;

import android.content.res.Resources;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity {
    RadioGroup colores;
    Button smallBtn;
    Button mediumBtn;
    Button largeBtn;
    Button xlargeBtn;
    Button cart;
    ImageView imageBici;
    TextView titulo_vintage;
    private boolean small_clicked = true;
    private boolean medium_clicked = true;
    private boolean large_clicked = true;
    private boolean xlarge_clicked = true;
    private int like_counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageBici = findViewById(R.id.image_view_bici);
        xlargeBtn = findViewById(R.id.button_xlarge);
        largeBtn = findViewById(R.id.button_large);
        mediumBtn = findViewById(R.id.button_medium);
        smallBtn = findViewById(R.id.button_small);
        titulo_vintage = findViewById(R.id.text_vintage_main);
        cart = findViewById(R.id.car);
        colores = findViewById(R.id.radio_group);
        xlargeBtn.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {
                xlargeSelection();
            }
        });
        largeBtn.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {
                largeSelection();
            }
        });
        mediumBtn.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {
                mediumSelection();
            }
        });
        smallBtn.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {
                smallSelection();
            }
        });
        cart.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToCart();
            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        boolean xl = xlarge_clicked;
        boolean l = large_clicked;
        boolean m = medium_clicked;
        boolean s = small_clicked;
        boolean[] btnArray = new boolean[4];
        btnArray[0] = xl;
        btnArray[1] = l;
        btnArray[2] = m;
        btnArray[3] = s;
        outState.putBooleanArray("Botones",btnArray);

        int likes = like_counter;
        outState.putInt("Likes",likes);

        int color = colores.getCheckedRadioButtonId();
        outState.putInt("Color",color);

        CharSequence carrito = cart.getText().toString();
        outState.putCharSequence("CarritoBtn",carrito);

    }
    @Override
    protected void onRestoreInstanceState(Bundle savedState) {
        super.onRestoreInstanceState(savedState);
        boolean[] btnArray ;
        btnArray = savedState.getBooleanArray("Botones");
        xlarge_clicked = !btnArray[0];
        large_clicked = !btnArray[1];
        medium_clicked = !btnArray[2];
        small_clicked = !btnArray[3];

        xlargeSelection();
        largeSelection();
        mediumSelection();
        smallSelection();

        int likes = savedState.getInt("Likes");
        like_counter = likes;

        int color = savedState.getInt("Color");
        colores.check(color);
        String carrito = (String) savedState.getCharSequence("CarritoBtn");
        if(carrito.equals(getText(R.string.string_added_cart))){
            addToCart();
        }
    }

    public void likeCount(View view) {
        like_counter++;
        Toast.makeText(this,titulo_vintage.getText().toString()+" + "+like_counter,Toast.LENGTH_SHORT).show();
    }

    public void xlargeSelection() {

        if(xlarge_clicked == true){
            xlargeBtn.setBackgroundResource(R.drawable.btn_selected_background);
            xlargeBtn.setTextColor(getResources().getColor(R.color.white));
        }else{
            xlargeBtn.setBackgroundResource(R.drawable.btn_border_background);
            xlargeBtn.setTextColor(getResources().getColor(R.color.colorPrimary));
        }
        xlarge_clicked = !xlarge_clicked;

    }

    public void largeSelection() {

        if(large_clicked == true){
            largeBtn.setBackgroundResource(R.drawable.btn_selected_background);
            largeBtn.setTextColor(getResources().getColor(R.color.white));
        }else{
            largeBtn.setBackgroundResource(R.drawable.btn_border_background);
            largeBtn.setTextColor(getResources().getColor(R.color.colorPrimary));
        }
        large_clicked = !large_clicked;
    }

    public void mediumSelection() {

        if(medium_clicked == true){
            mediumBtn.setBackgroundResource(R.drawable.btn_selected_background);
            mediumBtn.setTextColor(getResources().getColor(R.color.white));
        }else{
            mediumBtn.setBackgroundResource(R.drawable.btn_border_background);
            mediumBtn.setTextColor(getResources().getColor(R.color.colorPrimary));

        }
        medium_clicked = !medium_clicked;

    }

    public void smallSelection() {

        if(small_clicked == true){
            smallBtn.setBackgroundResource(R.drawable.btn_selected_background);
            smallBtn.setTextColor(getResources().getColor(R.color.white));
        }else{
            smallBtn.setBackgroundResource(R.drawable.btn_border_background);
            smallBtn.setTextColor(getResources().getColor(R.color.colorPrimary));
        }
        small_clicked = !small_clicked;
    }

    public void addToCart() {
        final CoordinatorLayout layout = findViewById(R.id.activity_main_coordinator);
        cart.setText(getResources().getText(R.string.string_added_cart));
        Snackbar.make(layout,"Added to cart...",Snackbar.LENGTH_INDEFINITE).setAction("UNDO", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cart.setText(getResources().getText(R.string.string_add_cart));
            }
        }).show();
    }

}
