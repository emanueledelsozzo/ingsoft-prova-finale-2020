package it.polimi.ingsw;

import it.polimi.ingsw.controller.Controller;
import it.polimi.ingsw.model.Model;
import it.polimi.ingsw.model.ModelView;
import it.polimi.ingsw.view.SwingView;
import it.polimi.ingsw.view.View;

/**
 * Hello world!
 *
 */
public class App 
{

    private Model model;
    private ModelView modelView;
    private View view;
    private Controller controller;

    public App(){
        model = new Model();
        modelView = new ModelView();

        view = new SwingView();

        controller = new Controller(model, view);
        view.addObserver(controller);
        model.addObserver(modelView);
        modelView.addObserver(view);
    }

    public static void main( String[] args )
    {
        App app = new App();
        app.run();
    }

    private void run(){
        view.run();
    }

}
