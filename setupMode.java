import javax.swing.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;
public class setupMode {
    private static int[] adminPass = {1111, 2222, 3333, 4444};
    setupMode() {
        final JFrame miniScreen = new JFrame("Setup Mode");
        final JLabel greeting = new JLabel("Welcome to Setup Mode!");
        final JLabel info = new JLabel("Please enter an admin password");
        final JPasswordField adminField = new JPasswordField();
        final JLabel result = new JLabel("");
        greeting.setBounds(120, 250, 200, 50);
        info.setBounds(120, 350, 200, 30);
        adminField.setBounds(120, 400, 200, 30);
        miniScreen.add(greeting);
        miniScreen.add(info);
        miniScreen.add(adminField);
        adminField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent code) {
                String password = new String(adminField.getPassword());
                try {
                    int val = Integer.parseInt(password);
                    for(int i : adminField)
                    {
                        if(i == val) {
                            //Add setUp here
                        }
                    }
                } catch (Exception e) {

                }
            }
        });
        miniScreen.setSize(480,400);
        miniScreen.setLayout(null);
        miniScreen.setVisible(true);
        miniScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args)
    {
        new setupMode();
    }
}
