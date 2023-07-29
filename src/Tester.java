import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tester {
    public static void main(String[] args) {
        // Set up the GUI components
        JLabel nameLbl = new JLabel("Mommy Milkshakes", JLabel.CENTER);
        JPanel mainPanel = new JPanel(new GridLayout(3, 3));
        JPanel botPanel = new JPanel();
        JButton cancelBtn = new JButton("Cancel");
        JButton doneBtn = new JButton("Done");

        JFrame frame = new JFrame("Regular Vending Machine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.setSize(320, 400);
        frame.setResizable(false); // Make the frame unresizable

        // Create borders for each panel
        Border mainBorder = BorderFactory.createTitledBorder("Menu");
        mainPanel.setBorder(mainBorder);

        Border botBorder = BorderFactory.createTitledBorder("Actions");
        botPanel.setBorder(botBorder);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 3;
        gbc.weighty = 0.15; // Update weight for name panel
        nameLbl.setFont(nameLbl.getFont().deriveFont(30f));
        frame.add(nameLbl, gbc);

        gbc.fill = GridBagConstraints.BOTH; // Fill both horizontal and vertical
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 3; // Update to 3 rows
        gbc.gridwidth = 3;
        gbc.weighty = 0.6; // 60% of the frame height for the main panel
        frame.add(mainPanel, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 4; // Update to the 4th row
        gbc.gridheight = 1; // Only 1 row for the bottom panel
        gbc.gridwidth = 3;
        gbc.weighty = 0.1; // 10% of the frame height for the bottom panel
        frame.add(botPanel, gbc);

        // Sample code to add buttons to the mainPanel
        for (int i = 1; i <= 9; i++) {
            JPanel itemPnl = new JPanel();
            JButton itemBtn = new JButton("Item " + i);
            JLabel calorie = new JLabel("Cal: " + i, SwingConstants.CENTER);
            JLabel price = new JLabel("Php: " + i, SwingConstants.CENTER);

            itemBtn.setFocusable(false);
            itemBtn.setLayout(new FlowLayout(FlowLayout.CENTER));
            itemPnl.setLayout(new BoxLayout(itemPnl, BoxLayout.Y_AXIS));
            itemPnl.setBackground(new Color(0xE3BAC6));

            // Add empty border for spacing
            int spacing = 10;
            itemPnl.setBorder(BorderFactory.createEmptyBorder(spacing, spacing, spacing, spacing));

            itemPnl.add(itemBtn);
            itemPnl.add(calorie);
            itemPnl.add(price);
            int finalI = i;
            itemBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Display the detailed information of the selected item
                    showItemDetailsDialog(finalI);
                }
            });
            mainPanel.add(itemPnl);
        }

        // Sample code for Cancel button action
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Replace with the logic to cancel the transaction
                // e.g., controller.cancelTransaction();
            }
        });
        botPanel.add(cancelBtn);

        // Sample code for Done button action
        doneBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Replace with the logic to complete the transaction
                // e.g., controller.completeTransaction();
            }
        });
        botPanel.add(doneBtn);

        frame.setVisible(true);
    }

    private static void showItemDetailsDialog(int itemNumber) {
        // Create a new frame for item details
        JFrame itemFrame = new JFrame("Item Details");
        itemFrame.setLayout(new GridLayout(6, 2));

        // Add labels for item details
        JLabel itemLeftLbl = new JLabel("Items Left: ");
        JLabel itemNameLbl = new JLabel("Item Name: ");
        JLabel itemCalorieLbl = new JLabel("Calories: ");
        JLabel itemPriceLbl = new JLabel("Price: ");

        // Add buttons to add or subtract items
        JButton addItemBtn = new JButton("Add");
        JButton subtractItemBtn = new JButton("Subtract");

        // Add labels for total and checkout
        JLabel totalLbl = new JLabel("Total: ");
        JButton checkoutBtn = new JButton("Checkout");

        // Add components to the item frame
        itemFrame.add(itemLeftLbl);
        itemFrame.add(new JLabel("Item " + itemNumber));
        itemFrame.add(itemNameLbl);
        itemFrame.add(new JLabel("Item " + itemNumber));
        itemFrame.add(itemCalorieLbl);
        itemFrame.add(new JLabel("Calories " + itemNumber));
        itemFrame.add(itemPriceLbl);
        itemFrame.add(new JLabel("Price " + itemNumber));
        itemFrame.add(addItemBtn);
        itemFrame.add(subtractItemBtn);
        itemFrame.add(totalLbl);
        itemFrame.add(new JLabel("$0.00"));
        itemFrame.add(checkoutBtn);

        // Add action listeners for the add and subtract buttons
        addItemBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Replace with the logic to add an item to the cart
            }
        });

        subtractItemBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Replace with the logic to subtract an item from the cart
            }
        });

        // Add action listener for the checkout button
        checkoutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Replace with the logic to complete the transaction and proceed to checkout
            }
        });

        // Set frame properties and make it visible
        itemFrame.setSize(300, 200);
        itemFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        itemFrame.setVisible(true);
    }
}
