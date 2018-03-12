package com.iteso.pdm18_scrollabletabs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;


import com.iteso.pdm18_scrollabletabs.beans.User;

import java.util.Timer;
import java.util.TimerTask;

public class ActivitySplash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                User user = loadUser();
                Intent intent;
                if (user.isLogged()){
                    intent = new Intent(ActivitySplash.this,ActivityMain.class);
                }else{
                    intent = new Intent(ActivitySplash.this,ActivityLogin.class);
                }
                startActivity(intent);
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task,2000); // abre, espera 2 segundos (en splash) y luego muestra el login

    }

    public User loadUser(){ // cargar usuario
        SharedPreferences sharedPreferences = getSharedPreferences("com.iteso.store.USER_PREFERENCE",MODE_PRIVATE);
        User user = new User();
        user.setName(sharedPreferences.getString("NAME",null)); // si no la encuentra pone null
        user.setPassword(sharedPreferences.getString("PASS",null)); // si no la encuentra pone null
        user.setLogged(sharedPreferences.getBoolean("LOGGED",false)); // si no la encuentra pone false
        sharedPreferences = null;
        return user;
    }
}
