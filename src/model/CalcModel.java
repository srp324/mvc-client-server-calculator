package model;

public class CalcModel {
    private String equation;
    private String onError;
    private Integer lhs;
    private Integer rhs;
    private String prevOp;
    private String currOp;
    private TreeComponent tree;

    public CalcModel() {
        equation = "";
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
        tree = new Node(((Node) tree).getLabel(), ((Node) tree).getLeft(), new Leaf(digit));
    }
    public void clearNodes() {
        tree = v -> {};
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public String getOnError() {
        return onError;
    }

    public void setOnError(String onError) {
        this.onError = onError;
    }

    public Integer getLhs() {
        return lhs;
    }

    public void setLhs(Integer lhs) {
        this.lhs = lhs;
    }

    public Integer getRhs() {
        return rhs;
    }

    public void setRhs(Integer rhs) {
        this.rhs = rhs;
    }

    public String getPrevOp() {
        return prevOp;
    }

    public void setPrevOp(String prevOp) {
        this.prevOp = prevOp;
    }

    public String getCurrOp() {
        return currOp;
    }

    public void setCurrOp(String currOp) {
        this.currOp = currOp;
    }
}
