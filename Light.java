package net.l8fish.circuits;

import java.util.ArrayList;

public class Light extends Output implements OutputAction {
    private int outputAction;
  
    public Light() {
	super();
	outputAction = 0;
    }
                
    public Light(ArrayList<Wire> input) {
	super(input);
	outputAction = 0;
    }
        
    public boolean isConnected() {
	if (getInput().size()==1) {return true;}
	else {return false;}
    }
        
    public int getOutputAction() {
	return outputAction;
    }
        
    public void performAction() {
	if (isConnected()&&isTurnedOn()) {     
	    if (getInput().get(0).getStatus()) {outputAction = 1;}
	    else {outputAction = 0;}                                     
	}
    } 
}