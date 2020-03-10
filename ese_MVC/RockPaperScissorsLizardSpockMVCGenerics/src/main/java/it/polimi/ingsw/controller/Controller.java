package it.polimi.ingsw.controller;

import it.polimi.ingsw.model.Choice;
import it.polimi.ingsw.model.Model;
import it.polimi.ingsw.model.Outcome;
import it.polimi.ingsw.view.Observer;
import it.polimi.ingsw.view.View;

public class Controller implements Observer<Choice> {

    private Model model;
    private View view;

    public Controller(Model model, View view){

        this.model = model;
        this.view = view;

    }

    private void game(){
        Choice cpuChoice = Choice.getRandomChoice();
        model.setCpuChoice(cpuChoice);
        Outcome out = model.getPlayerChoice().compareChoices(cpuChoice);
        model.setOutcome(out);
    }

    @Override
    public void update(Choice playerChoice) {
        model.setPlayerChoice(playerChoice);
        game();
    }
}
