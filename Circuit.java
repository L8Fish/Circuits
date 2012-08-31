package net.l8fish.circuits;

import java.util.ArrayList;

public class Circuit {
    public ArrayList<Element> elements;
    public ArrayList<Wire> wires;
    public ArrayList<Element> stack;
    public int stackCounter;
	
    public Circuit() {
	    elements = new ArrayList<Element>();
	    wires = new ArrayList<Wire>();
	    stack = new ArrayList<Element>();
	    stackCounter = 0;
    }
	
    public void powerUp() {
        for (Element element : elements) {
            stack.clear();
            stackCounter = 0;
            element.turnOn(true);
            useStack();
        }
    }
	
    public boolean isWiredUp() {
	    boolean wiredUp = true;
        for (Element element : elements) {
            if (!element.isConnected()) {
                wiredUp = false;
            }
        }
        for (Wire wire : wires) {
            if (!wire.isConnected()) {
                wiredUp = false;
            }
        }
        return wiredUp;
    }

    /**
     * At the moment just to test.
     */
    public void displayCircuit() {
        /*
	    for (int i=0; i<elements.size(); i++) {
	        System.out.println("El "+i+": isConnected="+elements.get(i).isConnected()+" isTurnedOn="+elements.get(i).isTurnedOn());
	        if (elements.get(i) instanceof InputAction) {System.out.println("Input: "+((InputAction)elements.get(i)).getInputAction());}
	    	if (elements.get(i) instanceof OutputAction) {System.out.println("Output: "+((OutputAction)elements.get(i)).getOutputAction());}
	    }
        for (Wire wire : wires) {
            System.out.println("Wire " + wire.getId() + ": isConnected=" + wire.isConnected() + " status=" + wire.getStatus());
        }
        */
        System.out.println("Result in bits (ripple-adder):");
        int max = 0;
        int count = 0;
        int tempNr = 0;
        int number = 0;
        for (int i=elements.size()-1; i>=0; i--) {
            if (elements.get(i) instanceof OutputAction) {
                max++;
                count = max;
            }
        }
        for (int i=elements.size()-1; i>=0; i--) {
            if (elements.get(i) instanceof OutputAction) {
                if (count==max) {tempNr = ((OutputAction)elements.get(i)).getOutputAction();}
                else if (count+1==max) {
                    System.out.print(((OutputAction)elements.get(i)).getOutputAction());
                    System.out.print(tempNr);
                    number+=Math.pow(2.0,count*1.0)*((OutputAction)elements.get(i)).getOutputAction();
                    number+=Math.pow(2.0,count-1.0)*tempNr;
                }
                else {
                    System.out.print(((OutputAction)elements.get(i)).getOutputAction());
                    number+=Math.pow(2.0,count-1.0)*((OutputAction)elements.get(i)).getOutputAction();
                }
                count--;
            }
        }
        System.out.println("");
        System.out.println("= "+number+" in decimal");
        System.out.println(""+Wire.numberOfWires+" wires used in Circuit!");
    }
	
    public void makeAction(int index, int actionInput) {
        if (elements.get(index) instanceof InputAction) {
	        stack.clear();
	        stackCounter = 0;
	        ((InputAction)elements.get(index)).setInputAction(actionInput);
	        useStack();
	    }
    }
	
    private void useStack() {
	    for (; stackCounter<stack.size(); stackCounter++) {
	        stack.get(stackCounter).performAction();
	    }
    }
}