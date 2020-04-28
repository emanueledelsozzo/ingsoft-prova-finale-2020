package it.polimi.ingsw;

import it.polimi.ingsw.gui.Calculator;
import it.polimi.ingsw.mathEngine.MathEngine;

import javax.swing.*;

public class App 
{
    public static void main( String[] args ) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Calculator calculator = new Calculator();
                MathEngine mathEngine = new MathEngine();
                calculator.addObserver(mathEngine);
                mathEngine.addObserver(calculator);
                calculator.createAndStartGUI();
            }
        });
    }
}
