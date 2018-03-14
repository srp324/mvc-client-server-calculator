package controller;

import java.io.Serializable;

public enum State implements Serializable {
    START,
    FIRSTOP,
    NEXTOP,
    SECONDOP,
    CALCULATE,
    ERROR;
}