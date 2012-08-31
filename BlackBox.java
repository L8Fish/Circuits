package net.l8fish.circuits;

import java.util.ArrayList;

public class BlackBox extends Element {
    private ArrayList<Element> elements;
    private ArrayList<Wire> wires;
    private ArrayList<Demux> input;
    private ArrayList<Demux> output;
    private ArrayList<Element> baseElements;
    private ArrayList<Wire> baseWires;

    public BlackBox() {
        super();
        elements = new ArrayList<Element>();
        wires = new ArrayList<Wire>();
        input = new ArrayList<Demux>();
        output = new ArrayList<Demux>();
        baseElements = new ArrayList<Element>();
        baseWires = new ArrayList<Wire>();
    }

    public void addElement(Element element) {
        elements.add(element);
        if (!(element instanceof BlackBox)) {
            baseElements.add(element);
        }
        if (element instanceof Demux) {
            if (((Demux)element).getInput(0)==null) {
                input.add((Demux)element);
            }
            if (((Demux)element).getOutput(0)==null) {
                output.add((Demux)element);
            }
        }
        if (element instanceof BlackBox) {
            buildBaseElements((BlackBox)element);
            for (Wire wire: ((BlackBox) element).getBaseWires()) {
                baseWires.add(wire);
            }

            for (int i=0; i<((BlackBox)element).getInput().size(); i++) {
                if(((BlackBox)element).getInput().get(i).getInput(0)==null) {
                    input.add(((BlackBox)element).getInput().get(i));
                }
            }
            for (int i=0; i<((BlackBox)element).getOutput().size(); i++) {
                if(((BlackBox)element).getOutput().get(i).getOutput(0)==null) {
                    output.add(((BlackBox)element).getOutput().get(i));
                }
            }
        }
    }

    public ArrayList<Demux> getInput() {
        return input;
    }

    public void setInput(int index, Wire wire) {
        input.get(index).setInput(0, wire);
        wire.setOutput(this);
    }

    public ArrayList<Demux> getOutput() {
        return output;
    }

    public void setOutput(int index, Wire wire) {
        output.get(index).setOutput(0, wire);
        wire.setInput(this);
    }

    public void addWire(Wire wire) {
        wires.add(wire);
        baseWires.add(wire);
    }

    public void turnOn(boolean signal) {
        super.turnOn(signal);
        for (Element element : elements) {
            element.turnOn(signal);
        }
    }

    public void setCircuit(Circuit circuit) {
        super.setCircuit(circuit);
        for (Element element : elements) {
            element.setCircuit(circuit);
        }
    }

    public boolean isConnected() {
        for (Element element : elements) {
            if (!element.isConnected()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Implementation needed for turnOn() used in powerUp() of Circuit
     */
    public void performAction() {
        if (isConnected() && isTurnedOn()) {
            for (Element element : elements) {
                element.performAction();
            }
        }
    }

    public void buildBaseElements(BlackBox bb) {
        for (Element element: bb.getBaseElements()) {
            baseElements.add(element);
        }
    }

    public ArrayList<Element> getBaseElements() {
        return baseElements;
    }

    public ArrayList<Wire> getBaseWires() {
        return baseWires;
    }

    /**
     * Clean up messy code
     * @return ...
     */
    public Element newInstance() {
        BlackBox newBB = new BlackBox();

        ArrayList<Element> tempElements = new ArrayList<Element>();
        ArrayList<Wire> tempWires = new ArrayList<Wire>();

        for (Wire wire : baseWires) {
            tempWires.add(new Wire());
        }

        for (int i=0; i<baseElements.size(); i++) {
            tempElements.add(baseElements.get(i).newInstance());
            if (baseElements.get(i) instanceof Input) {
                for (int j=0; j<((Input)baseElements.get(i)).getOutput().length; j++) {
                    ((Input)tempElements.get(i)).setOutput(j, tempWires.get(baseWires.indexOf(((Input)baseElements.get(i)).getOutput(j))));
                }
                newBB.addElement(tempElements.get(i));
            }
            if (baseElements.get(i) instanceof Output) {
                for (int j=0; j<((Output)baseElements.get(i)).getInput().length; j++) {
                    ((Output)tempElements.get(i)).setInput(j, tempWires.get(baseWires.indexOf(((Output)baseElements.get(i)).getInput(j))));
                }
                newBB.addElement(tempElements.get(i));
            }
            if (baseElements.get(i) instanceof Logic) {
                if (((Logic)baseElements.get(i)).getOutput().length>0 && ((Logic)baseElements.get(i)).getOutput()[0]!=null) {
                    for (int j=0; j<((Logic)baseElements.get(i)).getOutput().length; j++) {
                        ((Logic)tempElements.get(i)).setOutput(j, tempWires.get(baseWires.indexOf(((Logic)baseElements.get(i)).getOutput(j))));
                    }
                }
                if (((Logic)baseElements.get(i)).getInput().length>0 && ((Logic)baseElements.get(i)).getInput()[0]!=null) {
                    for (int j=0; j<((Logic)baseElements.get(i)).getInput().length; j++) {
                        ((Logic)tempElements.get(i)).setInput(j, tempWires.get(baseWires.indexOf(((Logic)baseElements.get(i)).getInput(j))));
                    }
                }
                newBB.addElement(tempElements.get(i));
            }
        }
        for (Wire tempWire : tempWires) {
            newBB.addWire(tempWire);
        }
        return newBB;
    }
}
