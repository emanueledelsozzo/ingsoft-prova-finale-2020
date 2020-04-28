package it.polimi.ingsw.view;

import it.polimi.ingsw.model.Choice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoiceDialog extends JDialog {

    private static final long serialVersionUID = 1L;

    private JPanel mainPanel;
    private JComboBox<Choice> choices;
    private JButton confirmButton;

    private View view;

    private class ConfirmListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            view.processChoice((Choice) choices.getSelectedItem());
            ChoiceDialog.this.dispose();
        }
    }

    public ChoiceDialog(JFrame frame, View view){
        super(frame, "Player choice");

        this.view = view;

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        choices = new JComboBox<Choice>(Choice.values());

        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(new ConfirmListener());
        mainPanel.add(choices, BorderLayout.PAGE_START);
        mainPanel.add(confirmButton, BorderLayout.PAGE_END);
        add(mainPanel);
        pack();
        setMinimumSize(new Dimension(300, 30));
        setVisible(true);

    }

}
