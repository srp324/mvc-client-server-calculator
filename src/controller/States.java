package controller;

import java.io.Serializable;

public enum States implements Serializable {
    START,
    FIRSTOP,
    NEXTOP,
    SECONDOP,
    CALCULATE,
    ERROR;
}