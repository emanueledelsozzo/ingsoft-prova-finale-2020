package it.polimi.ingsw.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultListener implements ActionListener {

    private Calculator calculator;

    public ResultListener(Calculator calculator){
        this.calculator = calculator;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String currentNumber = calculator.getCurrentNumber();
        if(!currentNumber.isEmpty()){
            calculator.setCurrentNumber("", false);
            calculator.sendNotification(new GUIMessage(GUIMessageType.OPERAND, Float.parseFloat(currentNumber)));
        }

    }
}
