import javax.swing.*;
import java.awt.event.*;
public class GoldenGate
{
    GoldenGate() {
        JFrame screen = new JFrame("GoldenGate");
        JLabel greeting = new JLabel("Please enter your 9 digit ID");
        greeting.setBounds(350, 150, 200, 50);
        JTextField enter = new JTextField();
        enter.setBounds(350, 200, 200, 50);
        screen.add(greeting);
        screen.setSize(580, 500);
        screen.add(enter);
        screen.setLayout(null);
        screen.setVisible(true);
    }
    public static void main(String[] args) {
        new GoldenGate();
    }
}