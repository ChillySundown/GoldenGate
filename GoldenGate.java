import javax.swing.*;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.*;
public class GoldenGate
{
    GoldenGate() {
        final JFrame screen = new JFrame("GoldenGate");
        final JLabel greeting = new JLabel("Please enter your 9 digit ID");
        final TestScanner t = new TestScanner();
        greeting.setBounds(500, 250, 200, 50);
        final JPasswordField enter = new JPasswordField(9);
        enter.setBounds(500, 300, 200, 50);
        final JLabel message = new JLabel("Hall Pass Status: Not in Use");
        final JLabel error = new JLabel();
        error.setBounds(500, 450, 600, 50);
        message.setBounds(500, 350, 400, 50);
        screen.add(message);
        screen.add(greeting);
        screen.add(error);
        Color background = Color.decode("#FF6C0C");
        screen.getContentPane().setBackground(background);
        screen.setSize(1920, 1080);
        screen.add(enter);
        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent nums) {
                String input = new String(enter.getPassword());
                try {
                    int id = Integer.parseInt(input);
                    String outie = t.scan(id);
                    if(!outie.equalsIgnoreCase("Invalid Id") && !outie.equalsIgnoreCase("Someone else is using the hallpass."))
                    {    
                        if(t.validId(id) && !t.curOut().equals(""))
                        {
                            message.setText("Hall Pass Status: " + t.curOut() + " is currently using Hall Pass");
                        }
                        if(t.curOut().equals(""))
                        {
                            message.setText("Hall Pass Status: Not in use");
                        }
                        error.setText("");
                    }
                    else 
                    {
                        error.setText("ERROR: " + outie);
                    }
                } catch(Exception e) {
                    error.setText("ERROR: Invalid input. Please try again");
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