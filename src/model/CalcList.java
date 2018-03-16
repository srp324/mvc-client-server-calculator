package model;

public class CalcList {
    public String equation;
    public String full; //TODO: Remove full
    public Integer lhs;
    public Integer rhs;
    public String prevOp;
    public String currOp;
    TreeComponent tree;

    CalcList() {
        equation = "";
        full = "";
        prevOp = "";
        currOp = "";
    }

    public TreeComponent getTree() {
        return tree;
    }
    public void addNode(String op) {
        tree = new Node(op, tree, null);
    }
    public void addNode(String op, String val, boolean lhs) {
        if (lhs)
            tree = new Node(op, new Leaf(val), null);
        else
            tree = new Node(op, null, new Leaf(val));
    }
    public void addRightLeaf(String digit) {
        tree = new Node(((Node) tree).label, ((Node) tree).getLeft(), new Leaf(digit));
    }
    public void clearNodes() {
        tree = v -> {};
    }
    public String getEquation() {
        return equation;
    }
}
