package com.example.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText SignInmailEdit,SignInPasswordEdit;
    Button signUp,signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("SignIn Activity");


        SignInmailEdit = findViewById(R.id.SignInmailEdit);
        SignInPasswordEdit = findViewById(R.id.SignInPasswordEdit);
        signIn = findViewById(R.id.signIn);
        signUp = findViewById(R.id.signUp);





        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,signUp.class);
                startActivity(intent);

            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,profile.class));
            }
        });

    }
}