package it.polimi.ingsw.model;

import it.polimi.ingsw.view.Observable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Model extends Observable<Model> implements Cloneable{

    private Map<Player, Choice> choices = new HashMap<>();
    private Map<Player, Outcome> outcomes = new HashMap<>();

    public Choice getPlayerChoice(Player player) {
        return choices.get(player);
    }

    public Outcome getOutcome(Player player) {
        return outcomes.get(player);
    }

    public void setPlayerChoice(Player player, Choice playerChoice){
        if(choices.size() == 2){
            choices.clear();
            outcomes.clear();
        }
        if(!choices.containsKey(player)){
            if(choices.size() == 1){
                Player other = new LinkedList<Player>(choices.keySet()).get(0);
                outcomes.put(player, playerChoice.compareChoices(choices.get(other)));
                outcomes.put(other, choices.get(other).compareChoices(playerChoice));
            }
            choices.put(player, playerChoice);
        }
        if(choices.size() == 2){
            notify(this);
        }
    }

}
