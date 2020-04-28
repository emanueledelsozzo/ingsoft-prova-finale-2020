package it.polimi.ingsw.mathEngine;

import it.polimi.ingsw.gui.GUIMessage;

import java.util.Observable;
import java.util.Observer;

public class MathEngine extends Observable implements Observer {

    private float operand;
    private String op;
    private boolean operandReady;

    public MathEngine(){
        operand = 0.0f;
        operandReady = false;
        op = "";
    }

    private void clean(){
        operand = 0.0f;
        operandReady = false;
        op = "";
    }

    private void doOp(float v){
        switch(op){
            case "+":   operand += v;
                        break;
            case "-":   operand -= v;
                        break;
            case "x":   operand *= v;
                        break;
            case "/":   operand /= v;
                        break;
            default:    operand = v;
                        break;
        }
    }

    private void setOperand(float v) {
        if(operandReady){
            doOp(v);
            op = "";
        } else {
            operand = v;
            operandReady = true;
        }
        setChanged();
        notifyObservers(new MathEngineMessage(MathEngineMessageType.RESULT, operand));
    }


    private void switchOpeandSign(){
        operand = -operand;
    }


    private void setOp(String op) {
        this.op = op;
        if(this.op.equals("%")){
            operand /= 100.0f;
            setChanged();
            notifyObservers(new MathEngineMessage(MathEngineMessageType.RESULT, operand));
        }
    }


    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof GUIMessage) {
            GUIMessage c = (GUIMessage) arg;
            switch (c.getMessageType()) {
                case CLEAN:
                    clean();
                    break;
                case OPERAND:
                    setOperand(c.getValue());
                    break;
                case OPERATOR:
                    setOp(c.getOp());
                    break;
                case OPERAND_AND_OPERATOR:
                    setOperand(c.getValue());
                    setOp(c.getOp());
                    break;
                case SWITCH_SIGN:
                    setChanged();
                    notifyObservers(new MathEngineMessage(MathEngineMessageType.SWITCHED_SIGN, -c.getValue()));
                    break;
                case SWITCH_SIGN_OPERAND:
                    setChanged();
                    switchOpeandSign();
                    notifyObservers(new MathEngineMessage(MathEngineMessageType.SWITCHED_SIGN, operand));
                    break;
                default:
                    break;
            }
        }
    }

}
