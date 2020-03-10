package it.polimi.ingsw;

import java.util.Scanner;

public class Game {

    private Choice player;

    public void start(){

        while(true){

            getPlayerChoice();
            System.out.println("You chose " + player.toString());
            Choice cpu = Choice.getRandomChoice();
            System.out.println("CPU chose " + cpu.toString());
            Outcome out = player.compareChoices(cpu);
            out.printOutcome();

        }

    }

    private void getPlayerChoice() {

        Scanner s = new Scanner(System.in);
        System.out.println("Make your choice:");

        while(true){
            String currChoice = s.next();
            try{
                player = Choice.parseInput(currChoice);
                break;
            } catch(IllegalArgumentException e){
                System.out.println("Input error!");
            }
        }

    }

}
