package net.l8fish.circuits;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: L8Fish
 * Date: 31/07/12
 * Time: 15:23
 * To change this template use File | Settings | File Templates.
 */
public class OrGate extends Logic {
    public OrGate() {
        super();
    }

    public OrGate(ArrayList<Wire> input, ArrayList<Wire> output) {
        super(input, output);
    }

    public boolean isConnected() {
        if (this.getInput().size()==2 && this.getOutput().size()==1) {return true;}
        else {return false;}
    }

    public void performAction() {
        if (isConnected()) {
            boolean first = getOutput().get(0).getStatus();
            if (this.isTurnedOn() && (getInput().get(0).getStatus() || getInput().get(1).getStatus())) {
                getOutput().get(0).setStatus(true);
            }
            else {
                getOutput().get(0).setStatus(false);
            }
            boolean second = getOutput().get(0).getStatus();
            if (first!=second && getCircuit()!=null) {
                getCircuit().stack.add(getOutput().get(0).getOutput());
            }
        }
    }
}