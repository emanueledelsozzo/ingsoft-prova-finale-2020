package it.polimi.ingsw.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearListener implements ActionListener {

    private Calculator calculator;

    public ClearListener(Calculator calculator){
        this.calculator = calculator;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        GUIMessage message = new GUIMessage(GUIMessageType.CLEAN);
        calculator.sendNotification(message);
        calculator.setCurrentNumber("0", true);

    }

}
