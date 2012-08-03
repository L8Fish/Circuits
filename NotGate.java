package net.l8fish.circuits;

import java.util.ArrayList;

public class NotGate extends Logic {
	
    public NotGate() {
	    super();
    }
	
    public NotGate(ArrayList<Wire> input, ArrayList<Wire> output) {
	    super(input, output);
    }
	
    public boolean isConnected() {
	    if (this.getInput().size()==1 && this.getOutput().size()==1) {return true;}
	    else {return false;}
    }
	
    public void performAction() {
	    if (isConnected()) {
	        boolean first = getOutput().get(0).getStatus();
	        if (this.isTurnedOn()) {
		        getOutput().get(0).setStatus(!getInput().get(0).getStatus());
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