package com.example.connectingkids;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.bottumbar,new buttomTabsFragment());
        fragmentTransaction.replace(R.id.headerbar, new headerFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


//        fragmentTransaction.replace(R.id.headerbar, new headerFragment());
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();

    }
}