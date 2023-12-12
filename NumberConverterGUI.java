import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberConverterGUI extends JFrame {

    private JTextField inputTextField;
    private JButton binaryToDecimalButton;
    private JButton binaryToHexButton;
    private JButton decimalToBinaryButton;
    private JButton decimalToHexButton;
    private JTextArea resultTextArea;

    public NumberConverterGUI() {
        setTitle("Number Converter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
        addListeners();
    }

    private void initComponents() {
        inputTextField = new JTextField();
        binaryToDecimalButton = new JButton("Binary to Decimal");
        binaryToHexButton = new JButton("Binary to Hex");
        decimalToBinaryButton = new JButton("Decimal to Binary");
        decimalToHexButton = new JButton("Decimal to Hex");
        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(inputTextField)
                                        .addComponent(binaryToDecimalButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(binaryToHexButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(decimalToBinaryButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(decimalToHexButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(resultTextArea))
                                .addContainerGap())
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(inputTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(binaryToDecimalButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(binaryToHexButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(decimalToBinaryButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(decimalToHexButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(resultTextArea, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                .addContainerGap())
        );

    }

    private void addListeners() {
        binaryToDecimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertBinaryToDecimal();
            }
        });

        binaryToHexButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertBinaryToHex();
            }
        });

        decimalToBinaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertDecimalToBinary();
            }
        });

        decimalToHexButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertDecimalToHex();
            }
        });
    }

    private void convertBinaryToDecimal() {
        String binaryStr = inputTextField.getText();
        try {
            int decimalResult = Integer.parseInt(binaryStr, 2);
            resultTextArea.setText("Result: " + decimalResult);
        } catch (NumberFormatException ex) {
            resultTextArea.setText("Invalid binary input");
        }
    }

    private void convertBinaryToHex() {
        String binaryStr = inputTextField.getText();
        try {
            int decimalResult = Integer.parseInt(binaryStr, 2);
            String hexResult = Integer.toHexString(decimalResult).toUpperCase();
            resultTextArea.setText("Result: " + hexResult);
        } catch (NumberFormatException ex) {
            resultTextArea.setText("Invalid binary input");
        }
    }

    private void convertDecimalToBinary() {
        String decimalStr = inputTextField.getText();
        try {
            int decimalNum = Integer.parseInt(decimalStr);
            String binaryResult = Integer.toBinaryString(decimalNum);
            resultTextArea.setText("Result: " + binaryResult);
        } catch (NumberFormatException ex) {
            resultTextArea.setText("Invalid decimal input");
        }
    }

    private void convertDecimalToHex() {
        String decimalStr = inputTextField.getText();
        try {
            int decimalNum = Integer.parseInt(decimalStr);
            String hexResult = Integer.toHexString(decimalNum).toUpperCase();
            resultTextArea.setText("Result: " + hexResult);
        } catch (NumberFormatException ex) {
            resultTextArea.setText("Invalid decimal input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NumberConverterGUI().setVisible(true);
            }
        });
    }
}