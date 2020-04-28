package it.polimi.ingsw.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberListener implements ActionListener {

    private Calculator calculator;
    public NumberListener(Calculator calculator){
        this.calculator = calculator;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String currentNumber = calculator.getCurrentNumber();
        JButton button = (JButton)e.getSource();

        if (currentNumber.equals("0")) {
            currentNumber = button.getText();
        } else{
            currentNumber += button.getText();
        }
        calculator.setCurrentNumber(currentNumber, true);
    }
}
