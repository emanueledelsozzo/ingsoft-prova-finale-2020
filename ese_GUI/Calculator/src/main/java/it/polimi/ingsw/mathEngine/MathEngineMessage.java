package it.polimi.ingsw.mathEngine;

public class MathEngineMessage {

    private float value;
    private MathEngineMessageType messageType;

    public MathEngineMessage(MathEngineMessageType messageType, float value){
        this.value = value;
        this.messageType = messageType;
    }


    public float getValue() {
        return value;
    }

    public MathEngineMessageType getMessageType() {
        return messageType;
    }
}
