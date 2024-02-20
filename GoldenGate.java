import javax.swing.*;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.*;
public class GoldenGate
{
    GoldenGate() {
        JFrame screen = new JFrame("GoldenGate");
        JLabel greeting = new JLabel("Please enter your 9 digit ID");
        TestScanner t = new TestScanner();
        greeting.setBounds(500, 250, 200, 50);
        JPasswordField enter = new JPasswordField(9);
        enter.setBounds(500, 300, 200, 50);
        JLabel message = new JLabel();
        message.setBounds(500, 350, 400, 50);
        screen.add(message);
        screen.add(greeting);
        Color background = Color.decode("#9bddff");
        screen.getContentPane().setBackground(background);
        screen.setSize(1920, 1080);
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