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
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //Storing place name and place image together
        ArrayList<Details> place = new ArrayList<Details>();

        place.add(new Details(R.string.p1, R.drawable.i2));
        place.add(new Details(R.string.p2, R.drawable.i2));
        place.add(new Details(R.string.p3, R.drawable.i2));
        place.add(new Details(R.string.p4, R.drawable.i2));
        place.add(new Details(R.string.p5, R.drawable.i2));
        place.add(new Details(R.string.p6, R.drawable.i2));


        DetailsAdapter ar = new DetailsAdapter(this, R.layout.list_style, place);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(ar);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    Intent intent = new Intent(HomeActivity.this,Place1Activity.class);
                    startActivity(intent);
                }

                if(i==1){
                    Intent intent = new Intent(HomeActivity.this,Place2Activity.class);
                    startActivity(intent);
                }

                if(i==2){
                    Intent intent = new Intent(HomeActivity.this,Place3Activity.class);
                    startActivity(intent);
                }

                if(i==3){
                    Intent intent = new Intent(HomeActivity.this,Place4Activity.class);
                    startActivity(intent);
                }

            }
        });

    }

}
