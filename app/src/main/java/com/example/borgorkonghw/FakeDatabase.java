package com.example.borgorkonghw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/***
 * A class to simulate some data source existing. Use to practice intents and lists/RecyclerView
 * before going into APIs.
 *
 * Example usage:
 *      Article articleObject1 = FakeDatabase.getArticleById(1);
 *      System.out.println(articleObject1.getHeadline());
 *
 * Output:
 *      Diamonds, Warlords and Mercenaries: Russia’s New Playbook in Africa
 */
public class FakeDatabase {

    /***
     * Retrieves an Article object using the provided id.
     */
    public static Food getFoodById(int foodID) {
        return foods.get(foodID);
    }


    /***
     * Return an ArrayList containing all the foods in the database.
     */
    public static ArrayList<Food> getAllFood() {
        return new ArrayList<Food>((List) Arrays.asList(foods.values().toArray()));
    }

    //this will allow me to alter the quantity of each item
    //i'm not using replace bcos android studio is telling me it was added in api 24
    public static void alterDatabase(Food foodObject) {
        foods.remove(foodObject.getId());
        foods.put(foodObject.getId(), foodObject);
    }

    public static void clearOrder(){
        for (Food foodObject : foods.values()) {
            foodObject.setQuantity(0);
        }
    }

    private static LinkedHashMap<Integer, Food> foods = new LinkedHashMap<>();

    static {
        foods.put(1, new Food(
                1,
                "REBEL WHOPPER",
                5,
                "Rebel Whopper® features a patty made from plants, flame-grilled to give the irresistible smoky, BBQ flavour just like our classic Whopper. Loaded with crisp fresh lettuce, ripe hand-cut tomatoes, onion, pickles, mayo and tomato sauce on a toasted sesame seed bun. ",
                R.drawable.rebel_bopper
        ));
        foods.put(2, new Food(
                2,
                "REBEL WHOPPER CHEESE",
                6,
                "Rebel Whopper® features a patty made from plants, flame-grilled to give the irresistible smoky, BBQ flavour just like our classic Whopper. Loaded with cheese, crisp fresh lettuce, ripe hand-cut tomatoes, onion, pickles, mayo and tomato sauce on a toasted sesame seed bun.",
                R.drawable.rebel_with_cheese
        ));
        foods.put(3, new Food(
                3,
                "WHOPPER",
                5,
                "Some things just can’t be improved. The Whopper® is 100% hormone-free Aussie beef, flame-grilled that gives you the irresistible smoky, BBQ flavour. Loaded with crisp fresh lettuce, ripe hand-cut tomatoes, onion, pickles, mayo and tomato sauce on a toasted sesame seed bun. An Aussie legend for over 40 years. ",
                R.drawable.whopper
        ));
        foods.put(4, new Food(
                4,
                "DOUBLE WHOPPER",
                7,
                "Think of a Whopper®. Think of the crispy lettuce and ripe tomato. Think of the freshly-toasted sesame seed bun. Think of the flame-grilled Aussie beef. Now double it.",
                R.drawable.dbl_whopper
        ));
        foods.put(5, new Food(
                5,
                "WHOPPER CHEESE",
                6,
                "All the flame-grilled, flavour-packed perfection of a Whopper®, but topped with a slice of cheese",
                R.drawable.whopper_cheese
        ));
        foods.put(6, new Food(
                6,
                "DOUBLE WHOPPER CHEESE",
                8,
                "Double the flavour with two flame-grilled Australian beef patties with no added hormones. Topped with cheese, ripe hand-cut tomato, fresh lettuce, onion, pickles, mayo and tomato sauce on a toasted sesame seed bun. ",
                R.drawable.double_whopper_cheese
        ));
        foods.put(7, new Food(
                7,
                "ULTIMATE DOUBLE WHOPPER",
                10,
                "Hold onto your taste buds, this Whopper® has got the lot. Two flame-grilled 100% Australian beef patties with no added hormones, two slices of cheese, premium eye bacon, hand-cut tomatoes, lettuce, pickles, onion, mayo and tomato sauce on a toasted sesame seed bun.",
                R.drawable.ultimate_double
        ));
        foods.put(8, new Food(
                8,
                "ANGRY WHOPPER",
                8,
                "We took the world’s happiest burger and got it all riled up with onion, jalapeno and ketchup. This could be the first burger to bite back. ",
                R.drawable.angry_whopper
        ));
        foods.put(9, new Food(
                9,
                "WHOPPER JUNIOR",
                3,
                " It's just like the legendary Whopper®, only smaller. Same great flame-grilled Australian beef with no added hormones, ripe hand-cut tomato, fresh lettuce, onion, pickles, mayo and tomato sauce on a toasted sesame seed bun. ",
                R.drawable.whopper_jnr
        ));
        foods.put(10, new Food(
                10,
                "GRILL MASTERS SPICY CHIPOTLE ANGUS",
                11,
                "Taking burgers to the next level with our Grill Masters range. Flame-grilled, thicker, juicier 100% Aussie Angus beef placed on an Artisan Brioche bun. Topped with crispy Jalapeños, spicy Chipotle sauce, premium eye bacon and cheese. ",
                R.drawable.angus_spicy
        ));
        foods.put(11, new Food(
                11,
                "GRILL MASTERS ANGUS, BACON & CHEESE",
                11,
                "Taking burgers to the next level with our Grill Masters range. Flame-grilled, thicker, juicier 100% Aussie Angus beef placed on an Artisan Brioche bun. Then stacked high with Cheddar cheese, crispy bacon topped with a smokey BBQ sauce and pickles. ",
                R.drawable.angus_bacon
        ));
        foods.put(12, new Food(
                12,
                "GRILL MASTERS FIERY ANGUS",
                11,
                "Taking burgers to the next level with our Grill Masters range. Flame-grilled, thicker, juicier 100% Aussie Angus beef placed on an Artisan Brioche bun. Then stacked high with spicy angry onions, Jalapenos, tomatoes, lettuce, tomato relish, bacon and cheddar cheese. ",
                R.drawable.angus_fiery
        ));
        foods.put(13, new Food(
                13,
                "GRILL MASTERS SMOKEY BBQ ANGUS",
                11,
                "Taking burgers to the next level with our Grill Masters range. Flame-grilled, thicker, juicier 100% Aussie Angus beef placed on an Artisan Brioche bun. Then stacked high with bacon, spicy angry onions, BBQ, mayo and cheddar cheese. ",
                R.drawable.angus_smoky
        ));
        foods.put(14, new Food(
                14,
                "GRILL MASTERS ULTIMATE SMOKY BBQ ANGUS",
                13,
                "Taking burgers to the next level with our Grill Masters range. Double the flame-grilled, thicker, juicier 100% Aussie Angus beef, and double the cheese placed on an Artisan Brioche bun. Then stacked high with bacon, spicy angry onions, BBQ, mayo and cheddar cheese. ",
                R.drawable.angus_ult_smoky
        ));
        foods.put(15, new Food(
                15,
                "GRILL MASTERS ULTIMATE ANGUS, BACON & CHEESE",
                13,
                "Taking burgers to the next level with our Grill Masters range. With double the thicker, juicier 100% Aussie Angus beef and double the Cheddar cheese. Topped off with delicious bacon, smokey BBQ sauce and pickles. ",
                R.drawable.angus_ult_bacon
        ));
    }
}
