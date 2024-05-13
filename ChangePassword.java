import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/* ChangePassword class courtesey of Stack Overflow user Queeg */
public class ChangePassword extends JPanel {
    
    private JPasswordField newPassword1;
    private JPasswordField newPassword2;
    
    public ChangePassword() {
        setLayout(new GridBagLayout());
        Insets insets = new Insets(3,3,3,3);
        add(new JLabel("New Password"), new GridBagConstraints(0,2, 1, 1, 0,0, GridBagConstraints.EAST, GridBagConstraints.NONE, insets, 0,0));
        newPassword1 = new JPasswordField(30);
        add(newPassword1, new GridBagConstraints(1,2, 1, 1, 0,0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0,0));
        add(new JLabel("Repeat Password"), new GridBagConstraints(0,3, 1, 1, 0,0, GridBagConstraints.EAST, GridBagConstraints.NONE, insets, 0,0));
        newPassword2 = new JPasswordField();
        add(newPassword2, new GridBagConstraints(1,3, 1, 1, 0,0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0,0));
    }
    
    public char[] getNewPassword1() {
        return newPassword1.getPassword();
    }
    
    public char[] getNewPassword2() {
        return newPassword2.getPassword();
    }
    
    public static void changePassword() {
        ChangePassword cp = new ChangePassword();
        if (JOptionPane.showOptionDialog(
                null, cp, "Change Password...", 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, 
                null, null, null) == JOptionPane.OK_OPTION) {
            String newPassword1 = new String(cp.getNewPassword1());
            String newPassword2 = new String(cp.getNewPassword2());
            try {
                if(newPassword1.equals(newPassword2))
                    setupModeLock.changePassword(Integer.parseInt(newPassword1));
                    JOptionPane.showMessageDialog(null, "Password changed");
            } catch(Exception mistake) {
                    JOptionPane.showMessageDialog(null, "Invalid Password Type. Try again");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Password change cancelled");
        }
    }
}