import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
public class studentDataBase extends setupMode{
    private static DefaultTableModel tabModel;
    private final JTable ourTable;
    private static Object[] columns = {"Period", "IDs", "Name"};
    public static TestScanner ourScanner;
    public JFrame window;
    studentDataBase(TestScanner t) {
        super(t);
        miniScreen.dispose();
        window = new JFrame();
        window.setAlwaysOnTop(true);
        ourScanner = t;
        tabModel = new DefaultTableModel(ourScanner.getLog(), columns);
        ourTable = new JTable(tabModel);
        JButton addRow = new JButton("Add New Student");
        addRow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tabModel.addRow(new Object[columns.length]);
            }
        });
        JButton modPassword = new JButton("Change Admin Password");
        modPassword.setBounds(1000, 800, 300, 30);
        window.add(modPassword);
        modPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent c) {
                new PasswordChanger(t);
            } 
        });
        /*
        JPasswordField pWordBox1 = new JPasswordField();
        JPasswordField pWordBox2 = new JPasswordField();
        JLabel msg1 = new JLabel();
        JLabel msg2 = new JLabel();
        JLabel confirm = new JLabel("Password successfully saved");
        JLabel inError = new JLabel();
        window.add(msg1);
        window.add(inError);
        JButton modPassword = new JButton("Change Admin Password");
        window.add(modPassword);
        modPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 msg1.setText("Please enter new password");
                 window.add(pWordBox1);
                 window.revalidate();
                 window.repaint();
                pWordBox1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent d) {
                        try 
                        {
                            int val1 = Integer.parseInt(new String(pWordBox1.getPassword()));
                            window.add(pWordBox2);
                            msg2.setText("Please Re-Enter Password");
                            pWordBox2.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent n) {
                                    int val2 = Integer.parseInt(new String(pWordBox2.getPassword()));
                                    if(val1 == val2) 
                                    {
                                        changePassword(val1);
                                        confirm.setText("Password successfully saved");
                                    }
                                }
                            });
                        } catch(Exception e) {
                            inError.setText("Not a valid password. Try again!");
                        }
                        window.revalidate();
                        window.repaint();
                    }
                });
            }
        });
        */
        JLabel notice = new JLabel("IMPORTANT: You must click Enter over each cel you want to save for the SAVE button to work");
        notice.setBounds(300, 800, 1000, 30);
        window.add(notice);
        JButton save = new JButton("Save");
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent o) {
                saveData();
            }
        });
        Box addRowContainer = Box.createHorizontalBox();
        addRowContainer.add(addRow);
        window.add(addRowContainer, BorderLayout.SOUTH);
        window.add(save, BorderLayout.EAST);
        window.setSize(720, 700);
        window.add(ourTable);
        window.add(new JScrollPane(ourTable), BorderLayout.CENTER);
        window.pack();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);        
    }
    public void saveData() {
        int curRows = tabModel.getRowCount();
        for(int r = 1; r < curRows; r++)
        {
            if(tabModel.getValueAt(r,0) != null && tabModel.getValueAt(r, 1) != null && tabModel.getValueAt(r,2) != null)
            {
                int per = Integer.parseInt((String)tabModel.getValueAt(r,0));
                String name = (String)tabModel.getValueAt(r, 2);
                int id = Integer.parseInt((String)tabModel.getValueAt(r, 1));
                ourScanner.addStudent(id, name, per);
            }
        }
        tabModel = new DefaultTableModel(ourScanner.getLog(), columns);
    }
}
