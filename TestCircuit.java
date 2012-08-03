package net.l8fish.circuits;
  
import java.util.ArrayList;

public class TestCircuit {
    public static void main(String[] args) {
	    Circuit test = new Circuit();

    	Wire wire0 = new Wire();
	    Wire wire1 = new Wire();
    	Wire wire2 = new Wire();
	    Wire wire3 = new Wire();
    	Wire wire4 = new Wire();
        Wire wire5 = new Wire();
        Wire wire6 = new Wire();
        Wire wire7 = new Wire();
        Wire wire8 = new Wire();

    	ArrayList<Wire> wires0 = new ArrayList<Wire>();
	    wires0.add(wire0);
	    ArrayList<Wire> wires1 = new ArrayList<Wire>();
	    wires1.add(wire1);
    	ArrayList<Wire> wires2 = new ArrayList<Wire>();
	    wires2.add(wire2);
    	ArrayList<Wire> wires3 = new ArrayList<Wire>();
	    wires3.add(wire3);
    	ArrayList<Wire> wires4 = new ArrayList<Wire>();
	    wires4.add(wire4);
        ArrayList<Wire> wires5 = new ArrayList<Wire>();
        wires5.add(wire5);
        ArrayList<Wire> wires6 = new ArrayList<Wire>();
        wires6.add(wire6);
        ArrayList<Wire> wires7 = new ArrayList<Wire>();
        wires7.add(wire7);
        ArrayList<Wire> wires8 = new ArrayList<Wire>();
        wires8.add(wire8);
        ArrayList<Wire> wires35 = new ArrayList<Wire>();
        wires35.add(wire3);
        wires35.add(wire5);
        ArrayList<Wire> wires67 = new ArrayList<Wire>();
        wires67.add(wire6);
        wires67.add(wire7);
	
    	Element batt0 = new Battery(wires0);
	    batt0.setCircuit(test);
        Element batt1 = new Battery(wires2);
        batt1.setCircuit(test);
        Element batt2 = new Battery(wires4);
        batt2.setCircuit(test);
    	Element switch0 = new Switch(wires0,wires1);
	    switch0.setCircuit(test);
        Element switch1 = new Switch(wires2,wires3);
        switch1.setCircuit(test);
        Element switch2 = new Switch(wires4,wires5);
        switch2.setCircuit(test);
    	Element not0 = new NotGate(wires1,wires6);
	    not0.setCircuit(test);
    	Element or0 = new OrGate(wires35,wires7);
	    or0.setCircuit(test);
    	Element and0 = new AndGate(wires67,wires8);
	    and0.setCircuit(test);
    	Element light0 = new Light(wires8);
	    light0.setCircuit(test);
	
    	test.elements.add(batt0);
	    test.elements.add(batt1);
        test.elements.add(batt2);
	    test.elements.add(switch0);
    	test.elements.add(switch1);
	    test.elements.add(switch2);
        test.elements.add(not0);
        test.elements.add(or0);
        test.elements.add(and0);
        test.elements.add(light0);
    	test.wires.add(wire0);
	    test.wires.add(wire1);
    	test.wires.add(wire2);
	    test.wires.add(wire3);
    	test.wires.add(wire4);
        test.wires.add(wire5);
        test.wires.add(wire6);
        test.wires.add(wire7);
        test.wires.add(wire8);
	
	    test.powerUp();

	    test.makeAction(3,0);
        test.makeAction(4,1);
        test.makeAction(5,1);
	    //test.powerUp();

        test.displayCircuit();
    }
}