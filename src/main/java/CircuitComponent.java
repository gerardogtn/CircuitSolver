package main.java;

/**
 * Created by gerardogtn on 2/15/16.
 */
public abstract class CircuitComponent {

    private String label;

    public CircuitComponent(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CircuitComponent that = (CircuitComponent) o;

        return label.equals(that.label);

    }

    @Override
    public int hashCode() {
        return label.hashCode();
    }
}
