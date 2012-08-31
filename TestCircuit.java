package net.l8fish.circuits;
  
import java.util.Scanner;

public class TestCircuit {
    public static void main(String[] args) {
        //Test: CreateBlackBox

        Circuit c1 = new Circuit();

        int number1 = 0;
        int number2 = 0;

        Scanner scan = new Scanner(System.in);
        System.out.println("Length of binary numbers:");
        int amount = Integer.parseInt(scan.nextLine());

        BlackBox tester = CreateBlackBox.rippleAdder(amount);

        CreateBlackBox.wireUp(tester, c1);

        c1.powerUp();

        System.out.println("Give the first binary number:");
        String first = scan.nextLine();

        for (int i=0; i<amount; i++) {
            number1 += Math.pow(2.0, i*1.0)* Integer.parseInt("" + first.charAt(amount - i - 1));
            if (i==0) {
                c1.makeAction(1, Integer.parseInt("" + first.charAt(amount - i - 1)));
            }
            else {
                c1.makeAction(i * 4 + 3, Integer.parseInt("" + first.charAt(amount - i - 1)));
            }
        }
        System.out.println("Give the second binary number:");
        String second = scan.nextLine();
        for (int i=0; i<amount; i++) {
            number2 += Math.pow(2.0, i*1.0)* Integer.parseInt("" + second.charAt(amount - i - 1));
            if (i==0) {
                c1.makeAction(3, Integer.parseInt("" + second.charAt(amount - i - 1)));
            }
            else {
                c1.makeAction(i * 4 + 5, Integer.parseInt("" + second.charAt(amount - i - 1)));
            }
        }
        System.out.println(""+number1+" + "+number2+" =");
        c1.displayCircuit();

        /*
        //Test: Circuit()

        Circuit c2 = new Circuit();

    	Wire wire0 = new Wire();
	    Wire wire1 = new Wire();
    	Wire wire2 = new Wire();
	    Wire wire3 = new Wire();
    	Wire wire4 = new Wire();
        Wire wire5 = new Wire();
        Wire wire6 = new Wire();
        Wire wire7 = new Wire();
        Wire wire8 = new Wire();

    	Wire[] wires0 = new Wire[1];
	    wires0[0] = wire0;
        Wire[] wires1 = new Wire[1];
	    wires1[0] = wire1;
        Wire[] wires2 = new Wire[1];
	    wires2[0] = wire2;
        Wire[] wires3 = new Wire[1];
        wires3[0] = wire3;
        Wire[] wires4 = new Wire[1];
	    wires4[0] = wire4;
        Wire[] wires5 = new Wire[1];
        wires5[0] = wire5;
        Wire[] wires6 = new Wire[1];
        wires6[0] = wire6;
        Wire[] wires7 = new Wire[1];
        wires7[0] = wire7;
        Wire[] wires8 = new Wire[1];
        wires8[0] = wire8;
        Wire[] wires35 = new Wire[2];
        wires35[0] = wire3;
        wires35[1] = wire5;
        Wire[] wires67 = new Wire[2];
        wires67[0] = wire6;
        wires67[1] = wire7;
	
    	Element batt0 = new Battery(wires0);
        batt0.setCircuit(c2);
        Element batt1 = new Battery(wires2);
        batt1.setCircuit(c2);
        Element batt2 = new Battery(wires4);
        batt2.setCircuit(c2);
    	Element switch0 = new Switch(wires0,wires1);
        switch0.setCircuit(c2);
        Element switch1 = new Switch(wires2,wires3);
        switch1.setCircuit(c2);
        Element switch2 = new Switch(wires4,wires5);
        switch2.setCircuit(c2);
    	Element not0 = new NotGate(wires1,wires6);
        not0.setCircuit(c2);
    	Element or0 = new OrGate(wires35,wires7);
        or0.setCircuit(c2);
    	Element and0 = new AndGate(wires67,wires8);
        and0.setCircuit(c2);
    	Element light0 = new Light(wires8);
        light0.setCircuit(c2);

    	c2.elements.add(batt0);
	    c2.elements.add(batt1);
        c2.elements.add(batt2);
	    c2.elements.add(switch0);
    	c2.elements.add(switch1);
	    c2.elements.add(switch2);
        c2.elements.add(not0);
        c2.elements.add(or0);
        c2.elements.add(and0);
        c2.elements.add(light0);
    	c2.wires.add(wire0);
	    c2.wires.add(wire1);
    	c2.wires.add(wire2);
	    c2.wires.add(wire3);
    	c2.wires.add(wire4);
        c2.wires.add(wire5);
        c2.wires.add(wire6);
        c2.wires.add(wire7);
        c2.wires.add(wire8);
	
	    c2.powerUp();

	    c2.makeAction(3,0);
        c2.makeAction(4,1);
        c2.makeAction(5,1);

        c2.displayCircuit();

        //Test: newInstance()

        BlackBox fullAdder = (BlackBox) CreateBlackBox.fullAdder().newInstance();
        BlackBox rippleAdder = new BlackBox();

        rippleAdder.addElement(fullAdder);

        Battery b0 = new Battery();
        Battery b1 = new Battery();
        Battery b2 = new Battery();
        Switch sw0 = new Switch();
        Switch sw1 = new Switch();
        Switch sw2 = new Switch();
        Light li0 = new Light();
        Light li1 = new Light();
        Wire w1 = new Wire();
        Wire w2 = new Wire();
        Wire w3 = new Wire();
        Wire w4 = new Wire();
        Wire w5 = new Wire();
        Wire w6 = new Wire();
        Wire w7 = new Wire();
        Wire w8 = new Wire();

        b0.setOutput(0, w1);
        b1.setOutput(0, w2);
        b2.setOutput(0, w3);
        sw0.setInput(0, w1);
        sw1.setInput(0, w2);
        sw2.setInput(0, w3);
        sw0.setOutput(0, w4);
        sw1.setOutput(0, w5);
        sw2.setOutput(0, w6);
        li0.setInput(0, w7);
        li1.setInput(0, w8);
        rippleAdder.setInput(0, w4);
        rippleAdder.setInput(1, w5);
        rippleAdder.setInput(2, w6);
        rippleAdder.setOutput(0, w7);
        rippleAdder.setOutput(1, w8);

        Circuit c3 = new Circuit();

        b0.setCircuit(c3);
        b1.setCircuit(c3);
        b2.setCircuit(c3);
        sw0.setCircuit(c3);
        sw1.setCircuit(c3);
        sw2.setCircuit(c3);
        li0.setCircuit(c3);
        li1.setCircuit(c3);
        rippleAdder.setCircuit(c3);

        c3.elements.add(b0);
        c3.elements.add(b1);
        c3.elements.add(b2);
        c3.elements.add(sw0);
        c3.elements.add(sw1);
        c3.elements.add(sw2);
        c3.elements.add(rippleAdder);
        c3.elements.add(li0);
        c3.elements.add(li1);
        c3.wires.add(w1);
        c3.wires.add(w2);
        c3.wires.add(w3);
        c3.wires.add(w4);
        c3.wires.add(w5);
        c3.wires.add(w6);
        c3.wires.add(w7);
        c3.wires.add(w8);

        c3.powerUp();

        c3.makeAction(3,1);
        c3.makeAction(4,1);
        c3.makeAction(5,0);

        c3.displayCircuit();
        */
    }
}