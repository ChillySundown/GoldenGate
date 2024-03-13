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
        greeting.setBounds(120, 250, 200, 50);
        info.setBounds(120, 350, 200, 30);
        adminField.setBounds(120, 400, 200, 30);
        miniScreen.add(greeting);
        miniScreen.add(info);
        miniScreen.add(adminField);
    }
}
