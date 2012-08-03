package net.l8fish.circuits;

import java.util.ArrayList;

public abstract class Input extends Element {
    private ArrayList<Wire> output;
          
    public Input() {
	    super();
	    output = new ArrayList<Wire>();
    }
  
    public Input(ArrayList<Wire> output) {
	    super();
	    this.output = output;
	    for (int i=0; i<output.size(); i++) {
	        output.get(i).setInput(this);
	    }
    }
  
    public void setOutput(ArrayList<Wire> output) {
	    this.output = output;
	    for (int i=0; i<output.size(); i++) {
	        output.get(i).setInput(this);
	    }
    }
  
    public ArrayList<Wire> getOutput() {
	    return output;
    }
}