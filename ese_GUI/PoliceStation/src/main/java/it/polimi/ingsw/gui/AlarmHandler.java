package it.polimi.ingsw.gui;

import it.polimi.ingsw.NoPoliceCarException;
import it.polimi.ingsw.PoliceCarManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlarmHandler implements ActionListener {

    private PoliceCarManager pcm;
    private PoliceMainFrame frame;

    public AlarmHandler(PoliceCarManager pcm, PoliceMainFrame frame){
        this.pcm = pcm;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        PoliceMainFrame.MyButton button = (PoliceMainFrame.MyButton)event.getSource();
        try {
            String res = pcm.notifyPoliceCars(button.getArea());
            frame.setText(res);
        } catch (NoPoliceCarException e){
            JOptionPane.showMessageDialog(null, "No police car in that area!",
                    "Warning!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
