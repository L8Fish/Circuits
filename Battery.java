package net.l8fish.circuits;

public class Battery extends Input {
    public Battery() {
	    super(1);
    }

    public Battery(Wire[] output) {
	    super(output);
    }
	
    public boolean isConnected() {
        return getOutput().length == 1;
    }
	
    public void performAction() {
	    if (isConnected()) {
	        boolean first = getOutput()[0].getStatus();
	        if (this.isTurnedOn()) {
		        getOutput()[0].setStatus(true);
	        }
	        else {
		        getOutput()[0].setStatus(false);
	        }
            boolean second = getOutput()[0].getStatus();
            if (first!=second&&getCircuit()!=null) {
        	    getCircuit().stack.add(getOutput()[0].getOutput());
            }
	    }
    }

    public Element newInstance() {
        return new Battery();
    }
}