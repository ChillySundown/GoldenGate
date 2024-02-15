import javax.swing.*;
import java.awt.event.*;
public class GoldenGate
{
    GoldenGate() {
        JFrame screen = new JFrame("GoldenGate");
        final JLabel greeting = new JLabel("Please enter your 9 digit ID");
        TestScanner t = new TestScanner();
        greeting.setBounds(350, 150, 200, 50);
        final JPasswordField enter = new JPasswordField();
        enter.setBounds(350, 200, 200, 50);
        screen.add(greeting);
        screen.setSize(580, 500);
        screen.add(enter);
        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent nums) {
                String input = new String(enter.getPassword());
                
            }
        });
        screen.setLayout(null);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new GoldenGate();
    }
}