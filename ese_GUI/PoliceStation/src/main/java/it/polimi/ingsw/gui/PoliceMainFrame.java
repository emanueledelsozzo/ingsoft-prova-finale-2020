package it.polimi.ingsw.gui;

import javax.swing.*;
import java.awt.*;

public class PoliceMainFrame extends JFrame {

    class MyButton extends JButton {

        private static final long serialVersionUID = 1L;
        private int area;

        public MyButton(int area){
            super(String.valueOf(area));
            this.area = area;
        }

        public int getArea(){
            return area;
        }

    }

    private static final long serialVersionUID = 1L;

    private MyButton[] buttons = new MyButton[6];
    private JPanel[] panels = new JPanel[3];
    private JTextArea textArea = new JTextArea();

    public void initGUI(AlarmHandler h){

        for(int i = 0; i < 3; i++){
            panels[i] = new JPanel();
        }

        panels[0].add(new JLabel("Select an area:"));
        panels[1].setLayout(new GridLayout(3, 3));

        for(int i = 0; i < 6; i++){
            buttons[i] = new MyButton(i);
            panels[1].add(buttons[i]);
            buttons[i].addActionListener(h);
        }

        panels[2].setLayout(new BorderLayout());
        panels[2].add(textArea);

        setLayout(new BorderLayout());
        add(panels[0], BorderLayout.PAGE_START);
        add(panels[1], BorderLayout.CENTER);
        add(panels[2], BorderLayout.PAGE_END);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void setText(String res){
        textArea.setText(res);
    }

}
