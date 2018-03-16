package model;

public interface Visitor {
    void visitPreNode(Node node);
    void visitLeaf(Leaf leaf);
    void visitPostNode(Node node);
}
