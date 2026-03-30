import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class F extends JFrame implements ActionListener {
    private JTextField display = new JTextField("0");
    private double num1 = 0;
    private String operator = "";
    private boolean isNewNum = true;

    public F() {
        setTitle("Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 40));
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] keys = {"7","8","9","+","4","5","6","-","1","2","3","×","0",".","=","÷"};
        for (String key : keys) {
            JButton btn = new JButton(key);
            btn.setFont(new Font("Arial", Font.BOLD, 30));
            btn.addActionListener(this);
            panel.add(btn);
        }
        add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.matches("[0-9.]")) {
            if (isNewNum) { display.setText(cmd); isNewNum = false; }
            else if (!cmd.equals(".") || !display.getText().contains(".")) {
                display.setText(display.getText() + cmd);
            }
        }
        else if (cmd.matches("[+\\-×÷]")) {
            num1 = Double.parseDouble(display.getText());
            operator = cmd;
            isNewNum = true;
        }
        else if (cmd.equals("=")) {
            double num2 = Double.parseDouble(display.getText());
            double res = switch (operator) {
                case "+" -> num1 + num2;
                case "-" -> num1 - num2;
                case "×" -> num1 * num2;
                case "÷" -> num2 == 0 ? 0 : num1 / num2;
                default -> num2;
            };
            display.setText(res % 1 == 0 ? String.valueOf((int)res) : String.valueOf(res));
            isNewNum = true;
        }
    }

    public static void main(String[] args) {
        new F().setVisible(true);
    }
}