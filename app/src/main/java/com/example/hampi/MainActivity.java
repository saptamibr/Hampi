package com.example.hampi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import java.util.logging.Handler;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(1500);
                    Intent i =new Intent(MainActivity.this,SignUp.class);
                    startActivity(i);
                    finish();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();

    }
//
//    public void goToHome(View view){
//        Intent i =new Intent(this,HomeActivity.class);
//        startActivity(i);
//    }

}