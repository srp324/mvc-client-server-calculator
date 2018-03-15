package controller;

import java.io.Serializable;

public enum Command implements Serializable {
    ONE("1"),
    TWO ("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    ZERO("0"),
    DIGIT(""),

    ADD("+"),
    SUB("-"),
    MULT("*"),
    DIV("/"),

    EQ("="),
    CLEAR("C");

    private final String value;

    Command(String _value) {
        value = _value;
    }

    public String getValue() {
        return value;
    }
}