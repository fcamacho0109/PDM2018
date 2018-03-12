package com.iteso.pdm18_scrollabletabs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityLogin extends AppCompatActivity {

    EditText user, password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = findViewById(R.id.editTextUser);
        password = findViewById(R.id.editTextPass);
        login = findViewById(R.id.button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUser();
                Intent intent = new Intent(ActivityLogin.this,ActivityMain.class);
                startActivity(intent);
                finish(); // borrar stack
            }
        });

    }
    public void saveUser(){ // cargar usuario
        SharedPreferences sharedPreferences = getSharedPreferences("com.iteso.store.USER_PREFERENCE",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("NAME", user.getText().toString());
        editor.putString("PASS", password.getText().toString());
        editor.putBoolean("LOGGED", true);

        editor.apply(); // lo guarda es sincrono, commit es asincrono

    }
}
