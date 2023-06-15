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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;

public class SignUp extends AppCompatActivity {

    EditText name, mail, password, phonenumber;
    ProgressBar progressBar;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name = (EditText) findViewById(R.id.name);
        mail = (EditText) findViewById(R.id.mailaddress);
        password = (EditText) findViewById(R.id.password);
        phonenumber = (EditText) findViewById(R.id.phonenumber);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
    }


    public void registration(View view) {
        progressBar.setVisibility(View.VISIBLE);

        String nameString = name.getText().toString();
        String mailString = mail.getText().toString();
        String passwordString = password.getText().toString();
        String phonenumberString = phonenumber.getText().toString();


        auth = FirebaseAuth.getInstance();

        auth.createUserWithEmailAndPassword(mailString, passwordString).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(SignUp.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUp.this, MainActivity.class);
                    startActivity(intent);
                    progressBar.setVisibility(View.INVISIBLE);
                } else {
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(SignUp.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void toTheLoginPage(View view){
        this.finish();
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }
}