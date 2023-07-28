import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import Model.VendingMachine;

public class Main{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        // Create the main window (JFrame)
        JFrame frame = new JFrame("Food Slots");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 500);

        ImageIcon image = new ImageIcon("C:\\Users\\ASUS\\OneDrive - De La Salle University - Manila\\Desktop\\Java\\MCO2\\src\\Chapelle.png");
        frame.setIconImage(image.getImage());


        // Create a panel with GridLayout to hold the mini panels (slots)
        JPanel mainPanel = new JPanel(new GridLayout(3, 3, 5, 5)); // Reduced spacing between slots
        mainPanel.setBackground(Color.WHITE); // Set the main panel's background color
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Add padding around the main panel

        // Sample data for demonstration
        String[] names = {"Item1", "Item2", "Item3", "Item4", "Item5", "Item6", "Item7", "Item8", "Item9"};
        double[] calories = {100.0, 150.0, 80.0, 120.0, 200.0, 90.0, 180.0, 160.0, 130.0};
        double[] prices = {1.99, 2.49, 1.29, 1.99, 3.49, 1.79, 2.99, 2.69, 2.19};
        int[] itemCounts = {7, 5, 10, 3, 8, 9, 6, 2, 4}; // Initial item counts for demonstration

        // Add components to the main panel
        for (int i = 0; i < names.length; i++) {
            mainPanel.add(createSlotPanel(names[i], calories[i], prices[i], itemCounts[i]));
        }

        // Add the main panel to the frame
        frame.add(mainPanel);

        // Display the window
        frame.setVisible(true);
    }

    private static JPanel createSlotPanel(String name, double calorie, double price, int initialItemCount) {
        JPanel slotPanel = new JPanel(new BorderLayout());
        slotPanel.setPreferredSize(new Dimension(100, 150)); // Reduced size for inner panel

        // Create a nested panel with GridLayout to hold the labels and buttons
        JPanel innerPanel = new JPanel(new GridLayout(5, 1));
        innerPanel.setBackground(new Color(0xE2C044)); // Set the inner panel color
        innerPanel.setBorder(new EmptyBorder(5, 5, 5, 5)); // Adjusted padding around the inner panel

        // Add components to the innerPanel with HTML formatting for alignment
        JLabel countLabel = new JLabel(initialItemCount + " / 10", SwingConstants.CENTER);
        countLabel.setFont(countLabel.getFont().deriveFont(16f)); // Increased font size for the counter

        JLabel nameLabel = new JLabel("<html><div style='text-align: center;'><b>" + name + "</b></div></html>", SwingConstants.CENTER);
        JLabel calLabel = new JLabel("Cal: " + calorie, SwingConstants.LEFT);
        JLabel priceLabel = new JLabel("Php: " + price, SwingConstants.LEFT);

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        JButton addButton = new JButton("+");
        JButton subtractButton = new JButton("-");

        // Set preferred size for buttons
        addButton.setPreferredSize(new Dimension(45, 25));
        subtractButton.setPreferredSize(new Dimension(45, 25));

        // Add action listeners to the buttons to handle the interactions
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int currentCount = Integer.parseInt(countLabel.getText().split(" / ")[0]);
                if (currentCount < 10) {
                    currentCount++;
                    countLabel.setText(currentCount + " / 10");
                }
            }
        });

        subtractButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int currentCount = Integer.parseInt(countLabel.getText().split(" / ")[0]);
                if (currentCount > 0) {
                    currentCount--;
                    countLabel.setText(currentCount + " / 10");
                }
            }
        });

        buttonsPanel.add(addButton);
        buttonsPanel.add(subtractButton);

        innerPanel.add(countLabel);
        innerPanel.add(nameLabel);
        innerPanel.add(calLabel);
        innerPanel.add(priceLabel);
        innerPanel.add(buttonsPanel);

        // Add the innerPanel to the slotPanel's center
        slotPanel.add(innerPanel, BorderLayout.CENTER);

        return slotPanel;
    }
}
