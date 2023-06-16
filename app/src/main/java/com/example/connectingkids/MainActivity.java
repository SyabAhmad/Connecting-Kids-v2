package com.example.connectingkids;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.bottumbar,new buttomTabsFragment());
        fragmentTransaction.replace(R.id.headerbar, new headerFragment());
        //fragmentTransaction.replace(R.id.recyclerview,new addFunctions());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();




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