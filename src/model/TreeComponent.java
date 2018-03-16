package model;

public interface TreeComponent {
    void accept(Visitor v);
}
