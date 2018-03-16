package model;

import java.util.ArrayList;

public class FullVisitor implements Visitor {
    ArrayList<String> ops = new ArrayList<>();
    String full = "";
    boolean first = true;
    int count = 0;

    @Override
    public void visitPreNode(Node node) {
        ops.add(node.getLabel());
        count++;
    }

    @Override
    public void visitLeaf(Leaf leaf) {
        if (first) {
            full = leaf.getLabel();
            first = false;
        }
        else
            full += ops.get(count-1) + leaf.getLabel();
    }

    @Override
    public void visitPostNode(Node node) {
        count--;
    }

    public String getFull() {
        return full;
    }
}
