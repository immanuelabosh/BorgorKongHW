package com.example.borgorkonghw;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_view);
        this.setTitle("Your Order");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.order_title_bar, menu);
        return true;
    }

    @Override
    protected void onResume(){
        super.onResume();
        // Setup any handles to view objects here
        RecyclerView rvFood = findViewById(R.id.recycler);
        TextView warning = findViewById(R.id.textView);
        TextView cost = findViewById(R.id.cost);
        warning.setVisibility(View.GONE);
        cost.setVisibility(View.VISIBLE);
        cost.setText("$"+0);
        cost.setTextColor(Color.BLACK);
        cost.setTextSize(18);
        rvFood.setVisibility(View.GONE);
        //improve scrolling performance
        //rvFood.setHasFixedSize(true);
        //this will only get the foods that have actually been ordered
        int money = 0;
        ArrayList<Food> order = new ArrayList<>();
        for(Food item : FakeDatabase.getAllFood()){
            if (item.getQuantity() > 0) {
                //add the items to the arraylist for the recyclerview
                order.add(item);
                //calculate the total cost
                money += (item.getQuantity()*item.getPrice());
            }
        }
        //only make the recycler view visible if there are order items
        if (!order.isEmpty()) {
            rvFood.setVisibility(View.VISIBLE);
            // Create adapter and pass in the articles
            FoodAdapter adapter = new FoodAdapter(order, true);
            // Attach the adapter to the recycler view to populate items
            rvFood.setAdapter(adapter);
            // Set layout manager to position the items
            rvFood.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            //show and calculate the total cost
            cost.setText("Total Cost $" + money);
        }else {
            warning.setText("\nYour order is empty ;-;\n\nPress back to go back to the menu");
            warning.setVisibility(View.VISIBLE);
        }

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.clearOrder) {
            FakeDatabase.clearOrder();
            onResume();
            Toast.makeText(this, "Order cleared", Toast.LENGTH_SHORT)
                    .show();
        }else onBackPressed();
        return true;
    }

}
