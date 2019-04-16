import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Calculator extends JFrame
{
    JPanel main;

    JPanel displayPnl;
    private static JTextArea displayTextArea;
    private static JTextArea otherDisplay;

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
    JButton carrot;

    private static boolean firstNum = true;
    private static boolean adding = false;
    private static boolean subtracting = false;
    private static boolean multiplying = false;
    private static boolean dividing = false;
    private static boolean carroting = false;

    private static double finalNum = 0;
    private static String secondNum = "";
    private static int secondNumLength = 0;

    private static double squared = 0;
    private static double squarerooted = 0;
    private static double carrotted = 0;


    public Calculator()
    {
        super("Calculator");
        main = new JPanel();
        main.setLayout(new BorderLayout());

        displayPnl = new JPanel();
        displayPnl.setLayout(new GridLayout(0, 1));
        otherDisplay = new JTextArea();
        otherDisplay.setEditable(false);
        otherDisplay.setFont(new Font("Arial", Font.PLAIN, 24));
        otherDisplay.setPreferredSize(new Dimension(100, 25));
        otherDisplay.setBackground(Color.WHITE);
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
            System.out.println("Squared: " + squared);
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
            if (firstNum)
            {
                squared = Double.parseDouble(displayTextArea.getText());
                squared = squared * squared;
                displayTextArea.setText(String.valueOf(squared));
            }
            else
            {
                squared = Double.parseDouble(secondNum);
                squared = squared * squared;
                secondNumLength = secondNum.length();
                secondNum = String.valueOf(squared);

                String current3 = otherDisplay.getText();
                current3 = current3.substring(0,current3.length() - secondNumLength);
                otherDisplay.setText(current3);

                otherDisplay.append(String.valueOf(squared));
            }
        });
        buttonPnl.add(square);

        inverse = new JButton("1/x");
        inverse.addActionListener((ActionEvent ae) ->
        {

        });
        buttonPnl.add(inverse);

        carrot = new JButton("^");
        carrot.addActionListener((ActionEvent ae) ->
        {

        });
        buttonPnl.add(carrot);

        clear = new JButton("Clear");
        clear.addActionListener((ActionEvent ae) ->
        {
            reset();
            displayTextArea.setText("");
        });
        buttonPnl.add(clear);

        backspace = new JButton("<-");
        backspace.addActionListener((ActionEvent ae) ->
        {
            try
            {
                if (firstNum)
                {
                    String current = displayTextArea.getText();
                    current = current.substring(0,current.length() - 1);
                    displayTextArea.setText(current);
                }
                else
                {
                    String current2 = otherDisplay.getText();
                    current2 = current2.substring(0,current2.length() - 1);
                    otherDisplay.setText(current2);

                    secondNum = secondNum.substring(0,secondNum.length() - 1);
                }
            }
            catch (Exception e)
            {

            }
        });
        buttonPnl.add(backspace);

        divide = new JButton("/");
        divide.addActionListener((ActionEvent ae) ->
        {
            dividing = true;
            firstNum = false;
            otherDisplay.append("  /  ");
        });
        buttonPnl.add(divide);

        seven = new JButton("7");
        seven.addActionListener((ActionEvent ae) ->
        {
            setButtonNumber(7);
        });
        buttonPnl.add(seven);

        eight = new JButton("8");
        eight.addActionListener((ActionEvent ae) ->
        {
            setButtonNumber(8);
        });
        buttonPnl.add(eight);

        nine = new JButton("9");
        nine.addActionListener((ActionEvent ae) ->
        {
            setButtonNumber(9);
        });
        buttonPnl.add(nine);

        multiply = new JButton("*");
        multiply.addActionListener((ActionEvent ae) ->
        {
            multiplying = true;
            firstNum = false;
            otherDisplay.append("  *  ");
        });
        buttonPnl.add(multiply);

        four = new JButton("4");
        four.addActionListener((ActionEvent ae) ->
        {
            setButtonNumber(4);
        });
        buttonPnl.add(four);

        five = new JButton("5");
        five.addActionListener((ActionEvent ae) ->
        {
            setButtonNumber(5);
        });
        buttonPnl.add(five);

        six = new JButton("6");
        six.addActionListener((ActionEvent ae) ->
        {
            setButtonNumber(6);
        });
        buttonPnl.add(six);

        minus = new JButton("-");
        minus.addActionListener((ActionEvent ae) ->
        {
            subtracting = true;
            firstNum = false;
            otherDisplay.append("  -  ");
        });
        buttonPnl.add(minus);

        one = new JButton("1");
        one.addActionListener((ActionEvent ae) ->
        {
            setButtonNumber(1);
        });
        buttonPnl.add(one);

        two = new JButton("2");
        two.addActionListener((ActionEvent ae) ->
        {
            setButtonNumber(2);
        });
        buttonPnl.add(two);

        three = new JButton("3");
        three.addActionListener((ActionEvent ae) ->
        {
            setButtonNumber(3);
        });
        buttonPnl.add(three);

        plus = new JButton("+");
        plus.addActionListener((ActionEvent ae) ->
        {
            adding = true;
            firstNum = false;
            otherDisplay.append("  +  ");
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
            setButtonNumber(0);
        });
        buttonPnl.add(zero);

        decimal = new JButton(".");
        decimal.addActionListener((ActionEvent ae) ->
        {
            if (firstNum)
            {
                displayTextArea.append(".");
            }
            else
            {
                otherDisplay.append(".");
                secondNum = secondNum + ".";
            }
        });
        buttonPnl.add(decimal);

        equals = new JButton("=");
        equals.addActionListener((ActionEvent ae) ->
        {
            if (adding)
            {
                finalNum = Double.parseDouble(displayTextArea.getText()) + Double.parseDouble(secondNum);
                displayTextArea.setText(String.valueOf(finalNum));
            }
            if (subtracting)
            {
                finalNum = Double.parseDouble(displayTextArea.getText()) - Double.parseDouble(secondNum);
                displayTextArea.setText(String.valueOf(finalNum));
            }
            if (multiplying)
            {
                finalNum = Double.parseDouble(displayTextArea.getText()) * Double.parseDouble(secondNum);
                displayTextArea.setText(String.valueOf(finalNum));
            }
            if (dividing)
            {
                finalNum = Double.parseDouble(displayTextArea.getText()) / Double.parseDouble(secondNum);
                displayTextArea.setText(String.valueOf(finalNum));
            }
            reset();
        });
        buttonPnl.add(equals);

        main.add(buttonPnl, BorderLayout.CENTER);
        setSize(325, 535);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(main);
    }

    public static void setButtonNumber(int num)
    {
        if (firstNum)
        {
            displayTextArea.append(String.valueOf(num));
        }
        else
        {
            otherDisplay.append(String.valueOf(num));
            secondNum = secondNum + num;
        }
    }

    public static void reset()
    {
        adding = false;
        subtracting = false;
        multiplying = false;
        dividing = false;

        firstNum = true;
        secondNum = "";

        otherDisplay.setText("");

        squared = 0;
        squarerooted = 0;
        carrotted = 0;
        secondNumLength = 0;
    }
}
