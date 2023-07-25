package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * The Model.Slot class represents a slot in a vending machine that can hold a certain number of items.
 * It is associated with an item and keeps track of the items stored in the slot.
 *
 * @author Sean Andrei Olores
 * @author Amiel Elijah Tenerife
 */
public class Slot {
    private final Item associatedItem;
    private final int itemLimit;
    private List<Item> itemList;

    /**
     * Constructs a Model.Slot object with the specified item and item limit.
     *
     * @param item      the associated item
     * @param itemLimit the maximum number of items that can be stored in the slot
     */
    public Slot(Item item, int itemLimit) {
        this.associatedItem = item;
        this.itemLimit = itemLimit;
        this.itemList = new ArrayList<>();
    }

    /**
     * Returns the name of the associated item.
     *
     * @return the name of the associated item
     */
    public String getName() {
        return associatedItem.getName();
    }

    /**
     * Returns the price of the associated item.
     *
     * @return the price of the associated item
     */
    public int getPrice() {
        return associatedItem.getPrice();
    }

    /**
     * Returns the calorie count of the associated item.
     *
     * @return the calorie count of the associated item
     */
    public int getCalorie() {
        return associatedItem.getCalories();
    }

    /**
     * Returns the item limit of the slot.
     *
     * @return the item limit of the slot
     */
    public int getItemLimit() {
        return itemLimit;
    }

    /**
     * Returns the current number of items stored in the slot.
     *
     * @return the current number of items stored in the slot
     */
    public int getItemCount() {
        return itemList.size();
    }

    /**
     * Returns the list of items stored in the slot.
     *
     * @return the list of items stored in the slot
     */
    public List<Item> getItemList() {
        return itemList;
    }

    /**
     * Sets the price of the associated item. This is a maintenance feature.
     *
     * @param price the new price to be set for the associated item
     */
    public void setPrice(int price) {
        associatedItem.setPrice(price);
    }

    /**
     * Adds the associated item to the slot if the item limit has not been reached.
     *
     * @return true if the item was added successfully, false if the item limit has been reached
     */
    public boolean addItem() {
        if (itemList.size() < itemLimit) {
            itemList.add(associatedItem);
            return true; // Model.Item added successfully
        }
        return false; // Failed to add item
    }

    /**
     * Removes the associated item from the slot.
     */
    public void removeItem() {
        itemList.remove(associatedItem);
    }
}
