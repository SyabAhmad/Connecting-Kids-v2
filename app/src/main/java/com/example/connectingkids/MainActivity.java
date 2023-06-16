package com.example.connectingkids;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.android.play.core.integrity.v;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (savedInstanceState == null)
        {
            fragmentTransaction.replace(R.id.recyclerview, new homeFragment());
            fragmentTransaction.addToBackStack("1");
            fragmentTransaction.commit();
        }

        ImageButton addbutton = findViewById(R.id.addButton);
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.recyclerview, new addFunctions());
                fragmentTransaction.addToBackStack("1");
                fragmentTransaction.commit();
            }
        });

        ImageButton homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.recyclerview, new homeFragment());
                fragmentTransaction.addToBackStack("1");
                fragmentTransaction.commit();
            }
        });


//        fragmentTransaction.replace(R.id.bottumbar,new buttomTabsFragment());
//        fragmentTransaction.replace(R.id.headerbar, new headerFragment());
//        //fragmentTransaction.replace(R.id.recyclerview,new addFunctions());
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();




    }

    @Override
    public void onBackPressed() {
        // Get the current fragment
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.recyclerview);

        // Check if the current fragment is the HomeFragment
        if (currentFragment instanceof homeFragment) {
            finish();
            // Do nothing or handle the back button press as per your requirements
            // For example, you can show a toast message or prompt the user before exiting the app
            // You can remove the super.onBackPressed() call to disable the back button functionality completely
        } else {
            super.onBackPressed();
        }
    }



//    @Override
//    public void onBackPressed(){
//        final Dialog dialog = new Dialog(this);
//        dialog.setTitle("Are you sure you wan to close");
//        dialog.setCanceledOnTouchOutside(true);
//        Button okButton = new Button(this);
//        okButton.setText("OK");
//        Button cancelButton = new Button(this);
//
//        LinearLayout layout = new LinearLayout(this);
//        layout.setOrientation(LinearLayout.HORIZONTAL);
//        layout.addView(okButton);
//        layout.addView(cancelButton);
//        dialog.setContentView(layout);
//        dialog.show();
//        okButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//                finish();
//            }
//        });
//
//        cancelButton.setText("Cancel");
//        cancelButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//    }
}