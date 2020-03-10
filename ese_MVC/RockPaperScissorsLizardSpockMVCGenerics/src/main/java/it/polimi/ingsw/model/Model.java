package it.polimi.ingsw.model;

import it.polimi.ingsw.view.Observable;

public class Model extends Observable<Model> implements Cloneable{

    private Choice player;
    private Choice cpu;
    private Outcome out;

    @Override
    public Model clone() {
        Model model = new Model();
        model.player = player;
        model.cpu = cpu;
        model.out = out;
        return model;
    }

    public Choice getPlayerChoice() {
        return player;
    }

    public void setPlayerChoice(Choice player) {
        this.player = player;
    }

    public Choice getCpuChoice() {
        return cpu;
    }

    public void setCpuChoice(Choice cpu) {
        this.cpu = cpu;
    }

    public Outcome getOutcome() {
        return out;
    }

    public void setOutcome(Outcome out) {
        this.out = out;
        notify(this.clone());
    }



}
