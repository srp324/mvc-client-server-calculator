package controller;

import java.io.Serializable;

public enum Command implements Serializable {

    DIGIT(""),
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

    OP(""),
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
    
    public Command getDigit(Integer digit) {
        switch (digit) {
            case 1:
                return Command.ONE;
            case 2:
                return Command.TWO;
            case 3:
                return Command.THREE;
            case 4:
                return Command.FOUR;
            case 5:
                return Command.FIVE;
            case 6:
                return Command.SIX;
            case 7:
                return Command.SEVEN;
            case 8:
                return Command.EIGHT;
            case 9:
                return Command.NINE;
            case 0:
                return Command.ZERO;
        }
        return Command.DIGIT;
    }

    public Command getOp(String op) {
        switch (op) {
            case "+":
                return Command.ADD;
            case "-":
                return Command.SUB;
            case "*":
                return Command.MULT;
            case "/":
                return Command.DIV;
            case "=":
                return Command.EQ;
            case "C":
                return Command.CLEAR;
        }
        return Command.OP;
    }
}