package it.polimi.ingsw.model;

public class PlayerChoice {

    private final Player player;
    private final Choice choice;

    public PlayerChoice(Player player, Choice choice){
        this.player = player;
        this.choice = choice;
    }

    public Player getPlayer(){
        return this.player;
    }

    public Choice getChoice(){
        return this.choice;
    }

}
