import javax.swing.*;
import java.awt.event.*;
public class setupModeLock {
    private static int pWord;
    public final JFrame miniScreen;
    setupModeLock(TestScanner t) {
        miniScreen = new JFrame("Setup Mode");
        final JLabel info = new JLabel("Please enter an admin password");
        final JPasswordField adminField = new JPasswordField();
        final JLabel result = new JLabel("");
        info.setBounds(120, 300, 200, 30);
        adminField.setBounds(120, 325, 200, 30);
        result.setBounds(200, 325, 400, 30);
        miniScreen.add(info);
        miniScreen.add(adminField);
        miniScreen.add(result);
        adminField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent code) {
                String password = new String(adminField.getPassword());
                try {
                    int val = Integer.parseInt(password);
                    if(val == pWord) 
                    {       
                        miniScreen.dispose();
                        new setUpMode(t);
                    }
                    else
                    {
                        adminField.setText("");
                        result.setText("Incorrect Password");
                    }
                } catch (Exception e) {
                    adminField.setText("");
                    result.setText("Invalid Password");
                }
            }
        });
        miniScreen.setSize(780,700);
        miniScreen.setVisible(true);
        miniScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public static void changePassword(int newPass)
    {
        pWord = newPass;
    }
    public static int getPword()
    {
        return pWord;
    }
}
