package model;

import java.util.ArrayList;

public class CalcVisitor implements Visitor {
    ArrayList<String> ops = new ArrayList<>();
    Integer value;
    int side = 0;
    int count = 0;

    @Override
    public void visitPreNode(Node node) {
        ops.add(node.label);
        count++;
    }

    @Override
    public void visitLeaf(Leaf leaf) {
        if (side == 0) {
            value = Integer.parseInt(leaf.label);
            side = 1;
        }
        else if (side == 1) {
            switch (ops.get(count-1)) {
                case "+":
                    value += Integer.parseInt(leaf.label);
                    break;
                case "-":
                    value -= Integer.parseInt(leaf.label);
                    break;
                case "*":
                    value *= Integer.parseInt(leaf.label);
                    break;
                case "/":
                    value /= Integer.parseInt(leaf.label);
                    break;
            }
        }
    }

    @Override
    public void visitPostNode(Node node) {
        count--;
    }

    public Integer getValue() {
        return value;
    }
    public void setValue(Integer _value) {
        value = _value;
    }
}
