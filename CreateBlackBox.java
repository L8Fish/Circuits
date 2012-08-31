package net.l8fish.circuits;

public class CreateBlackBox {
    public static BlackBox xor() {
        BlackBox xor = new BlackBox();

        Wire wire1 = new Wire();
        Wire wire2 = new Wire();
        Wire wire3 = new Wire();
        Wire wire4 = new Wire();
        Wire wire5 = new Wire();
        Wire wire6 = new Wire();
        Wire wire7 = new Wire();
        Wire wire8 = new Wire();
        Wire wire9 = new Wire();
        Wire wire10 = new Wire();

        Demux dem1 = new Demux();
        dem1.setOutput(0, wire1);
        Demux dem2 = new Demux();
        dem2.setOutput(0, wire2);
        Demux dem3 = new Demux();
        dem3.setInput(0, wire10);
        Wire[] wires1 = {wire1};
        Wire[] wires35 = {wire3,wire5};
        Demux demux1 = new Demux(wires1,wires35);
        Wire[] wires2 = {wire2};
        Wire[] wires46 = {wire4,wire6};
        Demux demux2 = new Demux(wires2,wires46);
        OrGate or1 = new OrGate();
        or1.setInput(0, wire3);
        or1.setInput(1, wire4);
        or1.setOutput(0, wire7);
        AndGate and1 = new AndGate();
        and1.setInput(0, wire5);
        and1.setInput(1, wire6);
        and1.setOutput(0, wire8);
        NotGate not1 = new NotGate();
        not1.setInput(0, wire8);
        not1.setOutput(0, wire9);
        AndGate and2 = new AndGate();
        and2.setInput(0, wire7);
        and2.setInput(1, wire9);
        and2.setOutput(0, wire10);

        xor.addElement(dem1);
        xor.addElement(dem2);
        xor.addElement(demux1);
        xor.addElement(demux2);
        xor.addElement(or1);
        xor.addElement(and1);
        xor.addElement(not1);
        xor.addElement(and2);
        xor.addElement(dem3);
        xor.addWire(wire1);
        xor.addWire(wire2);
        xor.addWire(wire3);
        xor.addWire(wire4);
        xor.addWire(wire5);
        xor.addWire(wire6);
        xor.addWire(wire7);
        xor.addWire(wire8);
        xor.addWire(wire9);
        xor.addWire(wire10);

        //Element xor1 = xor.newInstance();
        //return (BlackBox)xor1;

        return xor;
    }

    public static BlackBox halfAdder() {
        BlackBox xor1 = CreateBlackBox.xor();

        BlackBox halfAdder = new BlackBox();

        Wire wire1 = new Wire();
        Wire wire2 = new Wire();
        Wire wire3 = new Wire();
        Wire wire4 = new Wire();
        Wire wire5 = new Wire();
        Wire wire6 = new Wire();
        Wire wire7 = new Wire();

        Demux dem1 = new Demux();
        dem1.setOutput(0, wire1);
        Demux dem2 = new Demux();
        dem2.setOutput(0, wire2);
        Demux dem3 = new Demux();
        dem3.setInput(0, wire7);
        Wire[] wires1 = {wire1};
        Wire[] wires2 = {wire2};
        Wire[] wires35 = {wire3,wire5};
        Wire[] wires46 = {wire4,wire6};
        Demux demux1 = new Demux(wires1,wires35);
        Demux demux2 = new Demux(wires2,wires46);
        AndGate and1 = new AndGate();
        xor1.setInput(0, wire5);
        xor1.setInput(1, wire6);
        and1.setInput(0, wire3);
        and1.setInput(1, wire4);
        and1.setOutput(0, wire7);

        halfAdder.addElement(dem1);
        halfAdder.addElement(dem2);
        halfAdder.addElement(demux1);
        halfAdder.addElement(demux2);
        halfAdder.addElement(and1);
        halfAdder.addElement(dem3);
        halfAdder.addElement(xor1);

        halfAdder.addWire(wire1);
        halfAdder.addWire(wire2);
        halfAdder.addWire(wire3);
        halfAdder.addWire(wire4);
        halfAdder.addWire(wire5);
        halfAdder.addWire(wire6);
        halfAdder.addWire(wire7);

        //Element halfAdder1 = halfAdder.newInstance();
        //return (BlackBox)halfAdder1;

        return halfAdder;
    }

