package it.polimi.ingsw.controller;

import it.polimi.ingsw.model.Model;
import it.polimi.ingsw.model.PlayerChoice;
import it.polimi.ingsw.view.Observer;

public class Controller implements Observer<PlayerChoice> {

    private Model model;

    public Controller(Model model){

        this.model = model;

    }

    @Override
    public void update(PlayerChoice playerChoice) {
        model.setPlayerChoice(playerChoice.getPlayer(), playerChoice.getChoice());
    }
}
