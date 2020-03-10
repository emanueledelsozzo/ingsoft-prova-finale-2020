package it.polimi.ingsw.view;

import it.polimi.ingsw.model.Choice;
import it.polimi.ingsw.model.ModelView;

import java.io.PrintStream;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class View extends Observable implements Observer, Runnable {

    private Scanner scanner;
    private PrintStream outputStream;

    public View(){
        scanner = new Scanner(System.in);
        outputStream = new PrintStream(System.out);
    }

    private void showModel(ModelView modelView){

        outputStream.println("You chose " + modelView.getModelPlayerChoice().toString());
        outputStream.println("CPU chose " + modelView.getModelCpuChoice().toString());
        modelView.getModelOutcome().printOutcome();

    }


    @Override
    public void run() {

        while(true){
            outputStream.println("Make your choice:");
            String currChoice = scanner.next();
            try{
                Choice player = Choice.parseInput(currChoice);
                setChanged();
                notifyObservers(player);
            }catch(IllegalArgumentException e){
                outputStream.println("Input error!");
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if(!(o instanceof ModelView)){
            throw new IllegalArgumentException();
        }
        showModel((ModelView)o);
    }
}
