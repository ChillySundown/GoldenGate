import javax.swing.*;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PasswordChanger extends setupMode implements ActionListener {
    JPasswordField thisField;
    JLabel success;
    Container container;
    public boolean realInput = false;
    CardLayout cardlayout;
    private String val;
    
    PasswordChanger(TestScanner t) {
        super(t);
        miniScreen.dispose();
        JFrame newPlace = new JFrame("Change Password");
        container = newPlace.getContentPane();
        cardlayout = new CardLayout();
        container.setLayout(cardlayout);
        success = new JLabel("");
        thisField = new JPasswordField();
        thisField.addActionListener(this);
        container.add("a", thisField);
        container.add("b", success);
        newPlace.setSize(300,100);
        newPlace.setVisible(true);
        newPlace.setLocationRelativeTo(null);
        newPlace.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent bro) {
        val = new String(thisField.getPassword());
        try
        {
            int pCode = Integer.parseInt(val);
            changePassword(pCode);
            success.setText("Password successfuly save. Exit now");
        } catch(Exception e) {
            success.setText("Faulty Password type. Exit and try again");
        }
        cardlayout.next(container);
    }
}
