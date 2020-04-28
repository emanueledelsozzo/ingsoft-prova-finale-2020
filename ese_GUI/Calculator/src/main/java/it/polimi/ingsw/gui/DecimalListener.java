package it.polimi.ingsw.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DecimalListener implements ActionListener {

    private Calculator calculator;
    public DecimalListener(Calculator calculator){
        this.calculator = calculator;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String currentNumber = calculator.getCurrentNumber();
        if(currentNumber.isEmpty()){
            currentNumber = "0.";
        } else if(!currentNumber.contains(".")){
            currentNumber += ".";
        }
        calculator.setCurrentNumber(currentNumber, true);
    }
}
