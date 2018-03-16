package model;

public class Node implements TreeComponent {
    String label;
    TreeComponent left;
    TreeComponent right;

    public Node(String _label, TreeComponent _left, TreeComponent _right) {
        label = _label;
        left = _left;
        right = _right;
    }

    @Override
    public void accept(Visitor v) {
        v.visitPreNode(this);
        left.accept(v);
        right.accept(v);
        v.visitPostNode(this);
        /*left.accept(v);
        if (left instanceof Node)
            v.visitNode((Node) left);
        else
            v.visitLeaf((Leaf) left);

        right.accept(v);
        if (right instanceof Node)
            v.visitNode((Node) right);
        else
            v.visitLeaf((Leaf) right);*/

        //v.visitTree(this.left);
        //v.visitTree(this.right);
        //left.accept(v);
        //right.accept(v);
    }

    //Getters and Setters
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public TreeComponent getLeft() {
        return left;
    }

    public void setLeft(TreeComponent left) {
        this.left = left;
    }

    public TreeComponent getRight() {
        return right;
    }

    public void setRight(TreeComponent right) {
        this.right = right;
    }
}
