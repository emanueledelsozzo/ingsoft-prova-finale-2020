package it.polimi.ingsw.gui;


public class GUIMessage {

    private float value;
    private String op;
    private GUIMessageType messageType;

    public GUIMessage(GUIMessageType messageType, float value){
        assert(messageType == GUIMessageType.OPERAND || messageType == GUIMessageType.SWITCH_SIGN);
        this.messageType = messageType;
        this.value = value;
    }

    public GUIMessage(GUIMessageType messageType, String op){
        assert(messageType == GUIMessageType.OPERATOR);
        this.messageType = messageType;
        this.op = op;
    }

    public GUIMessage(GUIMessageType messageType, float value, String op){
        assert(messageType == GUIMessageType.OPERAND_AND_OPERATOR);
        this.messageType = messageType;
        this.op = op;
        this.value = value;
    }

    public GUIMessage(GUIMessageType messageType){
        assert(messageType == GUIMessageType.CLEAN || messageType == GUIMessageType.SWITCH_SIGN_OPERAND);
        this.messageType = messageType;
    }


    public float getValue() {
        return value;
    }

    public String getOp() {
        return op;
    }

    public GUIMessageType getMessageType() {
        return messageType;
    }
}
