import javax.swing.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.*;
public class GoldenGate
{
    public static TestScanner t = new TestScanner();
    public GoldenGate() {
        final JFrame screen = new JFrame("GoldenGate");
        final JLabel greeting = new JLabel("Please enter your 9 digit ID");
        //final TestScanner t = new TestScanner(); //TestScanner is a class made by my partner that scans IDs and adds them to log
        greeting.setBounds(500, 250, 200, 50);
        final JPasswordField enter = new JPasswordField(9);
        enter.setBounds(500, 300, 200, 50);
        final JLabel message = new JLabel("Hall Pass Status: Not in Use");
        final JLabel error = new JLabel();
        final JButton setUpButton = new JButton("Setup Mode");
        final JButton ourLog = new JButton("Display Log");
        ourLog.setBounds(1200, 100, 200, 30);
        ourLog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LogDisplay(t);
            }
        });
        setUpButton.setBounds(1200, 50, 200, 30);
        setUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new setupMode(t);                
            }
        });
        error.setBounds(500, 450, 600, 50);
        message.setBounds(500, 350, 400, 50);
        screen.add(message);
        screen.add(greeting);
        screen.add(ourLog);
        screen.add(error);
        screen.add(setUpButton);
        Color background = Color.decode("#accce6");
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