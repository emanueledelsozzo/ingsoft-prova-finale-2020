package it.polimi.ingsw.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MathOpListener implements ActionListener {

    private Calculator calculator;

    public MathOpListener(Calculator calculator){
        this.calculator = calculator;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String currentNumber = calculator.getCurrentNumber();
        GUIMessage message;
        JButton button = (JButton)e.getSource();
        if(!currentNumber.isEmpty()) {
            message = new GUIMessage(GUIMessageType.OPERAND_AND_OPERATOR, Float.parseFloat(currentNumber), button.getText());
            calculator.setCurrentNumber("", false);
        } else {
            message = new GUIMessage(GUIMessageType.OPERATOR, button.getText());
        }
        calculator.sendNotification(message);
    }
}
