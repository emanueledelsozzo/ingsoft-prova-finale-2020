package it.polimi.ingsw.controller;

import it.polimi.ingsw.model.Choice;
import it.polimi.ingsw.model.Model;
import it.polimi.ingsw.model.Outcome;
import it.polimi.ingsw.view.View;

import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {

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
    public void update(Observable o, Object arg) {
        if(o != view || !(arg instanceof Choice)){
            throw new IllegalArgumentException();
        }
        model.setPlayerChoice((Choice)arg);
        game();
    }
}
