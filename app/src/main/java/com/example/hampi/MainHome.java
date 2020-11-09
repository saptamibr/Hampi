package com.example.hampi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        //adding toolbar
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Storing place name and place image together
        ArrayList<Details> place = new ArrayList<Details>();

        place.add(new Details(R.string.p1, R.drawable.i1));
        place.add(new Details(R.string.p2, R.drawable.i2));
        place.add(new Details(R.string.p3, R.drawable.i1));
        place.add(new Details(R.string.p4, R.drawable.i2));
        place.add(new Details(R.string.p5, R.drawable.i1));
        place.add(new Details(R.string.p6, R.drawable.i2));


        MainhomeAdapter ar = new MainhomeAdapter(this, R.layout.custom_grid, place);

        GridView gridView = (GridView) findViewById(R.id.act_main_home);
        gridView.setAdapter(ar);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    Intent intent = new Intent(MainHome.this,HomeActivity.class);
                    startActivity(intent);
                }

                if(i==1){
                    Intent intent = new Intent(MainHome.this,HomeActivity.class);
                    startActivity(intent);
                }

                if(i==2){
                    Intent intent = new Intent(MainHome.this,HomeActivity.class);
                    startActivity(intent);
                }

                if(i==3){
                    Intent intent = new Intent(MainHome.this,HomeActivity.class);
                    startActivity(intent);
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.search){
            Toast.makeText(getApplicationContext(),"Clicked search",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainHome.this,youtube.class);
            startActivity(intent);

        }

        else if (id==R.id.profile){
            Intent intent = new Intent(MainHome.this,ProfileActivity.class);
            startActivity(intent);
        }

        else if (id==R.id.contact){
            Toast.makeText(getApplicationContext(),"Clicked contact",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainHome.this,Content.class);
            startActivity(intent);
        }

        return true;
    }

    @Override
    public void onBackPressed() {
//        finish();
//        System.exit(0);
        finishAffinity();
    }
}
