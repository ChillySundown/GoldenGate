import javax.swing.*;
public class ButtonEx {
    public static void main(String[] args) {
        JFrame a = new JFrame("This is a Button Example in Java Swing");
        JButton b = new JButton("Will you click me please?");
        b.setBounds(100, 100, 200, 30);
        a.add(b);
        a.setSize(480, 400);
        a.setLayout(null);
        a.setVisible(true);
    }
}
