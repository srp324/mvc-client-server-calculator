package controller.state;

import controller.Controller;

public interface State {
    void handle(Controller context);
}
