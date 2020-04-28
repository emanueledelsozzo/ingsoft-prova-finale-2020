package it.polimi.ingsw.gui;

import it.polimi.ingsw.mathEngine.MathEngine;
import it.polimi.ingsw.mathEngine.MathEngineMessage;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Calculator extends Observable implements Observer {

    private JFrame frame = new JFrame("Calculator");
    private JTextField textField = new JTextField();
    private JPanel panel = new JPanel();
    private String currentNumber = "0";

    JButton createNumberButton(int number){
        final JButton button = new JButton(String.valueOf(number));
        button.addActionListener(new NumberListener(this));
        return button;
    }

    JButton createDecimalButton(){
        final JButton button = new JButton(".");
        button.addActionListener(new DecimalListener(this));
        return button;
    }

    JButton createOperationButton(String op){
        final JButton button = new JButton(op);
        switch(op){
            case "AC":
                button.addActionListener(new ClearListener(this));
                break;
            case "+/-":
                button.addActionListener(new PlusMinusListener(this));
                break;
            case "=":
                button.addActionListener(new ResultListener(this));
                break;
            default:
                button.addActionListener(new MathOpListener(this));
                break;

        }
        return button;
    }

    private String floatToString(float operand) {

        if((int) operand == operand){
            return String.valueOf((int)operand);
        }else{
            return String.valueOf(operand);
        }

    }

    void createCalculator(JPanel p){
        p.add(createOperationButton("AC"));
        p.add(createOperationButton("+/-"));
        p.add(createOperationButton("%"));
        p.add(createOperationButton("/"));

        p.add(createNumberButton(7));
        p.add(createNumberButton(8));
        p.add(createNumberButton(9));
        p.add(createOperationButton("x"));

        p.add(createNumberButton(4));
        p.add(createNumberButton(5));
        p.add(createNumberButton(6));
        p.add(createOperationButton("-"));

        p.add(createNumberButton(1));
        p.add(createNumberButton(2));
        p.add(createNumberButton(3));
        p.add(createOperationButton("+"));

        p.add(new JButton(""));
        p.add(createNumberButton(0));
        p.add(createDecimalButton());
        p.add(createOperationButton("="));

    }

    public void createAndStartGUI(){

        textField.setEditable(false);
        textField.setText(currentNumber);
        textField.setHorizontalAlignment(JTextField.CENTER);
        frame.setLayout(new BorderLayout());
        panel.setLayout(new GridLayout(5, 4));
        createCalculator(panel);
        frame.add(textField, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public String getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(String currentNumber, boolean setTop) {
        this.currentNumber = currentNumber;
        if(setTop){
            textField.setText(this.currentNumber);
        }
    }

    public void sendNotification(GUIMessage message) {
        setChanged();
        notifyObservers(message);
    }


    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof MathEngine && arg instanceof MathEngineMessage){
            MathEngineMessage m = (MathEngineMessage)arg;
            switch (m.getMessageType()){
                case RESULT:
                    textField.setText(floatToString(m.getValue()));
                    break;
                case SWITCHED_SIGN:
                    currentNumber = floatToString(m.getValue());
                    textField.setText(floatToString(m.getValue()));
                    break;
                default:
                    break;
            }

        }
    }


}
