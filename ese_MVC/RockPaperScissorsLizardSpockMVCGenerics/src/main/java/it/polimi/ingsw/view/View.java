package it.polimi.ingsw.view;

import it.polimi.ingsw.model.Choice;
import it.polimi.ingsw.model.Model;

import java.io.PrintStream;
import java.util.Scanner;

public class View extends Observable<Choice> implements Runnable, Observer<Model> {

    private Scanner scanner;
    private PrintStream outputStream;

    public View(){
        scanner = new Scanner(System.in);
        outputStream = new PrintStream(System.out);
    }

    private void showModel(Model modelView){

        outputStream.println("You chose " + modelView.getPlayerChoice().toString());
        outputStream.println("CPU chose " + modelView.getCpuChoice().toString());
        modelView.getOutcome().printOutcome();

    }

    @Override
    public void update(Model message) {
        showModel(message);
    }

    @Override
    public void run() {

        while(true){
            outputStream.println("Make your choice:");
            String currChoice = scanner.next();
            try{
                Choice player = Choice.parseInput(currChoice);
                notify(player);
            }catch(IllegalArgumentException e){
                outputStream.println("Input error!");
            }
        }
    }
}
