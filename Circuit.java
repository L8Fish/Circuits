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
	for (int i=0; i<elements.size(); i++) {			
	    stack.clear();
	    stackCounter = 0;	                
	    elements.get(i).turnOn(true);
	    useStack();
	}
    }
	
    public boolean isWiredUp() {
	boolean wiredUp = true;
	for (int i=0; i<elements.size(); i++) {
	    if(!elements.get(i).isConnected()) {wiredUp = false;}
        }
        for (int i=0; i<wires.size(); i++) {
            if(!wires.get(i).isConnected()) {wiredUp = false;}
        }
        return wiredUp;
    }
	
    public void displayCircuit() {
	for (int i=0; i<elements.size(); i++) {
	    System.out.println("El "+i+": isConnected="+elements.get(i).isConnected()+" isTurnedOn="+elements.get(i).isTurnedOn());
	    if (elements.get(i) instanceof InputAction) {System.out.println("Input: "+((InputAction)elements.get(i)).getInputAction());}
	    	if (elements.get(i) instanceof OutputAction) {System.out.println("Output: "+((OutputAction)elements.get(i)).getOutputAction());}
	}
        for (int i=0; i<wires.size(); i++) {
	          System.out.println("Wire "+wires.get(i).getId()+": isConnected="+wires.get(i).isConnected()+" status="+wires.get(i).getStatus());
        }
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