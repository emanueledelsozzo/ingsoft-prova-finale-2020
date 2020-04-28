package it.polimi.ingsw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import it.polimi.ingsw.Product.Type;

public class ProducerListener implements ActionListener {

    private Stand stand;

    public ProducerListener(Stand stand){
        this.stand = stand;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Type type = ((ProductButton)e.getSource()).getType();
        stand.addProduct(new Product(type));
    }
}
