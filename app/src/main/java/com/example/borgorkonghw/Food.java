package com.example.borgorkonghw;

import java.io.Serializable;

/***
 * Model class for food
 */
public class Food implements Serializable {

    // unique identifier of a food item
    private int id;
    // Title of the article
    private String name;
    // price
    private int price;
    // description
    private String description;
    // Resource ID of associated image (e.g. R.drawable.my_image)
    private int imageDrawableId;
    //number of items ordered
    private int quantity;



    public Food(int id, String name, int price, String description, int imageDrawableId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageDrawableId = imageDrawableId;
        this.quantity = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getImageDrawableId() {
        return imageDrawableId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
