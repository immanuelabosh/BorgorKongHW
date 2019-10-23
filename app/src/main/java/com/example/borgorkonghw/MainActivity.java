package com.example.borgorkonghw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Borgor Kong Menu");

        //get all the foods
        ArrayList<Food> foods = FakeDatabase.getAllFood();

        // Setup any handles to view objects here
        RecyclerView rvFood = findViewById(R.id.recycler);
        //improve scrolling performance
        rvFood.setHasFixedSize(true);
        // Create adapter and pass in the foods
        FoodAdapter adapter = new FoodAdapter(foods, false);
        // Attach the adapter to the recycler view to populate items
        rvFood.setAdapter(adapter);
        // Set layout manager to position the items
        rvFood.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        //view order button
        ExtendedFloatingActionButton order = findViewById(R.id.order);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go to order page when order button is clicked
                Intent intent = new Intent(getApplicationContext(), OrderActivity.class);
                //switch activity
                startActivity(intent);
            }
        });
    }
}
