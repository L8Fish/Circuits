package net.l8fish.circuits;

public abstract class Input extends Element {

    private Wire[] output;

    public Input(int out) {
        output = new Wire[out];
    }

    public Input(Wire[] output) {
	    super();
	    this.output = output;
        for (Wire anOutput : output) {
            anOutput.setInput(this);
        }
    }

    public void setOutput(Wire[] output) {
	    this.output = output;
        for (Wire anOutput : output) {
            anOutput.setInput(this);
        }
    }

    public void setOutput(int index, Wire wire) {
        output[index] = wire;
        wire.setInput(this);
    }

    public Wire[] getOutput() {
	    return output;
    }

    public Wire getOutput(int index) {
        return output[index];
    }
}