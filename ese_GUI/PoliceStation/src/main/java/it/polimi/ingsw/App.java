package it.polimi.ingsw;

import it.polimi.ingsw.gui.AlarmHandler;
import it.polimi.ingsw.gui.PoliceMainFrame;

import javax.swing.*;
import java.util.Random;


public class App 
{
    public static void main( String[] args )
    {

        PoliceCarManager pcm = new PoliceCarManager();
        Random random = new Random();
        random.ints(0,6)
                .distinct()
                .limit(random.nextInt(6))
                .forEach(i -> pcm.addPoliceCar(new PoliceCar(i)));

        System.out.println(pcm.toString());

        PoliceMainFrame pf = new PoliceMainFrame();
        AlarmHandler h = new AlarmHandler(pcm, pf);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                pf.initGUI(h);
            }
        });

    }
}
