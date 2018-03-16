package model;

public class Leaf implements TreeComponent {

    String label;

    public Leaf(String _label) {
        label = _label;
    }

    @Override
    public void accept(Visitor v) {
        v.visitLeaf(this);
    }

    //Getters and Setters
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