    public static BlackBox fullAdder() {
        BlackBox halfAdder1 = CreateBlackBox.halfAdder();
        BlackBox halfAdder2 = CreateBlackBox.halfAdder();

        BlackBox fullAdder = new BlackBox();

        Wire wire1 = new Wire();
        Wire wire2 = new Wire();
        Wire wire3 = new Wire();
        Wire wire4 = new Wire();

        Demux dem1 = new Demux();
        dem1.setInput(0, wire4);

        OrGate or1 = new OrGate();
        or1.setInput(0, wire1);
        or1.setInput(1, wire3);
        or1.setOutput(0, wire4);
        halfAdder1.setOutput(0, wire1);
        halfAdder1.setOutput(1, wire2);
        halfAdder2.setInput(0, wire2);
        halfAdder2.setOutput(0, wire3);

        fullAdder.addElement(halfAdder1);
        fullAdder.addElement(or1);
        fullAdder.addElement(dem1);
        fullAdder.addElement(halfAdder2);
        fullAdder.addWire(wire1);
        fullAdder.addWire(wire2);
        fullAdder.addWire(wire3);
        fullAdder.addWire(wire4);

        //Element fullAdder1 = fullAdder.newInstance();
        //return (BlackBox)fullAdder1;

        return fullAdder;
    }

    public static BlackBox rippleAdder(int amount) {
        BlackBox[] fullAdders = new BlackBox[amount];
        BlackBox rippleAdder = new BlackBox();

        for (int i=0; i<amount; i++) {
            if (amount==1) {
                fullAdders[i] = CreateBlackBox.fullAdder();
                rippleAdder.addElement(fullAdders[i]);
            }
            else if (amount-i==1) {
                fullAdders[i] = CreateBlackBox.fullAdder();
                fullAdders[i].setInput(2, fullAdders[i-1].getOutput().get(0).getOutput(0));
                rippleAdder.addElement(fullAdders[i]);
            }
            else if (i==0){
                fullAdders[i] = CreateBlackBox.fullAdder();
                Wire wire1 = new Wire();
                fullAdders[i].setOutput(0, wire1);
                rippleAdder.addElement(fullAdders[i]);
                rippleAdder.addWire(wire1);
            }
            else {
                fullAdders[i] = CreateBlackBox.fullAdder();
                fullAdders[i].setInput(2, fullAdders[i-1].getOutput().get(0).getOutput(0));
                Wire wire1 = new Wire();
                fullAdders[i].setOutput(0, wire1);
                rippleAdder.addElement(fullAdders[i]);
                rippleAdder.addWire(wire1);
            }
        }

        //Element rippleAdder1 = rippleAdder.newInstance();
        //return (BlackBox)rippleAdder1;

        return rippleAdder;
    }

    public static void wireUp(BlackBox bb, Circuit circuit) {
        for (int i=0; i<bb.getInput().size(); i++) {
            Battery batt = new Battery();
            Switch sw = new Switch();
            Wire wire1 = new Wire();
            Wire wire2 = new Wire();
            batt.setOutput(0, wire1);
            sw.setInput(0, wire1);
            sw.setOutput(0, wire2);
            bb.setInput(i, wire2);
            batt.setCircuit(circuit);
            sw.setCircuit(circuit);
            circuit.elements.add(batt);
            circuit.elements.add(sw);
            circuit.wires.add(wire1);
            circuit.wires.add(wire2);
        }
        circuit.elements.add(bb);
        for (int i=0; i<bb.getOutput().size(); i++) {
            Light li = new Light();
            Wire wire1 = new Wire();
            li.setInput(0, wire1);
            bb.setOutput(i, wire1);
            li.setCircuit(circuit);
            circuit.elements.add(li);
            circuit.wires.add(wire1);
        }
        bb.setCircuit(circuit);
    }
}
