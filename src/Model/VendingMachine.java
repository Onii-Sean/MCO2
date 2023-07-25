package Model;

import Model.Regular;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * The Model.VendingMachine class represents a vending machine that manages slots for items and denominations for payments.
 *
 * @author Sean Andrei Olores
 * @auther Amiel Elijah Tenerife
 */
public class VendingMachine {
    protected List sectionList;
    protected Slot[] slots;

    Scanner scan = new Scanner(System.in);
    protected Denomination denominations;

    /**
     * Constructs a Model.VendingMachine object with default settings.
     * Initializes the slots and denominations.
     */
    public VendingMachine() {
        sectionList = new ArrayList<>();
        slots = new Slot[9];
        denominations = new Denomination();
    }

    /************************************************* Vending Feature *************************************************/

    /**
     * Processes the payment by updating the denominations based on the payment amount.
     *
     * @param payment the payment amount
     */
    public void receivePayment(int payment) {
        Map<Integer, Integer> result = denominations.calculateDenomination(denominations.getDenominationList(), payment);

        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            int denomination = entry.getKey();
            int count = entry.getValue();
            denominations.updateDenominations(denomination, count);
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
     * @param price   the price of the item
     */
    public void produceChange(int payment, int price) {
        Map<Integer, Integer> result = denominations.calculateDenomination(denominations.getDenominationList(), payment - price);

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
        // int totalMoney = getTotalMoney();
        // return payment <= totalMoney;
        return true;
    }

    public void cancelOrder() {}


    /*********************************************** Maintenance Feature ***********************************************/

    /**
     * Restocks the items in the vending machine.
     * Prompts the user to enter the name of the item and the amount to be added to the stock.
     */
    public void restockItems() {
        String itemName;
        int slotIndex = -1;
        int restockAmount;
        boolean isValidInput = false;

        System.out.print("Please enter the name of the item: ");
        itemName = scan.nextLine();

        for (int i = 0; i < slots.length && slotIndex == -1; i++) {
            if (itemName.equalsIgnoreCase(slots[i].getName())) {
                slotIndex = i;
            }
        }

        if (slotIndex == -1) {
            System.out.println("Model.Item cannot be found. Please try again...");
            System.out.println();
        } else {
            do {
                System.out.print("Please enter the amount you would like to add to the current stock of the item: ");

                if (!scan.hasNextInt()) {
                    System.out.println("Invalid input. Please try again...");
                    scan.next();
                } else {
                    isValidInput = true;
                }
            } while (!isValidInput);

            restockAmount = scan.nextInt();
            scan.nextLine();

            if ((restockAmount + slots[slotIndex].getItemList().size()) > slots[slotIndex].getItemLimit()) {
                System.out.println("Amount entered exceeds item limit. Please try again...");
                System.out.println();
            } else {
                for (int i = 0; i < restockAmount; i++) {
                    slots[slotIndex].addItem();
                }
            }
        }
    }

    /**
     * Sets a new price for an item in the vending machine.
     * Prompts the user to enter the name of the item and the new price.
     */
    public void setItemPrice() {
        String itemName;
        int slotIndex = -1;
        int newPrice;
        boolean isValidInput = false;

        System.out.print("Please enter the name of the item: ");
        itemName = scan.nextLine();

        for (int i = 0; i < slots.length && slotIndex == -1; i++) {
            if (itemName.equalsIgnoreCase(slots[i].getName())) {
                slotIndex = i;
            }
        }

        if (slotIndex == -1) {
            System.out.println("Model.Item cannot be found. Please try again...");
        } else {
            do {
                System.out.print("Please enter the new price (whole number): ");

                if (!scan.hasNextInt()) {
                    System.out.println("Invalid input. Please try again...");
                    scan.next();
                } else {
                    isValidInput = true;
                }
            } while (!isValidInput);

            newPrice = scan.nextInt();
            scan.nextLine();

            slots[slotIndex].setPrice(newPrice);
        }
    }

    public void collectPayments() {
        int totalRevenue = 0;
        int choice;

        for (Map.Entry<Integer, Integer> entry: denominations.getDenominationList().entrySet()) {
            totalRevenue += (entry.getKey() * entry.getValue());
        }

        System.out.println("Total revenue is " + totalRevenue);

        boolean isValidInput = false;
        do {
            System.out.print("If you would like to replenish the denominations in the machine, press 1. If not, press 0: ");

            if (!scan.hasNextInt()) {
                System.out.println("Invalid input. Please try again...");
                scan.next();
            } else {
                isValidInput = true;
            }
        } while (!isValidInput);

        choice = scan.nextInt();
        scan.nextLine();

        do {
            if (choice == 1 ) {
                for (Map.Entry<Integer, Integer> entry: denominations.getDenominationList().entrySet()) {
                    denominations.updateDenominations(entry.getKey(), 5);
                }
            } else if (choice == 0) {
                System.out.print("Going back");

                for (int i = 0; i < 3; i++) {
                    System.out.print(".");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println();
            } else {
                System.out.println("Invalid input. Please try again...");
                scan.next();
            }
        } while (choice != 1 && choice != 0);
    }

    public void replenishDenominations() {
        int denom;
        int replenish;
        boolean isValidInput = false;

        do {
            System.out.print("Please enter the denomination you would like to replenish: ");

            if (!scan.hasNextInt()) {
                System.out.println("Invalid input. Please try again...");
                scan.next();
            } else {
                isValidInput = true;
            }
        } while (!isValidInput);

        denom = scan.nextInt();
        scan.nextLine();

        if (denom != 1000 && denom != 500 && denom != 100 && denom != 50 && denom != 10 && denom != 5 && denom != 1) {
            System.out.println("Invalid denomination entered. Please try again...");
            System.out.println();
        } else {
            isValidInput = false;

            do {
                System.out.print("Please enter the amount you would like to add to the current stock of your chosen denomination: ");

                if (!scan.hasNextInt()) {
                    System.out.println("Invalid input. Please try again...");
                    scan.next();
                } else {
                    isValidInput = true;
                }
            } while (!isValidInput);

            replenish = scan.nextInt();
            scan.nextLine();

            denominations.updateDenominations(denom, denominations.getDenominationList().get(denom) + replenish);
        }
    }

    public void printTransactionSummary() {}
}
