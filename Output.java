package net.l8fish.circuits;

public abstract class Output extends Element {
    private Wire[] input;

    public Output(int in) {
        input = new Wire[in];
    }
        
    public Output(Wire[] input) {
	    super();
	    this.input = input;
        for (Wire anInput : input) {
            anInput.setOutput(this);
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
        wire.setOutput(this);
    }
  
    public Wire[] getInput() {
	    return input;
    }

    public Wire getInput(int index) {
        return input[index];
    }
}