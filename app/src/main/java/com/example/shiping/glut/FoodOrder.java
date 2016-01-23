package com.example.shiping.glut;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FoodOrder extends AppCompatActivity {

    public double total;
    public double budg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        toolbar.setTitle("Fill Your Order");
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String sloc = getIntent().getStringExtra("loc");
        String sdel = getIntent().getStringExtra("del");
        String sfood = getIntent().getStringExtra("food");
        double sprice = getIntent().getDoubleExtra("price", 0.0);
        double sbudget = getIntent().getDoubleExtra("budget", 0.0);
        budg = sbudget;


        TextView location = (TextView) findViewById(R.id.locView);
        location.setText(sloc);
        TextView deliverer = (TextView) findViewById(R.id.delView);
        deliverer.setText(sdel);
        TextView food = (TextView) findViewById(R.id.foodView);
        food.setText(sfood);
        TextView price = (TextView) findViewById(R.id.priceView);
        price.setText("$" + String.valueOf(sprice));

        EditText text = (EditText) findViewById(R.id.editText);
        int qty = Integer.parseInt(text.getText().toString());
        total = sprice * qty;

        TextView sum = (TextView) findViewById(R.id.sumPrice);
        sum.setText("$" + String.valueOf(sprice * qty));

        TextView total = (TextView) findViewById(R.id.totalPrice);
        total.setText("$" + String.valueOf(sprice * qty));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_food_order, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.confirm) {
            if (total > budg) {
                Toast.makeText(this, "The delivery man is poor, please order less!", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "You are now saved from hunger!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MainActivity.class));
            }
        }

        return super.onOptionsItemSelected(item);
    }

}
