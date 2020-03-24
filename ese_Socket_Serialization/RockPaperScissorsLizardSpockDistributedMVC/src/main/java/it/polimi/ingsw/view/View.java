package it.polimi.ingsw.view;

import it.polimi.ingsw.model.Choice;
import it.polimi.ingsw.model.Model;
import it.polimi.ingsw.model.Player;
import it.polimi.ingsw.model.PlayerChoice;

public abstract class View extends Observable<PlayerChoice> implements Observer<Model> {

    private Player player;

    protected View(Player player){
        this.player = player;
    }

    protected Player getPlayer(){
        return player;
    }

    protected void processChoice(Choice choice){
        notify(new PlayerChoice(player, choice));
    }

    protected abstract void showModel(Model model);


    @Override
    public void update(Model message) {
        showModel(message);
    }
}
