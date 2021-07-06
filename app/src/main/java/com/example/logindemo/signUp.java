package com.example.logindemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signUp extends AppCompatActivity {
    EditText signUpmailEdit,signUpPasswordEdit;
    Button signUp;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.setTitle("Sign Up activity");


        mAuth = FirebaseAuth.getInstance();
        signUpmailEdit = findViewById(R.id.signUpmailEdit);
        signUpPasswordEdit = findViewById(R.id.signUpPasswordEdit);
        signUp = findViewById(R.id.signUp);

        if(mAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();

            }

            private void Register() {

                String email = signUpmailEdit.getText().toString().trim();
                String password = signUpPasswordEdit.getText().toString().trim();

                if(email.isEmpty()){
                    signUpmailEdit.setError("Enter an email address");
                    signUpmailEdit.requestFocus();
                    return;

                }


                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){

                    signUpmailEdit.setError("Enter Vaild Email Address");
                    signUpmailEdit.requestFocus();
                    return;
                }


                if(password.isEmpty()){

                    signUpPasswordEdit.setError("Enter a strong Password");
                    signUpPasswordEdit.requestFocus();
                    return;
                }

                if(password.length()<6){
                    signUpPasswordEdit.setError("Enter atleat 6 digits");
                    signUpPasswordEdit.requestFocus();
                    return;
                }


               // firebase writing

         mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
             @Override
             public void onComplete(@NonNull @org.jetbrains.annotations.NotNull Task<AuthResult> task) {

                 if(task.isSuccessful()){
                          Toast.makeText(getApplicationContext(),"Succesfull",Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(getApplicationContext(),MainActivity.class));
                       }else {
                           Toast.makeText(getApplicationContext(),"Error !" +task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                       }
             }
         });

            }
        });



    }
}