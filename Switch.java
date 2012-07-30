package net.l8fish.circuits;

import java.util.ArrayList;

public class Switch extends Logic implements InputAction {
    private int inputAction;
  
    public Switch() {
	super();
	inputAction = 0;
    }
                
    public Switch(ArrayList<Wire> input, ArrayList<Wire> output) {
	super(input, output);
	inputAction = 0;
    }
        
    public boolean isConnected() {
	if (getInput().size()==1 && getOutput().size()==1) {return true;}
	else {return false;}
    }
        
    public void setInputAction(int action) {
	this.inputAction = action;
	performAction();
    }
        
    public int getInputAction() {
	return inputAction;
    }
        
    public void performAction() {
	if (isConnected()) {                    
	    boolean first = getOutput().get(0).getStatus(); 
	    if (this.isTurnedOn() && inputAction==1) {
		if (getInput().get(0).getStatus()) {getOutput().get(0).setStatus(true);}
		else {getOutput().get(0).setStatus(false);}
	    }
	    else {
		getOutput().get(0).setStatus(false);
	    }
	    boolean second = getOutput().get(0).getStatus();
	    if (first!=second && getCircuit()!=null) {
		getCircuit().stack.add(getOutput().get(0).getOutput());
	    }
	}
    } 
}