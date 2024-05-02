import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
public class studentDataBase {
    private static DefaultTableModel tabModel;
    private final JTable ourTable;
    private static Object[] columns = {"Period", "IDs", "Name"};
    private static TestScanner ourScanner;
    studentDataBase(TestScanner t) {
        JFrame window = new JFrame();
        ourScanner = t;
        tabModel = new DefaultTableModel(ourScanner.getLog(), columns);
        ourTable = new JTable(tabModel);
        JButton addRow = new JButton("Add New Student");
        addRow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tabModel.addRow(new Object[columns.length]);
            }
        });
        JLabel notice = new JLabel("IMPORTANT: You must click Enter over each cel you want to save for the SAVE button to work");
        notice.setBounds(200, 600, 1000, 30);
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
        window.setLocationByPlatform(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
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
