package net.l8fish.circuits;

public abstract class Logic extends Element {
    private Wire[] input;
    private Wire[] output;

    public Logic(int in, int out) {
        input = new Wire[in];
        output = new Wire[out];
    }

    public Logic(Wire[] input, Wire[] output) {
	    super();
        this.input = input;
        this.output = output;
        for (Wire anInput : input) {
            anInput.setOutput(this);
        }
        for (Wire anOutput : output) {
            anOutput.setInput(this);
        }
    }
  
    public void setInput(Wire[] input) {
	    this.input = input;
        for (Wire anInput : input) {
            anInput.setOutput(this);
        }
    }

    public void setInput(int index, Wire wire) {
        input[index] = wire;
        if (wire!=null)
        wire.setOutput(this);
    }
  
    public void setOutput(Wire[] output) {
	    this.output = output;
        for (Wire anOutput : output) {
            anOutput.setInput(this);
        }
    }

    public void setOutput(int index, Wire wire) {
        output[index] = wire;
        if(wire!=null)
        wire.setInput(this);
    }
  
    public Wire[] getInput() {
	    return input;
    }

    public Wire getInput(int index) {
        return input[index];
    }
  
    public Wire[] getOutput() {
	    return output;
    }

    public Wire getOutput(int index) {
        return output[index];
    }
}