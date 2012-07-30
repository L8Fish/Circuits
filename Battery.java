package net.l8fish.circuits;
	
import java.util.ArrayList;

public class Battery extends Input {
    public Battery() {
	super();
    }
		
    public Battery(ArrayList<Wire> output) {
	super(output);
    }
	
    public boolean isConnected() {
	if (getOutput().size()==1) {return true;}
	else {return false;}
    }
	
    public void performAction() {
	if (isConnected()) {			
	    boolean first = getOutput().get(0).getStatus(); 
	    if (this.isTurnedOn()) {
		getOutput().get(0).setStatus(true);
	    }
	    else {
		getOutput().get(0).setStatus(false);
	    }
            boolean second = getOutput().get(0).getStatus();
            if (first!=second&&getCircuit()!=null) {
        	getCircuit().stack.add(getOutput().get(0).getOutput());
            }
	}
    } 
}