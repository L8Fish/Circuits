package net.l8fish.circuits;

public class AndGate extends Logic {
    public AndGate() {
        super(2, 1);
    }

    public AndGate(Wire[] input, Wire[] output) {
        super(input, output);
    }

    public boolean isConnected() {
        return this.getInput().length == 2 && this.getOutput().length == 1;
    }

    public void performAction() {
        if (isConnected()) {
            boolean first = getOutput()[0].getStatus();
            if (this.isTurnedOn() && (getInput()[0].getStatus() && getInput()[1].getStatus())) {
                getOutput()[0].setStatus(true);
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
        return new AndGate();
    }
}