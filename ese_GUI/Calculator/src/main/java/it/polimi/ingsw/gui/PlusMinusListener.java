package it.polimi.ingsw.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlusMinusListener implements ActionListener {

    private Calculator calculator;

    public PlusMinusListener(Calculator calculator){
        this.calculator = calculator;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        GUIMessage message;
        String currentNumber = calculator.getCurrentNumber();
        if(!currentNumber.isEmpty()){
            message = new GUIMessage(GUIMessageType.SWITCH_SIGN, Float.parseFloat(currentNumber));
        } else {
            message = new GUIMessage(GUIMessageType.SWITCH_SIGN_OPERAND);
        }
        calculator.sendNotification(message);

    }
}
