package Controller;

import Model.VendingMachine;
import Model.Section;
import Model.Item;
import Model.Slot;
import Model.Denomination;

import java.util.Map;

/**
 * The `VendingMachineController` class serves as the controller in the MVC architecture for the vending machine.
 * It acts as an intermediary between the view and the model (VendingMachine).
 * The controller is responsible for handling user interactions, processing input, and updating the model accordingly.
 * It implements the business logic for vending and maintenance actions specified in the requirements.
 *
 * Note: This is a basic outline for the `VendingMachineController` class, and you can add more methods as needed
 * to handle additional functionalities or specific use cases.
 *
 * - Sean Andrei Olores
 * - Amiel Elijah Tenerife
 */
public class VendingMachineController {
    private VendingMachine vendingMachine;

    public VendingMachineController() {
        vendingMachine = new VendingMachine();
    }

    public void createRegularVendingMachine() {
        // TODO: Complete code here to create a regular vending machine with sections and slots
        // Example:
        // Section section1 = new Section("Section 1");
        // Slot slot1 = new Slot(new Item("Item 1", 100, 200), 10);
        // slot1.addItem();
        // section1.addSlot(slot1);
        // vendingMachine.addSection(section1);
        // ... Add more sections and slots as needed ...
    }

    public void createSpecialVendingMachine() {
        // TODO: Complete code here to create a special vending machine with sections and slots
        // Example:
        // Section section1 = new Section("Section 1");
        // Slot slot1 = new Slot(new Item("Special Item", 200, 300), 5);
        // slot1.addItem();
        // section1.addSlot(slot1);
        // vendingMachine.addSection(section1);
        // ... Add more sections and slots as needed ...
    }

    /************************************************* Vending Feature *************************************************/

    /**
     * Processes the payment by updating the denominations based on the payment amount.
     *
     * @param payment the payment amount
     */
    public void receivePayment(int payment) {
        Map<Integer, Integer> result = vendingMachine.getDenominations().calculateDenomination(payment);

        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            int denomination = entry.getKey();
            int count = entry.getValue();
            vendingMachine.getDenominations().updateDenominations(denomination, count);
        }
    }

    /**
     * Dispenses an item from the specified slot.
     *
     * @param slot the slot from which to dispense the item
     */
    public void dispenseItem(Slot slot) {
        slot.removeItem();
    }

    /**
     * Calculates and prints the change to be given based on the payment and price of an item.
     *
     * @param payment the payment amount
     * @param totalPrice   the price of the item
     */
    public void produceChange(int payment, int totalPrice) {
        Map<Integer, Integer> result = vendingMachine.getDenominations().calculateDenomination(payment - totalPrice);

        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            int denomination = entry.getKey();
            int count = entry.getValue();
            System.out.println(denomination + ": " + count);
        }
    }

    /**
     * Checks if the given payment is enough to cover the total cost of items in the vending machine.
     *
     * @param payment the payment amount
     * @return true if the payment is enough, false otherwise
     */
    private boolean isChangeEnough(int payment) {
        int totalMoney = vendingMachine.getDenominations().getTotalMoneyInDenomination();
        return payment <= totalMoney;
    }

    /*********************************************** Maintenance Feature ***********************************************/

    /**
     * Find the slot containing an item with the given name in the specified section.
     *
     * @param section  the section to search in
     * @param itemName the name of the item to find
     * @return the Slot containing the item, or null if not found
     */
    private Slot findSlotInSection(Section section, String itemName) {
        for (Slot slot : section.getSlots()) {
            if (slot.getAssociatedItemName().equalsIgnoreCase(itemName)) {
                return slot;
            }
        }
        return null;
    }

    /**
     * Restocks the items in the vending machine for the given item in the specified section.
     *
     * @param section       the section to restock items in
     * @param itemName      the name of the item to restock
     * @param restockAmount the amount to be added to the current stock of the item
     * @return true if the item was restocked successfully, false otherwise
     */
    public boolean restockItems(Section section, String itemName, int restockAmount) {
        Slot slotToRestock = findSlotInSection(section, itemName);

        if (slotToRestock == null) {
            System.out.println("Item not found in the section. Restocking failed.");
            return false;
        }

        if ((restockAmount + slotToRestock.getItemCount()) > slotToRestock.getItemLimit()) {
            System.out.println("Amount entered exceeds item limit. Restocking failed.");
            return false;
        }

        for (int i = 0; i < restockAmount; i++) {
            slotToRestock.addItem();
        }

        return true;
    }

    /**
     * Sets a new price for an item in the vending machine.
     *
     * @param section   the section containing the item
     * @param itemName  the name of the item to set the new price for
     * @param newPrice  the new price to be set for the item
     * @return true if the item's price was updated successfully, false otherwise
     */
    public boolean setItemPrice(Section section, String itemName, int newPrice) {
        Slot slotToSetPrice = findSlotInSection(section, itemName);

        if (slotToSetPrice == null) {
            System.out.println("Item not found in the section. Setting new price failed.");
            return false;
        }

        for (Item item : slotToSetPrice.getItemList()) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                item.setPrice(newPrice);
                return true;
            }
        }

        System.out.println("Item not found in the slot. Setting new price failed.");
        return false;
    }

    /**
     * Collects payments and replenishes denominations in the machine.
     */
    public void collectPayments() {
        int totalRevenue = 0;

        for (Map.Entry<Integer, Integer> entry : vendingMachine.getDenominations().getDenominationList().entrySet()) {
            totalRevenue += (entry.getKey() * entry.getValue());
        }

        System.out.println("Total revenue is " + totalRevenue);

        for (Map.Entry<Integer, Integer> entry : vendingMachine.getDenominations().getDenominationList().entrySet()) {
            vendingMachine.getDenominations().updateDenominations(entry.getKey(), 5);
        }

        System.out.println("Denominations replenished.");
    }

    public VendingMachine getVendingMachine() {
        return vendingMachine;
    }
}
