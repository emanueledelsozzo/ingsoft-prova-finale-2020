package it.polimi.ingsw;

public enum Outcome {

    WIN, LOSE, DRAW;

    public static Outcome winsIfTrue(boolean condition){

        return condition ? Outcome.WIN : Outcome.LOSE;

    }

    public void printOutcome(){
        switch (this){
            case WIN:
                System.out.println("You win!");
                break;
            case LOSE:
                System.out.println("You lose!");
                break;
            case DRAW:
                System.out.println("Draw!");
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

}
