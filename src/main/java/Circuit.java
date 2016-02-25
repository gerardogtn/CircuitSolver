package main.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gerardogtn on 2/8/16.
 */
public class Circuit {

    private List<CircuitComponent> components;
    private List<CircuitConnection> connections;

    private Wire startWire;
    private Wire endWire;

    public Circuit() {
        components = new ArrayList<CircuitComponent>();
        connections = new ArrayList<CircuitConnection>();
    }

    public Wire getEndWire() {
        return endWire;
    }

    public void setEndWire(Wire endWire) {
        this.endWire = endWire;
    }

    public Wire getStartWire() {
        return startWire;
    }

    public void setStartWire(Wire startWire) {
        this.startWire = startWire;
    }

    public void addComponent(CircuitComponent component) {
        components.add(component);
    }

    public void addComponents(CircuitComponent... components) {
        for (CircuitComponent component : components) {
            addComponent(component);
        }
    }

    public void addConnection(CircuitComponent entryComponent, CircuitComponent exitComponent) {
        addConnection(new CircuitConnection(entryComponent, exitComponent));
    }

    public void addConnection(CircuitConnection connection) {
        connections.add(connection);
    }

    public void addLinearConnection(CircuitComponent... components) {
        for (int i = 0; i < components.length - 1; i++) {
            addConnection(components[i], components[i + 1]);
        }
    }

    public LinkedList<CircuitComponent> getNextComponent(CircuitComponent component){
        LinkedList<CircuitComponent> output = new LinkedList<CircuitComponent>();
        for (CircuitConnection connection : connections){
            if (connection.getEntryComponent().equals(component)){
                output.add(connection.getExitComponent());
            }
        }
        return output;
    }

}
