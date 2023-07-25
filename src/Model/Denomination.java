package Model;

import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * The Model.Denomination class represents a collection of denominations with their corresponding quantities.
 * It provides methods to update the denominations, calculate denominations for a given payment,
 * and display the current list of denominations.
 *
 * @author Sean Andrei Olores
 * @author Amiel Elijah Tenerife
 */
public class Denomination {
    /**
     * The map that stores the denominations and their quantities.
     */
    private Map<Integer, Integer> denominationList;

    /**
     * Constructs a new Model.Denomination object and initializes the default denominations and quantities.
     * The default denominations are 1000, 500, 100, 50, 10, 5, and 1, each with an initial quantity of 5.
     */
    public Denomination() {
        denominationList = new HashMap<>();
        denominationList.put(1000, 5);
        denominationList.put(500, 5);
        denominationList.put(100, 5);
        denominationList.put(50, 5);
        denominationList.put(10, 5);
        denominationList.put(5, 5);
        denominationList.put(1, 5);
    }

    /**
     * Updates the quantity of a specific denomination.
     *
     * @param bill The denomination value to update.
     * @param pcs  The new quantity of the denomination.
     */
    public void updateDenominations(int bill, int pcs) {
        denominationList.put(bill, pcs);
    }

    /**
     * Returns the current list of denominations and their quantities.
     *
     * @return The map containing the denominations and quantities.
     */
    public Map<Integer, Integer> getDenominationList() {
        return denominationList;
    }

    /**
     * Calculates the denominations for a given payment amount based on the available denominations.
     *
     * @param denominationList The map of available denominations and their quantities.
     * @param payment          The payment amount to calculate denominations for.
     * @return A map containing the calculated denominations and their quantities.
     */
    public static Map<Integer, Integer> calculateDenomination(Map<Integer, Integer> denominationList, int payment) {
        Map<Integer, Integer> result = new HashMap<>();

        for (Map.Entry<Integer, Integer> entry : denominationList.entrySet()) {
            int denomination = entry.getKey();
            int count = entry.getValue();

            if (payment >= denomination) {
                int numNotes = payment / denomination;
                if (numNotes > count) {
                    numNotes = count;
                }
                result.put(denomination, numNotes);
                payment -= numNotes * denomination;
            }
        }

        return result;
    }

    /**
     * Displays the current list of denominations and their quantities in a formatted manner.
     */
    public void displayDenominationList() {
        System.out.println("---------------");
        System.out.println(" DENOMINATIONS ");
        System.out.println("---------------");
        System.out.println("BILL\tPCS");
        System.out.println("---------------");

        TreeMap<Integer, Integer> sortedMap = new TreeMap<>(Collections.reverseOrder());
        sortedMap.putAll(denominationList);

        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            System.out.printf("%-7d\t%d%n", key, value);
        }

        System.out.println("---------------");
    }
}
