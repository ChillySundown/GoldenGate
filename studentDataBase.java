import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.BufferedReader;
public class studentDataBase {
    private static JTable kids;
    studentDataBase() {
        JFrame screen = new JFrame("Student Database - GoldenGate");
        Object[][] objs = {{"Billy", 1123}, {"Adele", 1974}, {"Miguel", 2345}, {"Alice Walker", 9654}};
        Object[] titles = {"Name", "IDs"};
        DefaultTableModel ourModel = new DefaultTableModel(objs,titles);
        kids = new JTable(ourModel);
        JLabel welcome = new JLabel("Welcome to the Student DataBase! You can add or remove kids from the hallpass registry");
        welcome.setBounds(10, 300, 600, 50);
        welcome.setFont(new Font("Comic Sans", Font.PLAIN, 11));
        kids.setBounds(200, 500, 30, 40);
        screen.setBackground(Color.DARK_GRAY);
        screen.setSize(880, 800);
        //screen.add(welcome);
        screen.add(kids);
        JLabel test = new JLabel("Which row is being selected");
        test.setBounds(400, 500, 200, 30);
        //screen.add(test);
        screen.setVisible(true);
        screen.setLayout(null);
        screen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
