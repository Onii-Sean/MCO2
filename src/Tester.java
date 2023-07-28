import View.VendingMachineView;

import javax.swing.*;

public class Tester{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create an instance of the VendingMachineView
                VendingMachineView vendingMachineView = new VendingMachineView();
                vendingMachineView.display();
            }
        });
    }
}
