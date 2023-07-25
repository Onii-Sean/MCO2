package Model;

/**
 * Represents a section with a name and an array of slots.
 * Each section can have multiple slots to store items.
 * The maximum number of slots per section is 9.
 *
 * @author Sean Andrei Olores
 * @auther Amiel Elijah Tenerife
 */
public class Section {

    private String name;
    private Slot[] slots;

    /**
     * Constructs a new Model.Section with an empty array of slots.
     * The array will have a length of 9, representing 9 available slots for items.
     */
    public Section() {
        slots = new Slot[9];
    }

    /**
     * Get the name of the section.
     *
     * @return The name of the section.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the section.
     *
     * @param name The name to set for the section.
     */
    public void setName(String name) {
        this.name = name;
    }
}
