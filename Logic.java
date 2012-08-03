package net.l8fish.circuits;

import java.util.ArrayList;

public abstract class Logic extends Element {
    private ArrayList<Wire> input;
    private ArrayList<Wire> output; 
        
    public Logic() {
	    super();
	    input = new ArrayList<Wire>();
	    output = new ArrayList<Wire>();
    }
  
    public Logic(ArrayList<Wire> input, ArrayList<Wire> output) {
	    super();
	    this.input = input;
	    this.output = output;
	    for (int i=0; i<input.size(); i++) {
	        input.get(i).setOutput(this);
	    }
	    for (int i=0; i<output.size(); i++) {
	        output.get(i).setInput(this);
	    }
    }
  
    public void setInput(ArrayList<Wire> input) {
	    this.input = input;
	    for (int i=0; i<input.size(); i++) {
	        input.get(i).setOutput(this);
	    }
    }
  
    public void setOutput(ArrayList<Wire> output) {
	    this.output = output;
	    for (int i=0; i<output.size(); i++) {
	        output.get(i).setInput(this);
    	}
    }
  
    public ArrayList<Wire> getInput() {
	    return input;
    }
  
    public ArrayList<Wire> getOutput() {
	    return output;
    }
}