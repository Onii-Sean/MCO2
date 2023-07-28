package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VendingMachineView {
    private JFrame frame;
    private JLabel titleLabel;
    private JButton createButton;
    private JButton testButton;

    public VendingMachineView() {
        createFrame();
        createLabel();
        createButtons();
        addComponentsToFrame();
    }

    private void createFrame() {
        frame = new JFrame("Vending Machine Factory");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new FlowLayout());
    }

    private void createLabel() {
        titleLabel = new JLabel("Vending Machine Factory");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
    }

    private void createButtons() {
        createButton = new JButton("CREATE");
        // createButton.setFocusable(false);
        testButton = new JButton("TEST");

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "CREATE button clicked!");
            }
        });

        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "TEST button clicked!");
            }
        });
    }

    private void addComponentsToFrame() {
        frame.add(titleLabel);
        frame.add(createButton);
        frame.add(testButton);
    }

    public void display() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VendingMachineView vendingMachineView = new VendingMachineView();
                vendingMachineView.display();
            }
        });
    }
}


