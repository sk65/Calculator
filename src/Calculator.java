import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;


class Calculator {
    private JFrame frame;
    private JTextField display;
    private JButton[] buttons;
    private JPanel panel;
    private boolean check;

    Calculator() {
        setMainComponents();
        setDisplay();
        createButtons();
        setStyleButton();
        addButtons();
        setPanel();
        setFrame();


    }

    private void setMainComponents() {
        frame = new JFrame("Calculator");
        display = new JTextField();
        buttons = new JButton[18];
        panel = new JPanel();
    }

    private void setFrame() {
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(305, 453);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.BLACK);
        frame.add(panel);
    }

    private void setDisplay() {
        display.setBounds(10, 10, 270, 45);
        display.setFont(new Font("Arial Black", Font.BOLD, 27));
        display.setEditable(false);
        display.setFocusable(true);
        display.grabFocus();
    }

    private void setPanel() {
        panel.setBounds(0, 0, 305, 453);
        panel.setLayout(null);
        panel.setFocusable(true);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.grabFocus();
        panel.add(display);
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char symbol = e.getKeyChar();
                display.setText(display.getText() + symbol);
                panel.grabFocus();
            }
        });
    }

    private void createButtons() {
        buttons[0] = new JButton("1");
        buttons[0].setBounds(10, 275, 60, 60);
        buttons[0].addActionListener(e -> {
            if (check) {
                display.setText(null);
                check = false;
            }
            display.setText(display.getText() + "1");
        });


        buttons[1] = new JButton("2");
        buttons[1].setBounds(80, 275, 60, 60);
        buttons[1].addActionListener(e -> {
            if (check) {
                display.setText(null);
                check = false;
            }
            display.setText(display.getText() + "2");
        });


        buttons[2] = new JButton("3");
        buttons[2].setBounds(150, 275, 60, 60);
        buttons[2].addActionListener(e -> {
            if (check) {
                display.setText(null);
                check = false;
            }
            display.setText(display.getText() + "3");
        });


        buttons[3] = new JButton("4");
        buttons[3].setBounds(10, 205, 60, 60);
        buttons[3].addActionListener(e -> {
            if (check) {
                display.setText(null);
                check = false;
            }
            display.setText(display.getText() + "4");
        });


        buttons[4] = new JButton("5");
        buttons[4].setBounds(80, 205, 60, 60);
        buttons[4].addActionListener(e -> {
            if (check) {
                display.setText(null);
                check = false;
            }
            display.setText(display.getText() + "5");
        });

        buttons[5] = new JButton("6");
        buttons[5].setBounds(150, 205, 60, 60);
        buttons[5].addActionListener(e -> {
            if (check) {
                display.setText(null);
                check = false;
            }
            display.setText(display.getText() + "5");
        });


        buttons[6] = new JButton("7");
        buttons[6].setBounds(10, 135, 60, 60);
        buttons[6].addActionListener(e -> {
            if (check) {
                display.setText(null);
                check = false;
            }
            display.setText(display.getText() + "7");
        });


        buttons[7] = new JButton("8");
        buttons[7].setBounds(80, 135, 60, 60);
        buttons[7].addActionListener(e -> {
            if (check) {
                display.setText(null);
                check = false;
            }
            display.setText(display.getText() + "8");
        });


        buttons[8] = new JButton("9");
        buttons[8].setBounds(150, 135, 60, 60);
        buttons[8].addActionListener(e -> {
            if (check) {
                display.setText(null);
                check = false;
            }
            display.setText(display.getText() + "9");
        });


        buttons[9] = new JButton("0");
        buttons[9].setBounds(80, 345, 60, 60);
        buttons[9].addActionListener(e -> {
            if (check) {
                display.setText(null);
                check = false;
            }
            display.setText(display.getText() + "0");
        });


        buttons[10] = new JButton("<");
        buttons[10].setBounds(10, 345, 60, 60);
        buttons[10].addActionListener(e -> {
            if (isDisplayEmpty()) {
                return;
            }
            String temp = display.getText();
            char[] chars = temp.toCharArray();
            char[] chars1 = new char[chars.length - 1];
            System.arraycopy(chars, 0, chars1, 0, chars.length - 1);
            temp = new String(chars1);
            display.setText(temp);
        });


        buttons[11] = new JButton("+");
        buttons[11].setBounds(220, 135, 60, 130);
        buttons[11].addActionListener(e -> {
            if (isDisplayEmpty()
                    || display.getText().endsWith(".")
                    || display.getText().endsWith("*")
                    || display.getText().endsWith("-")
                    || display.getText().endsWith("+")
                    || display.getText().endsWith("/")) {
                return;
            } else {
                display.setText(display.getText() + "+");
            }
        });


        buttons[12] = new JButton("-");
        buttons[12].setBounds(220, 65, 60, 60);
        buttons[12].addActionListener(e -> {
            if (display.getText().endsWith(".")
                    || display.getText().endsWith("*")
                    || display.getText().endsWith("-")
                    || display.getText().endsWith("+")
                    || display.getText().endsWith("/")) {
                return;
            }
            display.setText(display.getText() + "-");
        });


        buttons[13] = new JButton("=");
        buttons[13].setBounds(220, 275, 60, 130);
        buttons[13].addActionListener(e -> {
            if (isDisplayEmpty()
                    || display.getText().endsWith(".")
                    || display.getText().endsWith("*")
                    || display.getText().endsWith("-")
                    || display.getText().endsWith("+")
                    || display.getText().endsWith("/")) {
                return;
            } else {
                DecimalFormat df = new DecimalFormat("###.##");
                String res = df.format(Double.valueOf(new GetResult().calcString(display.getText())));
                display.setText(res);
                check = true;
            }
        });


        buttons[14] = new JButton("*");
        buttons[14].setBounds(150, 65, 60, 60);
        buttons[14].addActionListener(e -> {
            if (isDisplayEmpty()
                    || display.getText().endsWith(".")
                    || display.getText().endsWith("*")
                    || display.getText().endsWith("-")
                    || display.getText().endsWith("+")
                    || display.getText().endsWith("/")) {
                return;
            } else {
                display.setText(display.getText() + "*");
            }
        });


        buttons[15] = new JButton("/");
        buttons[15].setBounds(80, 65, 60, 60);
        buttons[15].addActionListener(e -> {
            if (isDisplayEmpty()
                    || display.getText().endsWith(".")
                    || display.getText().endsWith("*")
                    || display.getText().endsWith("-")
                    || display.getText().endsWith("+")
                    || display.getText().endsWith("/")) {
                return;
            } else {
                display.setText(display.getText() + "/");
            }
        });


        buttons[16] = new JButton(".");
        buttons[16].setBounds(150, 345, 60, 60);
        buttons[16].addActionListener(e -> {
            if (isDisplayEmpty()
                    || display.getText().endsWith(".")
                    || display.getText().endsWith("*")
                    || display.getText().endsWith("-")
                    || display.getText().endsWith("+")
                    || display.getText().endsWith("/")) {
                return;
            }
            display.setText(display.getText() + ".");
        });


        buttons[17] = new JButton("Del");
        buttons[17].setBounds(10, 65, 60, 60);
        buttons[17].addActionListener(e -> {
            if (isDisplayEmpty()) {
                return;
            }
            display.setText(null);
        });
    }

    private void setStyleButton() {

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setFont(new Font("Arial Black", Font.BOLD, 25));
            buttons[i].setBackground(Color.WHITE);
            if (i == 17) buttons[i].setFont(new Font("Arial Black", Font.BOLD, 13));

        }
    }

    private void addButtons() {
        for (int i = 0; i < buttons.length; i++) {
            panel.add(buttons[i]);
        }
    }

    private boolean isDisplayEmpty() {
        return display.getText().isEmpty();
    }
}

class Start {
    public static void main(String[] args) {
        new Calculator();
    }
}
