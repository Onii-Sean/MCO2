package Model;

/**
 * The Model.Item class represents an item in a vending machine.
 * Each item has a name, price, and calorie information.
 * It also provides a maintenance feature to update the item's price.
 *
 * @author Sean Andrei Olores
 * @author Amiel Elijah Tenerife
 */
public class Item {
    private final String name;
    private int price;
    private final int calories;

    /**
     * Constructs a Model.Item object with the specified name, price, and calories.
     *
     * @param name     the name of the item
     * @param price    the price of the item
     * @param calories the calories of the item
     */
    public Item(String name, int price, int calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    /**
     * Returns the name of the item.
     *
     * @return the name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the price of the item.
     *
     * @return the price of the item
     */
    public int getPrice() {
        return price;
    }

    /**
     * Returns the calories of the item.
     *
     * @return the calories of the item
     */
    public int getCalories() {
        return calories;
    }

    /**
     * Sets a new price for the item. This is a maintenance feature.
     *
     * @param price the new price to set for the item
     */
    public void setPrice(int price) {
        this.price = price;
    }
}

