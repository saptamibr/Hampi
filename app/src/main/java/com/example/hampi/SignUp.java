package com.example.hampi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Script;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Calendar;

public class SignUp extends AppCompatActivity {

    EditText etDate;
    DatePickerDialog.OnDateSetListener setListener;

    //firebase connection
    EditText mfullname,mmailid,mpsswd,mconpsswd,mdob,morigin;
    Button msignupbtn;
    FirebaseAuth firebaseAuth;
    ProgressBar progressBar;
    String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        etDate=findViewById(R.id.et_date);
        Calendar calendar=Calendar.getInstance();
        final int year=calendar.get(Calendar.YEAR);
        final int month=calendar.get(Calendar.MONTH);
        final int day=calendar.get(Calendar.DAY_OF_MONTH);

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog =new DatePickerDialog(
                        SignUp.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month=month+1;
                        String date= day+"/"+month+"/"+year;
                        etDate.setText(date);

                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });


        //firebase connection
        mfullname=findViewById(R.id.fullname);
        mmailid=findViewById(R.id.mailid);
        mpsswd=findViewById(R.id.psswd);
        mconpsswd=findViewById(R.id.conpsswd);
        mdob=findViewById(R.id.et_date);
        morigin=findViewById(R.id.origin);
        msignupbtn=findViewById(R.id.signup_btn);
        progressBar=findViewById(R.id.progressBar);

        firebaseAuth=FirebaseAuth.getInstance();
        name=mfullname.getText().toString().trim();

        //if user already logged in
        if (firebaseAuth.getCurrentUser() !=null){
            Intent intent = new Intent(SignUp.this,MainHome.class);
            startActivity(intent);
            finish();
        }

        msignupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=mmailid.getText().toString().trim();
                String passwd=mpsswd.getText().toString().trim();
                String conpasswd=mconpsswd.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    mmailid.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(passwd)){
                    mpsswd.setError("Password is required");
                    return;
                }
                if (TextUtils.isEmpty(conpasswd)){
                    mconpsswd.setError("Confirmation password is required");
                    return;
                }

                if (passwd.length()<6){
                    mpsswd.setError("Password length must be greater than 5");
                    return;
                }
                if (!passwd.equals(conpasswd)){
                    mconpsswd.setError("Password is not matching"+passwd+" "+conpasswd);
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //register the user in firebase

                firebaseAuth.createUserWithEmailAndPassword(email,passwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(SignUp.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(SignUp.this,MainHome.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(SignUp.this, "Failed to Register"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });

            }
        });

    }

    @Override
    public void onBackPressed() {
        //your method call
//        finish();
//        System.exit(0);
        finishAffinity();
    }


    public void goToLoginMethod(View view) {
        Intent intent = new Intent(SignUp.this,LoginForm.class);
        startActivity(intent);
    }

}