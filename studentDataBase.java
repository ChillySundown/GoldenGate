import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.awt.font.*;
public class studentDataBase {
    studentDataBase() {
        JFrame screen = new JFrame("Student Database - GoldenGate");
        JLabel welcome = new JLabel("Welcome to the Student DataBase! You can add or remove kids from the hallpass registry");
        JTable kids = new JTable(15, 2);
        welcome.setBounds(350, 300, 200, 50);
        welcome.setFont(new Font("Comic Sans", Font.PLAIN, 23));
        screen.setBackground(Color.DARK_GRAY);
        screen.setSize(880, 800);
        screen.add(welcome);
        screen.add(kids);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
