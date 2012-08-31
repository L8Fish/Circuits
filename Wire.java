package net.l8fish.circuits;

public class Wire implements Component {
    private boolean status;
    public static int numberOfWires = 0;
    private int id;
    private Element input;
    private Element output;	
	
    public Wire() {
	    status = false;
	    id = ++numberOfWires;
    }
	
    public int getId() {		
	    return id;
    }
	
    public boolean isConnected() {
        return input != null && output != null;
    }
	
    public void setStatus(boolean status) {
	    this.status = status;
    }
	
    public boolean getStatus() {
	    return status;
    }
	
    public void setInput(Element input) {
	    this.input = input;
    }
	
    public Element getInput() {
	    return input;
    }
	
    public void setOutput(Element output) {
	    this.output = output;
    }
	
    public Element getOutput() {
	    return output;
    }
}