import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
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
    private static boolean error = false;

    private static double finalNum = 0;
    private static String secondNum = "";
    private static int secondNumLength = 0;

    private static double squared = 0;
    private static double inversed = 0;
    private static double squarerooted = 0;
    private static String carrotted = "";
    private static double switchedNum = 0;

    private static int counter = 0;

    Border border = new LineBorder(Color.BLACK, 2);
    Font buttonFont = new Font("Arial", Font.BOLD, 24);
    Color operatorColor = new Color(28, 76, 100);
    Color numberColor = new Color(255, 255, 255);
    Color removeColor = new Color(131, 15, 35);
    Color equalsColor = new Color(162, 118, 31);
    Color otherColor = new Color(23, 99, 59);
    Color textColor = new Color(1, 1, 1);

    public Calculator()
    {
        super("Calculator");
        main = new JPanel();
        main.setLayout(new BorderLayout());

        displayPnl = new JPanel();
        displayPnl.setLayout(new GridLayout(0, 1));
        otherDisplay = new JTextArea();
        otherDisplay.setEditable(false);
        otherDisplay.setBorder(border);
        otherDisplay.setFont(new Font("Arial", Font.PLAIN, 24));
        otherDisplay.setPreferredSize(new Dimension(100, 25));
        otherDisplay.setBackground(Color.LIGHT_GRAY);
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
        blank.setBorder(border);
        blank.setFont(buttonFont);
        blank.setBackground(otherColor);
        blank.setForeground(textColor);
        blank.addActionListener((ActionEvent ae) ->
        {
            System.out.println(counter);
        });
        buttonPnl.add(blank);

        squareRoot = new JButton("√");
        squareRoot.setBorder(border);
        squareRoot.setFont(buttonFont);
        squareRoot.setBackground(otherColor);
        squareRoot.setForeground(textColor);
        squareRoot.addActionListener((ActionEvent ae) ->
        {
            if (error)
            {
                error = false;
                displayTextArea.setText("");
                otherDisplay.setText("");
                reset();
            }
            try
            {
                if (!displayTextArea.getText().equals(""))
                {
                    if (firstNum)
                    {
                        squarerooted = Double.parseDouble(displayTextArea.getText());
                        squarerooted = Math.sqrt(squarerooted);
                        displayTextArea.setText(String.valueOf(squarerooted));
                    }
                    else
                    {
                        squarerooted = Double.parseDouble(secondNum);
                        squarerooted = Math.sqrt(squarerooted);
                        secondNumLength = secondNum.length();
                        secondNum = String.valueOf(squarerooted);

                        String current5 = otherDisplay.getText();
                        current5 = current5.substring(0, current5.length() - secondNumLength);
                        otherDisplay.setText(current5);

                        otherDisplay.append(String.valueOf(squarerooted));
                    }
                }
            }
            catch (Exception e)
            {
                error();
            }
        });
        buttonPnl.add(squareRoot);

        square = new JButton("x^2");
        square.setBackground(otherColor);
        square.setBorder(border);
        square.setFont(buttonFont);
        square.setForeground(textColor);
        square.addActionListener((ActionEvent ae) ->
        {
            if (error)
            {
                error = false;
                displayTextArea.setText("");
                otherDisplay.setText("");
                reset();
            }
            try
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
            }
            catch (Exception e)
            {
                error();
            }
        });
        buttonPnl.add(square);

        inverse = new JButton("1/x");
        inverse.setBackground(otherColor);
        inverse.setBorder(border);
        inverse.setFont(buttonFont);
        inverse.setForeground(textColor);
        inverse.addActionListener((ActionEvent ae) ->
        {
            if (error)
            {
                error = false;
                displayTextArea.setText("");
                otherDisplay.setText("");
                reset();
            }
            try
            {
                if (firstNum)
                {
                    inversed = Double.parseDouble(displayTextArea.getText());
                    inversed = 1 / inversed;
                    displayTextArea.setText(String.valueOf(inversed));
                }
                else
                {
                    inversed = Double.parseDouble(secondNum);
                    inversed = 1 / inversed;
                    secondNumLength = secondNum.length();
                    secondNum = String.valueOf(inversed);

                    String current4 = otherDisplay.getText();
                    current4 = current4.substring(0,current4.length() - secondNumLength);
                    otherDisplay.setText(current4);

                    otherDisplay.append(String.valueOf(inversed));
                }
            }
            catch (Exception e)
            {
                error();
            }
        });
        buttonPnl.add(inverse);

        carrot = new JButton("^");
        carrot.setBackground(otherColor);
        carrot.setBorder(border);
        carrot.setFont(buttonFont);
        carrot.setForeground(textColor);
        carrot.addActionListener((ActionEvent ae) ->
        {
            if (error)
            {
                error = false;
                displayTextArea.setText("");
                otherDisplay.setText("");
                reset();
            }
            try
            {
                if (firstNum)
                {
                    carroting = true;
                    otherDisplay.append("^");
                    firstNum = false;
                }
                else
                {
                    carroting = true;
                    otherDisplay.append("^");
                }
            }
            catch (Exception e)
            {
                error();
            }
        });
        buttonPnl.add(carrot);

        clear = new JButton("Clear");
        clear.setBackground(removeColor);
        clear.setBorder(border);
        clear.setFont(buttonFont);
        clear.setForeground(textColor);
        clear.addActionListener((ActionEvent ae) ->
        {
            if (error)
            {
                error = false;
                displayTextArea.setText("");
                otherDisplay.setText("");
                reset();
            }
            try
            {
                reset();
                displayTextArea.setText("");
            }
            catch (Exception e)
            {
                error();
            }
        });
        buttonPnl.add(clear);

        backspace = new JButton("Back");
        backspace.setBackground(removeColor);
        backspace.setBorder(border);
        backspace.setFont(buttonFont);
        backspace.setForeground(textColor);
        backspace.addActionListener((ActionEvent ae) ->
        {
            if (error)
            {
                error = false;
                displayTextArea.setText("");
                otherDisplay.setText("");
                reset();
            }
            try
            {
                try
                {
                    if (adding)
                    {

                    }
                    if (carroting)
                    {
                        carrotted = carrotted.substring(0,carrotted.length() - 1);
                    }
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
            }
            catch (Exception e)
            {
                error();
            }
        });
        buttonPnl.add(backspace);

        divide = new JButton("/");
        divide.setBackground(operatorColor);
        divide.setBorder(border);
        divide.setFont(buttonFont);
        divide.setForeground(textColor);
        divide.addActionListener((ActionEvent ae) ->
        {
            if (error)
            {
                error = false;
                displayTextArea.setText("");
                otherDisplay.setText("");
                reset();
            }
            try
            {
                counter++;
                if (counter > 1)
                {
                    getAnswer();
                    dividing = true;
                    firstNum = false;
                    otherDisplay.append("  /  ");
                }
                else
                {
                    dividing = true;
                    firstNum = false;
                    otherDisplay.append("  /  ");
                }
            }
            catch (Exception e)
            {
                error();
            }
        });
        buttonPnl.add(divide);

        seven = new JButton("7");
        seven.setBackground(numberColor);
        seven.setBorder(border);
        seven.setFont(buttonFont);
        seven.setBackground(Color.LIGHT_GRAY);
        seven.setForeground(textColor);
        seven.addActionListener((ActionEvent ae) ->
        {
            setButtonNumber(7);
        });
        buttonPnl.add(seven);

        eight = new JButton("8");
        eight.setBackground(numberColor);
        eight.setBorder(border);
        eight.setFont(buttonFont);
        eight.setBackground(Color.LIGHT_GRAY);
        eight.setForeground(textColor);
        eight.addActionListener((ActionEvent ae) ->
        {
            setButtonNumber(8);
        });
        buttonPnl.add(eight);

        nine = new JButton("9");
        nine.setBackground(numberColor);
        nine.setBorder(border);
        nine.setFont(buttonFont);
        nine.setBackground(Color.LIGHT_GRAY);
        nine.setForeground(textColor);
        nine.addActionListener((ActionEvent ae) ->
        {
            setButtonNumber(9);
        });
        buttonPnl.add(nine);

        multiply = new JButton("*");
        multiply.setBackground(operatorColor);
        multiply.setBorder(border);
        multiply.setFont(buttonFont);
        multiply.setForeground(textColor);
        multiply.addActionListener((ActionEvent ae) ->
        {
            if (error)
            {
                error = false;
                displayTextArea.setText("");
                otherDisplay.setText("");
                reset();
            }
            try
            {
                counter++;
                if (counter > 1)
                {
                    getAnswer();
                    multiplying = true;
                    firstNum = false;
                    otherDisplay.append("  *  ");
                }
                else
                {
                    multiplying = true;
                    firstNum = false;
                    otherDisplay.append("  *  ");
                }
            }
            catch (Exception e)
            {
                error();
            }
        });
        buttonPnl.add(multiply);

        four = new JButton("4");
        four.setBackground(numberColor);
        four.setBorder(border);
        four.setFont(buttonFont);
        four.setBackground(Color.LIGHT_GRAY);
        four.setForeground(textColor);
        four.addActionListener((ActionEvent ae) ->
        {
            setButtonNumber(4);
        });
        buttonPnl.add(four);

        five = new JButton("5");
        five.setBackground(numberColor);
        five.setBorder(border);
        five.setFont(buttonFont);
        five.setBackground(Color.LIGHT_GRAY);
        five.setForeground(textColor);
        five.addActionListener((ActionEvent ae) ->
        {
            setButtonNumber(5);
        });
        buttonPnl.add(five);

        six = new JButton("6");
        six.setBackground(numberColor);
        six.setBorder(border);
        six.setFont(buttonFont);
        six.setBackground(Color.LIGHT_GRAY);
        six.setForeground(textColor);
        six.addActionListener((ActionEvent ae) ->
        {
            setButtonNumber(6);
        });
        buttonPnl.add(six);

        minus = new JButton("-");
        minus.setBackground(operatorColor);
        minus.setBorder(border);
        minus.setFont(buttonFont);
        minus.setForeground(textColor);
        minus.addActionListener((ActionEvent ae) ->
        {
            if (error)
            {
                error = false;
                displayTextArea.setText("");
                otherDisplay.setText("");
                reset();
            }
            try
            {
                counter++;
                if (counter > 1)
                {
                    getAnswer();
                    subtracting = true;
                    firstNum = false;
                    otherDisplay.append("  -  ");
                }
                else
                {
                    subtracting = true;
                    firstNum = false;
                    otherDisplay.append("  -  ");
                }
            }
            catch (Exception e)
            {
                error();
            }
        });
        buttonPnl.add(minus);

        one = new JButton("1");
        one.setBackground(numberColor);
        one.setBorder(border);
        one.setFont(buttonFont);
        one.setBackground(Color.LIGHT_GRAY);
        one.setForeground(textColor);
        one.addActionListener((ActionEvent ae) ->
        {
            setButtonNumber(1);
        });
        buttonPnl.add(one);

        two = new JButton("2");
        two.setBackground(numberColor);
        two.setBorder(border);
        two.setFont(buttonFont);
        two.setBackground(Color.LIGHT_GRAY);
        two.setForeground(textColor);
        two.addActionListener((ActionEvent ae) ->
        {
            setButtonNumber(2);
        });
        buttonPnl.add(two);

        three = new JButton("3");
        three.setBackground(numberColor);
        three.setBorder(border);
        three.setFont(buttonFont);
        three.setBackground(Color.LIGHT_GRAY);
        three.setForeground(textColor);
        three.addActionListener((ActionEvent ae) ->
        {
            setButtonNumber(3);
        });
        buttonPnl.add(three);

        plus = new JButton("+");
        plus.setBackground(operatorColor);
        plus.setBorder(border);
        plus.setFont(buttonFont);
        plus.setForeground(textColor);
        plus.addActionListener((ActionEvent ae) ->
        {
            if (error)
            {
                error = false;
                displayTextArea.setText("");
                otherDisplay.setText("");
                reset();
            }
            try
            {
                counter++;
                if (counter > 1)
                {
                    getAnswer();
                    adding = true;
                    firstNum = false;
                    otherDisplay.append("  +  ");
                }
                else
                {
                    adding = true;
                    firstNum = false;
                    otherDisplay.append("  +  ");
                }
            }
            catch (Exception e)
            {
                error();
            }
        });
        buttonPnl.add(plus);

        switchSigns = new JButton("-/+");
        switchSigns.setBackground(otherColor);
        switchSigns.setBorder(border);
        switchSigns.setFont(buttonFont);
        switchSigns.setForeground(textColor);
        switchSigns.addActionListener((ActionEvent ae) ->
        {
            if (error)
            {
                error = false;
                displayTextArea.setText("");
                otherDisplay.setText("");
                reset();
            }
            try
            {
                if (firstNum)
                {
                    if (!displayTextArea.getText().equals(""))
                    {
                        switchedNum = Double.parseDouble(displayTextArea.getText());
                        switchedNum = -switchedNum;
                        displayTextArea.setText(String.valueOf(switchedNum));
                    }
                }
                else
                {
                    if (!secondNum.equals(""))
                    {
                        switchedNum = Double.parseDouble(secondNum);
                        switchedNum = -switchedNum;
                        secondNum = String.valueOf(switchedNum);

                        String current9 = otherDisplay.getText();
                        current9 = current9.substring(0,current9.length() - secondNum.length());
                        otherDisplay.setText(current9);
                        otherDisplay.append(String.valueOf(switchedNum));
                    }
                }
            }
            catch (Exception e)
            {
                error();
            }
        });
        buttonPnl.add(switchSigns);

        zero = new JButton("0");
        zero.setBackground(numberColor);
        zero.setBorder(border);
        zero.setFont(buttonFont);
        zero.setBackground(Color.LIGHT_GRAY);
        zero.setForeground(textColor);
        zero.addActionListener((ActionEvent ae) ->
        {
            setButtonNumber(0);
        });
        buttonPnl.add(zero);

        decimal = new JButton(".");
        decimal.setBackground(otherColor);
        decimal.setBorder(border);
        decimal.setFont(buttonFont);
        decimal.setForeground(textColor);
        decimal.addActionListener((ActionEvent ae) ->
        {
            if (error)
            {
                error = false;
                displayTextArea.setText("");
                otherDisplay.setText("");
                reset();
            }
            try
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
            }
            catch (Exception e)
            {
                error();
            }
        });
        buttonPnl.add(decimal);

        equals = new JButton("=");
        equals.setBackground(equalsColor);
        equals.setBorder(border);
        equals.setFont(buttonFont);
        equals.setForeground(textColor);
        equals.addActionListener((ActionEvent ae) ->
        {
            if (error)
            {
                error = false;
                displayTextArea.setText("");
                otherDisplay.setText("");
                reset();
            }
            try
            {
                getAnswer();
            }
            catch (Exception e)
            {
                error();
            }
        });
        buttonPnl.add(equals);

        main.add(buttonPnl, BorderLayout.CENTER);
        setSize(325, 535);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(main);
    }

    public void getAnswer()
    {
        if (carroting)
        {
            if (!adding && !subtracting && !multiplying && !dividing)
            {
                finalNum = Double.parseDouble(displayTextArea.getText());
                finalNum = Math.pow(finalNum, Double.parseDouble(carrotted));
                displayTextArea.setText(String.valueOf(finalNum));
            }
            else
            {
                finalNum = Math.pow(Double.parseDouble(secondNum), Double.parseDouble(carrotted));
            }
        }
        if (adding)
        {
            if (carroting)
            {
                finalNum = finalNum + Double.parseDouble(displayTextArea.getText());
                displayTextArea.setText(String.valueOf(finalNum));
            }
            else
            {
                finalNum = Double.parseDouble(displayTextArea.getText()) + Double.parseDouble(secondNum);
                displayTextArea.setText(String.valueOf(finalNum));
            }
        }
        if (subtracting)
        {
            if (carroting)
            {
                finalNum = Double.parseDouble(displayTextArea.getText()) - finalNum;
                displayTextArea.setText(String.valueOf(finalNum));
            }
            else
            {
                finalNum = Double.parseDouble(displayTextArea.getText()) - Double.parseDouble(secondNum);
                displayTextArea.setText(String.valueOf(finalNum));
            }
        }
        if (multiplying)
        {
            if (carroting)
            {
                finalNum = finalNum * Double.parseDouble(displayTextArea.getText());
                displayTextArea.setText(String.valueOf(finalNum));
            }
            else
            {
                finalNum = Double.parseDouble(displayTextArea.getText()) * Double.parseDouble(secondNum);
                displayTextArea.setText(String.valueOf(finalNum));
            }
        }
        if (dividing)
        {
            if (carroting)
            {
                finalNum = Double.parseDouble(displayTextArea.getText()) / finalNum;
                displayTextArea.setText(String.valueOf(finalNum));
            }
            else
            {
                finalNum = Double.parseDouble(displayTextArea.getText()) / Double.parseDouble(secondNum);
                displayTextArea.setText(String.valueOf(finalNum));
            }
        }
        reset();
    }

    public static void setButtonNumber(int num)
    {
        if (error)
        {
            error = false;
            displayTextArea.setText("");
            otherDisplay.setText("");
            reset();
        }
        try
        {
            if (firstNum)
            {
                displayTextArea.append(String.valueOf(num));
            }
            else
            {
                if (carroting)
                {
                    otherDisplay.append(String.valueOf(num));
                    carrotted = carrotted + num;
                }
                else
                {
                    otherDisplay.append(String.valueOf(num));
                    secondNum = secondNum + num;
                }
            }
        }
        catch (Exception e)
        {
            error();
        }
    }

    public static void error()
    {
        error = true;
        otherDisplay.setText("");
        displayTextArea.setText("Error");
    }


    public static void reset()
    {
        adding = false;
        subtracting = false;
        multiplying = false;
        dividing = false;
        carroting = false;
        firstNum = true;

        secondNum = "";
        otherDisplay.setText("");

        squared = 0;
        squarerooted = 0;
        carrotted = "";
        secondNumLength = 0;
        switchedNum = 0;
    }
}
