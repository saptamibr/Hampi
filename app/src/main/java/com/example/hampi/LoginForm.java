package com.example.hampi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginForm extends AppCompatActivity {


    EditText mmailid,mpsswd;
    Button mloginbtn;
    FirebaseAuth firebaseAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        //firebase
        mmailid=findViewById(R.id.login_email);
        mpsswd=findViewById(R.id.login_psswd);

        mloginbtn=findViewById(R.id.login_btn);
        progressBar=findViewById(R.id.progressBar2);

        firebaseAuth=FirebaseAuth.getInstance();

        mloginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=mmailid.getText().toString().trim();
                String passwd=mpsswd.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    mmailid.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(passwd)){
                    mpsswd.setError("Password is required");
                    return;
                }

                if (passwd.length()<6){
                    mpsswd.setError("Password length must be greater than 5");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //authentication
                firebaseAuth.signInWithEmailAndPassword(email,passwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(LoginForm.this, "Logged in Successfully ", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginForm.this,MainHome.class);
                            startActivity(intent);
                            finish();
                        }else{
                            Toast.makeText(LoginForm.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });


            }
        });

    }

}