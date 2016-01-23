package com.example.shiping.glut;

import android.support.v7.app.AppCompatActivity;


import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    ListView lv;
    Context context;

    public static int [] personImages={R.drawable.user7, R.drawable.user5};
    public static String [] foodList={"Chicken Rice", "McDonald's"};
    public static String [] foodLocation={"Bedok 85", "Simei"};
    public static String [] distance={"400m", "100m"};
    public static String [] accountName={"Cow123", "Potato234"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.animation_enter_left, R.anim.animation_exit_right);
        setContentView(R.layout.activity_main);

        context=this;

        lv=(ListView) findViewById(R.id.listView);
        lv.setAdapter(new CustomAdapter(this, foodList, personImages, foodLocation, distance, accountName));

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        toolbar.setTitle("Glut");
        setSupportActionBar(toolbar);

        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.ic_add);

        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
                .setContentView(imageView)
                .setBackgroundDrawable(R.drawable.selector_button_red)
                .build();

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NewDeliveryActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.summary) {
            startActivity(new Intent(this, SummaryActivity.class));
        }

        if (id == R.id.filter) {
            startActivity(new Intent(this, FilterActivity.class));
        }

        if (id == R.id.search) {
            Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
    public void onClickOrder(View view) {
        Toast.makeText(this, "order ", Toast.LENGTH_LONG).show();
        startActivity(new Intent(this,FoodOrder.class));
    }
}
