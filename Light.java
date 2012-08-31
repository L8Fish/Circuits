package net.l8fish.circuits;

public class Light extends Output implements OutputAction {
    private int outputAction;
  
    public Light() {
	    super(1);
        outputAction = 0;
    }
                
    public Light(Wire[] input) {
	    super(input);
	    outputAction = 0;
    }
        
    public boolean isConnected() {
        return getInput().length == 1;
    }
        
    public int getOutputAction() {
	    return outputAction;
    }
        
    public void performAction() {
	    if (isConnected()&&isTurnedOn()) {
	        if (getInput()[0].getStatus()) {outputAction = 1;}
	        else {outputAction = 0;}
	    }
    }

    public Element newInstance() {
        return new Light();
    }
}