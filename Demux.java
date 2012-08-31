package net.l8fish.circuits;

public class Demux extends Logic {

    public Demux() {
        super(1, 1);
    }

    public Demux (int in, int out) {
        super(in, out);
    }

    public Demux(Wire[] input, Wire[] output) {
        super(input, output);
    }

    public boolean isConnected() {
        for (int i=0; i<this.getInput().length; i++)
            if (this.getInput()[i]==null) {
                return false;
            }
        for (int i=0; i<this.getOutput().length; i++)
            if (this.getOutput()[i]==null) {
                return false;
            }
        return true;
    }

    public void performAction() {
        if (isConnected()) {
            boolean first = getOutput()[0].getStatus();
            if (this.isTurnedOn()) {
                for (int i=0; i<getOutput().length; i++) {
                    getOutput()[i].setStatus(getInput()[0].getStatus());
                }
            }
            else {
                for (int i=0; i<getOutput().length; i++) {
                    getOutput()[i].setStatus(false);
                }
            }
            boolean second = getOutput()[0].getStatus();
            if (first!=second && getCircuit()!=null) {
                for (int i=0; i<getOutput().length; i++) {
                    getCircuit().stack.add(getOutput()[i].getOutput());
                }
            }
        }
    }

    public Element newInstance() {
        return new Demux(this.getInput().length,this.getOutput().length);
    }
}