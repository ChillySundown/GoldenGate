import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.BufferedReader;
public class studentDataBase {
    private DefaultTableModel ourModel;
    studentDataBase() {
        JFrame screen = new JFrame("Student Database - GoldenGate");
        Object[][] objs = {{"Billy", 1123}, {"Adele", 1974}, {"Miguel", 2345}, {"Alice Walker", 9654}};
        Object[] titles = {"Name", "IDs"};
        ourModel = new DefaultTableModel(objs,titles);
        JLabel welcome = new JLabel("Welcome to the Student DataBase! You can add or remove kids from the hallpass registry");
        welcome.setBounds(200, 500, 600, 50);
        welcome.setFont(new Font("Comic Sans", Font.PLAIN, 11));
        screen.setBackground(Color.DARK_GRAY);
        screen.setSize(880, 800);
        screen.add(welcome);
        JLabel test = new JLabel("Which row is being selected");
        test.setBounds(400, 500, 200, 30);

        JButton addStu = new JButton("Add Student");
        addStu.setBounds(200, 200, 30, 40);
        addStu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object[] buddy = null;
                ourModel.addRow(buddy);
            }
        });
        JTable kids = ourModel;
        kids.setBounds(200, 500, 30, 200);
        screen.add(kids);
        //screen.add(test);
        screen.setVisible(true);
        screen.setLayout(null);
        screen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
