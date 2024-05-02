import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class LogDisplay {
    private static TestScanner ourScanner;
    private static DefaultTableModel tableLog;
    private static JTable tab;
    public LogDisplay(TestScanner data) {
        final JFrame window = new JFrame("GoldenGate Log");
        ourScanner = data;
        Object[] cols = {"Col1","Col2","Col3","Col4","Col5","Col6"};
        tableLog = new DefaultTableModel(data.getLog(),cols);
        window.setBounds(480, 400, 780, 700);
        tab = new JTable(tableLog);
        window.add(tab);
        window.add(new JScrollPane(tab), BorderLayout.CENTER);
        window.pack();
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
