package com.example.borgorkonghw;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {

        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView name;
        public TextView quantity;
        public TextView price;
        public ImageView photo;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(final View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            name = itemView.findViewById(R.id.name);
            quantity = itemView.findViewById(R.id.quantity);
            quantity.setVisibility(View.GONE);
            price = itemView.findViewById(R.id.price);
            photo = itemView.findViewById(R.id.foodPhoto);

        }
    }

    private List<Food> mFood;
    private boolean orderClass;
    //this flag will prevent order quantities showing up in the menu screen
    public FoodAdapter(List<Food> foods, boolean orderFlag) {
        mFood = foods;
        orderClass = orderFlag;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View foodView = inflater.inflate(R.layout.menu_item_view, parent, false);

        // Return a new holder instance
        return new ViewHolder(foodView);
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(final FoodAdapter.ViewHolder viewHolder, final int position) {
        // Get the data model based on position
        final Food food = mFood.get(position);

        //get the context
        final Context context = viewHolder.itemView.getContext();

        // Set item views based on your views and data model
        viewHolder.name.setText(food.getName());
        //this will prevent the quantity showing on the menu screen,
        //but still show it on the order screen
        if (orderClass) {
            viewHolder.quantity.setVisibility(View.VISIBLE);
            viewHolder.quantity.setText("x"+food.getQuantity());
        }
        viewHolder.price.setText("$"+food.getPrice());
        viewHolder.photo.setImageResource(food.getImageDrawableId());

        // Attach a click listener to the entire row view
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go to detailed food page when food is clicked
                Intent intent = new Intent(context, DetailedFoodView.class);
                intent.putExtra("foodID", food.getId());
                //animate the common elements (i.e. image and title)
                Pair<View, String> p1 = Pair.create((View) viewHolder.photo, "imageMain");
                Pair<View, String> p2 = Pair.create((View) viewHolder.name, "name");
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation((Activity) context, p1, p2);
                //switch activity
                 context.startActivity(intent, options.toBundle());

                //this is supposed to do a crossfade but i think makescenetransition is overriding it
                //((Activity)context).overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mFood.size();
    }

}
