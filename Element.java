package net.l8fish.circuits;

public abstract class Element implements Component {
    private boolean power;
    private Circuit circuit;
	
    public Element() {
	    power = false;
	    circuit = null;
    }
	
    public void setCircuit(Circuit circuit) {
	    this.circuit = circuit;
    }
	
    public Circuit getCircuit() {
	    return circuit;
    }
	
    public boolean isTurnedOn() {
	    return power;
    }
	
    public void turnOn(boolean signal) {
	    power = signal;
	    performAction();
    }	
	
    abstract void performAction();
}