package net.l8fish.circuits;

import java.util.ArrayList;

public abstract class Output extends Element {
    private ArrayList<Wire> input;
        
    public Output() {
	super();
	input = new ArrayList<Wire>();
    }
  
    public Output(ArrayList<Wire> input) {
	super();
	this.input = input;
	for (int i=0; i<input.size(); i++) {
	    input.get(i).setOutput(this);
	}
    }
  
    public void setInput(ArrayList<Wire> input) {
	this.input = input;
	for (int i=0; i<input.size(); i++) {
	    input.get(i).setOutput(this);
	}
    }
  
    public ArrayList<Wire> getInput() {
	return input;
    }
}