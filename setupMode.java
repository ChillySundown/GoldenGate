import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
public class setupMode {
    private static int[] adminPass = {1111, 2222, 3333, 4444};
    setupMode() {
        final JFrame miniScreen = new JFrame("Setup Mode");
        final JLabel info = new JLabel("Please enter an admin password");
        final JPasswordField adminField = new JPasswordField();
        final JLabel result = new JLabel("");
        info.setBounds(120, 300, 200, 30);
        adminField.setBounds(120, 325, 200, 30);
        result.setBounds(120, 350, 200, 30);
        miniScreen.add(info);
        miniScreen.add(adminField);
        miniScreen.add(result);
        adminField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent code) {
                String password = new String(adminField.getPassword());
                try {
                    int val = Integer.parseInt(password);
                    for(int i : adminPass)
                    {
                        if(i == val) {
                            miniScreen.dispose();
                            new studentDataBase();
                        }
                        adminField.setText("");
                        result.setText("Invalid Password. Please try again");
                    }
                } catch (Exception e) {
                    adminField.setText("");
                    result.setText("Invalid Password. Please try again");
                }
            }
        });
        miniScreen.setSize(780,700);
        miniScreen.setLayout(null);
        miniScreen.setVisible(true);
        miniScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public static void main(String[] args)
    {
        new setupMode();
    }
}
