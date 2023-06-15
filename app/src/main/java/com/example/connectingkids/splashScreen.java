package com.example.connectingkids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class splashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        if (user!= null) {
            Intent intent = new Intent(splashScreen.this, MainActivity.class);
            startActivity(intent);
            finish();

        }else {
            Intent intent = new Intent(splashScreen.this, login.class);
            finish();
            startActivity(intent);

        }
    }
}