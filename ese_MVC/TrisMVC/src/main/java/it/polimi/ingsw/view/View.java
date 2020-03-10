package it.polimi.ingsw.view;

import it.polimi.ingsw.model.Board;
import it.polimi.ingsw.model.Cell;
import it.polimi.ingsw.model.Model;
import it.polimi.ingsw.model.Move;

import java.io.PrintStream;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class View extends Observable implements Runnable, Observer {

    private Scanner scanner;
    private PrintStream outputStream;
    private boolean done = false;

    public View(){
        scanner = new Scanner(System.in);
        outputStream = new PrintStream(System.out);
    }

    public void playerMove(){

        while (true) {
            outputStream.println("Where do you want to place your marker? (example: x,y)");
            String s = scanner.next();
            try {
                String[] inputs = s.split(",");
                handleMove(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
                break;
            }catch(NumberFormatException e){
                outputStream.println("Please provide integer values as coordinates");
            }
        }

    }

    private void handleMove(int row, int col) {
        setChanged();
        notifyObservers(new Move(row, col));
    }

    @Override
    public void update(Observable o, Object arg) {
        if(!(o instanceof Model) || !(arg instanceof Board)){
            throw new IllegalArgumentException();
        }
        showBoard((Board)arg);
    }

    private void showBoard(Board board) {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                outputStream.print(board.getCell(i, j).toString() + " ");
            }
            outputStream.println();
        }
        outputStream.println();
    }

    public void declareWinner(Cell turn) {
        outputStream.println("The winner is " + turn.toString());
        done = true;
    }

    @Override
    public void run() {
        while(!done){
            playerMove();
        }
    }

    public void declareDraw() {
        outputStream.println("Draw!");
        done = true;
    }
}
