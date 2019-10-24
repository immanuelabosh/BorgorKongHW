package com.example.borgorkonghw;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class DetailedFoodView extends AppCompatActivity {

    Food foodObject;
    int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_food_view);

        //get the food object
        Intent intent = getIntent();
        foodObject = FakeDatabase.getFoodById(intent.getIntExtra("foodID", 0));

        TextView name = findViewById(R.id.name);
        TextView description = findViewById(R.id.description);
        ImageView image = findViewById(R.id.imageView);
        ImageView incBttn = findViewById(R.id.increment);
        ImageView decBttn = findViewById(R.id.decrement);
        incBttn.setClickable(true);
        decBttn.setClickable(true);

        //set the text and images
        this.setTitle(foodObject.getName());
        name.setText(foodObject.getName() + "\n\n$" + foodObject.getPrice());
        description.setText(foodObject.getDescription());
        quantity = foodObject.getQuantity();
        displayQuant();
        image.setImageResource(foodObject.getImageDrawableId());
        incBttn.setImageResource(R.drawable.ic_add_black_24dp);
        incBttn.setClickable(true);
        decBttn.setImageResource(R.drawable.ic_remove_black_24dp);
        decBttn.setClickable(true);

        //increment & decrement the quantity when bttns are pressed
        incBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity++;
                displayQuant();
            }
        });

        decBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quantity > 0) {
                    quantity--;
                    displayQuant();
                }
            }
        });


    }

    protected void onPause () {
        super.onPause();
        //on pause, change the quantity in the database
        foodObject.setQuantity(quantity);
        FakeDatabase.alterDatabase(foodObject);
    }

    //update the quantity displayed
    private void displayQuant() {
        TextView displayInteger = findViewById(R.id.quantity);
        displayInteger.setText("" + quantity);
    }

    //press the back button when the arrow in the top left is pressed
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}


