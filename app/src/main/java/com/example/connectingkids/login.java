package com.example.connectingkids;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.slider.RangeSlider;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class login extends AppCompatActivity {

    EditText mail;
    EditText password;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void process( View view){
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        progressBar.setVisibility(View.VISIBLE);
        mail = (EditText) findViewById(R.id.emailAddress);
        password = (EditText) findViewById(R.id.password);

        String mail1 = mail.getText().toString().trim();
        String password1 = password.getText().toString().trim();

        FirebaseAuth auth = FirebaseAuth.getInstance();

        auth.signInWithEmailAndPassword(mail1,password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressBar.setVisibility(View.INVISIBLE);
                    FirebaseUser user = auth.getCurrentUser();
                    if(user != null){
                        if (user.isEmailVerified())
                        {
                            Toast.makeText(login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(login.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            progressBar.setVisibility(View.INVISIBLE);
                            Toast.makeText(login.this, "Email Not Verified", Toast.LENGTH_SHORT).show();
                        }
                    }



                }else{
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });


//        myRef.setValue(mail.getText().toString());
//        Toast.makeText(this, "Inserting Valeus", Toast.LENGTH_SHORT).show();
//        mail.setText("");
    }

    public void gotoSignUpPage(View view){
        this.finish();
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }

    public void forgotpassword(View view)
    {
        this.finish();
        Intent intent = new Intent(this, forgotpassword.class);
        startActivity(intent);
    }
}