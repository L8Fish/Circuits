package net.l8fish.circuits;

public class Switch extends Logic implements InputAction {
    private int inputAction;
  
    public Switch() {
	    super(1, 1);
        inputAction = 0;
    }
                
    public Switch(Wire[] input, Wire[] output) {
	    super(input, output);
	    inputAction = 0;
    }
        
    public boolean isConnected() {
        return getInput().length == 1 && getOutput().length == 1;
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
	        boolean first = getOutput()[0].getStatus();
	        if (this.isTurnedOn() && inputAction==1) {
		        if (getInput()[0].getStatus()) {getOutput()[0].setStatus(true);}
		        else {getOutput()[0].setStatus(false);}
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
        return new Switch();
    }
}