import javax.swing.*;
import java.awt.event.*;
public class GoldenGate
{
    GoldenGate() {
        JFrame screen = new JFrame("GoldenGate");
        JLabel greeting = new JLabel("Please enter your 9 digit ID");
        TestScanner t = new TestScanner();
        greeting.setBounds(450, 250, 200, 50);
        JPasswordField enter = new JPasswordField(9);
        enter.setBounds(450, 300, 200, 50);
        JLabel message = new JLabel();
        message.setBounds(450, 350, 400, 50);
        screen.add(message);
        screen.add(greeting);
        screen.setSize(580, 500);
        screen.add(enter);
        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent nums) {
                String input = new String(enter.getPassword());
                try {
                    int id = Integer.parseInt(input);
                    message.setText(t.scan(id));
                } catch(Exception e) {
                    message.setText("Invalid input. Please try again");
                }
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