package model;

//TODO: Composite and Visitors
public class CalcList {
    public String equation;
    public String full;
    public Integer lhs;
    public Integer rhs;
    public TreeComponent tree;

    CalcList() {
        equation = "";
        full = "";
    }

    public void addNode(String op) {
        tree = new Node(op, tree, null);
    }
    public void addNode(String op, String lhs, String rhs) {
        tree = new Node(op, new Leaf(lhs), new Leaf(rhs));
    }
    public void addNode(String op, String val, boolean lhs) {
        if (lhs)
            tree = new Node(op, new Leaf(val), null);
        else
            tree = new Node(op, null, new Leaf(val));
    }
}
