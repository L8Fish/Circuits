package net.l8fish.circuits;

public class NotGate extends Logic {
	
    public NotGate() {
	    super(1, 1);
    }
	
    public NotGate(Wire[] input, Wire[] output) {
	    super(input, output);
    }
	
    public boolean isConnected() {
        return this.getInput().length == 1 && this.getOutput().length == 1;
    }
	
    public void performAction() {
	    if (isConnected()) {
	        boolean first = getOutput()[0].getStatus();
	        if (this.isTurnedOn()) {
		        getOutput()[0].setStatus(!getInput()[0].getStatus());
	        }
	        else {
		        getOutput()[0].setStatus(false);
	        }
	        boolean second = getOutput()[0].getStatus();
	        if (first!=second && getCircuit()!=null) {
		        getCircuit().stack.add(getOutput()[0].getOutput());
	        }
	    }
    }

    public Element newInstance() {
        return new NotGate();
    }
}