package it.polimi.ingsw;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class MainJFrame extends JFrame implements Observer {

    private static final long serialVersionUID = 1L;

    private static final int num_products = Product.Type.values().length;

    private ProductButton[] buttons = {
            new ProductButton(Product.Type.TOMATO, "Produce Tomato"),
            new ProductButton(Product.Type.BASIL, "Produce Basil"),
            new ProductButton(Product.Type.POTATO, "Produce Potato")
        };

    private JTextField[] textFields = new JTextField[num_products];

    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();

    public MainJFrame(Stand stand){
        stand.addObserver(this);
    }

    public void initGUI(ProducerListener listener){
        panel1.add(new JLabel("Producer interface, press buttons to add products!"));
        panel2.setLayout(new GridLayout(2, 3));

        for(int i = 0; i < num_products; i++){
            panel2.add(buttons[i]);
        }

        for(int i = 0; i < num_products; i++){
            textFields[i] = new JTextField();
            panel2.add(textFields[i]);
            textFields[i].setEditable(false);
            textFields[i].setHorizontalAlignment(SwingConstants.CENTER);
            buttons[i].addActionListener(listener);
        }

        updateGUI(0, 0, 0);

        setLayout(new BorderLayout());
        add(panel1, BorderLayout.PAGE_START);
        add(panel2, BorderLayout.PAGE_END);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pack();

        setVisible(true);
    }

    public void updateGUI(int nTom, int nBas, int nPot){
        textFields[0].setText("There are " + nTom + " tomatoes!");
        textFields[1].setText("There are " + nBas + " leaves of basil!");
        textFields[2].setText("There are " + nPot + " potatoes!");
    }


    @Override
    public void update(Observable o, Object arg) {

        if(!(o instanceof Stand)){
            throw new IllegalArgumentException();
        }

        Stand stand = (Stand) o;
        updateGUI(stand.getNumber(Product.Type.TOMATO),
                stand.getNumber(Product.Type.BASIL),
                stand.getNumber(Product.Type.POTATO));

    }
}
