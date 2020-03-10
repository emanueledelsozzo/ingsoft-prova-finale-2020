package it.polimi.ingsw.model;

import java.util.Random;

public enum Choice {

    ROCK, PAPER, SCISSORS, LIZARD, SPOCK;

    // Scissors cuts Paper
    // Paper covers Rock
    // Rock crushes Lizard
    // Lizard poisons Spock
    // Spock smashes Scissors
    // Scissors decapitates Lizard
    // Lizard eats Paper
    // Paper disproves Spock
    // Spock vaporizes Rock
    // (and as it always has) Rock crushes Scissors

    public static Choice parseInput(String input){
        return Enum.valueOf(Choice.class, input.toUpperCase());
    }

    public static Choice getRandomChoice(){
        Choice[] values = Choice.values();
        Random r = new Random();
        return values[r.nextInt(values.length)];
    }

    public Outcome compareChoices(Choice other){

        if(this == other){
            return Outcome.DRAW;
        }

        switch(this){
            case ROCK:
                return Outcome.winsIfTrue(other == Choice.LIZARD || other == Choice.SCISSORS);
            case PAPER:
                return Outcome.winsIfTrue(other == Choice.ROCK || other == Choice.SPOCK);
            case SCISSORS:
                return Outcome.winsIfTrue(other == Choice.PAPER || other == Choice.LIZARD);
            case LIZARD:
                return Outcome.winsIfTrue(other == Choice.SPOCK || other == Choice.PAPER);
            case SPOCK:
                return Outcome.winsIfTrue(other == Choice.SCISSORS || other == Choice.ROCK);
            default:
                throw new RuntimeException("Unxpected case!");
        }
    }

}
