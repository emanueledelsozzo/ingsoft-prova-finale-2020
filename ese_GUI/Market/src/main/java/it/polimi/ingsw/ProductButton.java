package it.polimi.ingsw;

import javax.swing.*;
import it.polimi.ingsw.Product.Type;

public class ProductButton extends JButton {

    private static final long serialVersionUID = 1L;
    private Type type;

    public ProductButton(Type type, String text){
        super(text);
        this.type = type;
    }

    public Type getType(){
        return type;
    }


}
