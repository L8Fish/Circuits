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
	
	Element batt = new Battery(wires0);
	batt.setCircuit(test);
	Element switch0 = new Switch(wires0,wires1);
	switch0.setCircuit(test);
	Element not0 = new NotGate(wires1,wires2);
	not0.setCircuit(test);
	Element not1 = new NotGate(wires2,wires3);
	not1.setCircuit(test);
	Element not2 = new NotGate(wires3,wires4);
	not2.setCircuit(test);
	Element light = new Light(wires4);
	light.setCircuit(test);
	
	test.elements.add(batt);
	test.elements.add(switch0);
	test.elements.add(not0);
	test.elements.add(not1);
	test.elements.add(not2);
	test.elements.add(light);
	test.wires.add(wire0);
	test.wires.add(wire1);
	test.wires.add(wire2);
	test.wires.add(wire3);
	test.wires.add(wire4);
	
	test.powerUp();
	//test.makeAction(1,1);
	//test.powerUp();
	test.displayCircuit();		
    }
}