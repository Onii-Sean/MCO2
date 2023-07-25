import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class Main {
    public static void main(String[] args) {
        // Creates a frame with a title
        JFrame frame = new JFrame("Vending Machine Factory");

        // Makes an image
        ImageIcon image = new ImageIcon("C:\\Users\\ASUS\\OneDrive - De La Salle University - Manila\\Desktop\\Java\\MCO2\\src\\Chapelle.png");
        // Replaces the icon image with the desired image
        frame.setIconImage(image.getImage());

        // Sets the width and height size of the app
        frame.setSize(420,420);
        // frame..setResizable(false) doesn't let a user resize the app

        // Properly Exits the program when closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Makes the app visible
        frame.setVisible(true);
    }
}
