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
import com.google.firebase.auth.FirebaseAuth;

public class forgotpassword extends AppCompatActivity {


    EditText verifymail;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
        progressBar=(ProgressBar) findViewById(R.id.progressbar);
    }

    public void forgotpasswordsubmition(View view )
    {
        progressBar.setVisibility(View.VISIBLE);
        verifymail = (EditText) findViewById(R.id.verifiemail);
        String email = verifymail.getText().toString().trim();

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(forgotpassword.this, "Password reset email send successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(new Intent(forgotpassword.this,login.class));
                } else{
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(forgotpassword.this, "Password reset email not send: Some error with email", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}