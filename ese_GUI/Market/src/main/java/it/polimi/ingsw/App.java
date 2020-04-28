package it.polimi.ingsw;

import javax.swing.*;

/**
 * Hello world!
 *
 */
public class App 
{

    private Stand stand;
    private MainJFrame gui;
    private ProducerListener listener;

    public App(){

        stand = new Stand();
        gui = new MainJFrame(stand);

        listener = new ProducerListener(stand);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                gui.initGUI(listener);
            }
        });

        Client client = new Client();
        while(true){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            client.buy(stand);
        }

    }

    public static void main( String[] args )
    {
        new App();
    }
}
