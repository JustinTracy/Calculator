import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Calculator extends JFrame
{
    JPanel main;

    JPanel displayPnl;
    JTextArea displayTextArea;
    JTextField otherDisplay;

    JPanel buttonPnl;
    JButton one;
    JButton two;
    JButton three;
    JButton four;
    JButton five;
    JButton six;
    JButton seven;
    JButton eight;
    JButton nine;
    JButton zero;
    JButton plus;
    JButton minus;
    JButton divide;
    JButton multiply;
    JButton equals;
    JButton backspace;
    JButton clear;
    JButton square;
    JButton squareRoot;
    JButton inverse;
    JButton decimal;
    JButton switchSigns;

    JButton blank;
    JButton blank2;

    public Calculator()
    {
        super("Calculator");
        main = new JPanel();
        main.setLayout(new BorderLayout());

        displayPnl = new JPanel();
        displayPnl.setLayout(new GridLayout(0, 1));
        otherDisplay = new JTextField();
        otherDisplay.setEditable(false);
        otherDisplay.setPreferredSize(new Dimension(100, 25));
        otherDisplay.setBackground(Color.WHITE);
        otherDisplay.setHorizontalAlignment(JTextField.CENTER);
        displayPnl.add(otherDisplay);
        displayTextArea = new JTextArea();
        displayTextArea.setPreferredSize(new Dimension(100, 50));
        displayTextArea.setFont(new Font("Arial", Font.PLAIN, 36));
        displayTextArea.setBackground(Color.WHITE);
        displayTextArea.setEditable(false);
        displayPnl.add(displayTextArea);
        main.add(displayPnl, BorderLayout.NORTH);


        buttonPnl = new JPanel();
        buttonPnl.setLayout(new GridLayout(6, 4));
        blank = new JButton("");
        blank.addActionListener((ActionEvent ae) ->
        {

        });
        buttonPnl.add(blank);

        squareRoot = new JButton("√");
        squareRoot.addActionListener((ActionEvent ae) ->
        {

        });
        buttonPnl.add(squareRoot);

        square = new JButton("x^2");
        square.addActionListener((ActionEvent ae) ->
        {

        });
        buttonPnl.add(square);

        inverse = new JButton("1/x");
        inverse.addActionListener((ActionEvent ae) ->
        {

        });
        buttonPnl.add(inverse);

        blank2 = new JButton("");
        blank2.addActionListener((ActionEvent ae) ->
        {

        });
        buttonPnl.add(blank2);

        clear = new JButton("Clear");
        clear.addActionListener((ActionEvent ae) ->
        {

        });
        buttonPnl.add(clear);

        backspace = new JButton("<-");
        backspace.addActionListener((ActionEvent ae) ->
        {

        });
        buttonPnl.add(backspace);

        divide = new JButton("/");
        divide.addActionListener((ActionEvent ae) ->
        {

        });
        buttonPnl.add(divide);

        seven = new JButton("7");
        seven.addActionListener((ActionEvent ae) ->
        {

        });
        buttonPnl.add(seven);

        eight = new JButton("8");
        eight.addActionListener((ActionEvent ae) ->
        {

        });
        buttonPnl.add(eight);

        nine = new JButton("9");
        nine.addActionListener((ActionEvent ae) ->
        {

        });
        buttonPnl.add(nine);

        multiply = new JButton("*");
        multiply.addActionListener((ActionEvent ae) ->
        {

        });
        buttonPnl.add(multiply);

        four = new JButton("4");
        four.addActionListener((ActionEvent ae) ->
        {

        });
        buttonPnl.add(four);

        five = new JButton("5");
        five.addActionListener((ActionEvent ae) ->
        {

        });
        buttonPnl.add(five);

        six = new JButton("6");
        six.addActionListener((ActionEvent ae) ->
        {

        });
        buttonPnl.add(six);

        minus = new JButton("-");
        minus.addActionListener((ActionEvent ae) ->
        {

        });
        buttonPnl.add(minus);

        one = new JButton("1");
        one.addActionListener((ActionEvent ae) ->
        {

        });
        buttonPnl.add(one);

        two = new JButton("2");
        two.addActionListener((ActionEvent ae) ->
        {

        });
        buttonPnl.add(two);

        three = new JButton("3");
        three.addActionListener((ActionEvent ae) ->
        {

        });
        buttonPnl.add(three);

        plus = new JButton("+");
        plus.addActionListener((ActionEvent ae) ->
        {

        });
        buttonPnl.add(plus);

        switchSigns = new JButton("-/+");
        switchSigns.addActionListener((ActionEvent ae) ->
        {

        });
        buttonPnl.add(switchSigns);

        zero = new JButton("0");
        zero.addActionListener((ActionEvent ae) ->
        {

        });
        buttonPnl.add(zero);

        decimal = new JButton(".");
        decimal.addActionListener((ActionEvent ae) ->
        {

        });
        buttonPnl.add(decimal);

        equals = new JButton("=");
        equals.addActionListener((ActionEvent ae) ->
        {

        });
        buttonPnl.add(equals);



        main.add(buttonPnl, BorderLayout.CENTER);
        setSize(325, 535);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(main);
    }

    public static void setButtonNumber()
    {

    }
}
