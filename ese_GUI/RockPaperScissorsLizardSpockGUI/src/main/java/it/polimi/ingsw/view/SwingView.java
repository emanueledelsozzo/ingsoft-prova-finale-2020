package it.polimi.ingsw.view;

import it.polimi.ingsw.model.ModelView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingView extends View {

    private JFrame frame;
    private JPanel mainPanel;
    private JPanel results;
    private JLabel resultLabel;
    private JButton button;
    private JLabel playerChoice = new JLabel();
    private JLabel cpuChoice = new JLabel();


    public SwingView(){
        frame = new JFrame("Rock Paper Scissors Lizard Spock");
        mainPanel = new JPanel(new BorderLayout(10, 10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        results = new JPanel();
        results.setLayout(new BorderLayout(10, 10));
        results.setBorder(new EmptyBorder(10, 10, 10, 10));
        results.add(buildDataLayout(), BorderLayout.PAGE_START);
        resultLabel = new JLabel();
        results.add(resultLabel, BorderLayout.PAGE_END);
        mainPanel.add(results, BorderLayout.PAGE_START);

        button = new JButton("New round!");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ChoiceDialog(frame, SwingView.this);
            }
        });
        mainPanel.add(button, BorderLayout.PAGE_END);

        frame.add(mainPanel);
        frame.pack();
    }

    private JPanel buildDataLayout(){
        JPanel result = new JPanel();
        result.setLayout(new GridLayout(2, 2, 10, 10));
        result.add(new JLabel("Your choice"));
        result.add(new JLabel("CPU choice"));
        result.add(playerChoice);
        result.add(cpuChoice);
        return result;
    }

    @Override
    public void run(){
        frame.setVisible(true);
    }


    @Override
    protected void showModel(ModelView model){
        playerChoice.setText(model.getModelPlayerChoice().toString());
        cpuChoice.setText(model.getModelCpuChoice().toString());
        resultLabel.setText(model.getModelOutcome().toString());
    }


}
