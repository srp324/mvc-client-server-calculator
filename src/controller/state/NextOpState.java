package controller.state;

import controller.Controller;

public class NextOpState implements State {
    @Override
    public void handle(Controller context) {
        if (isDigit(context.getCommand())) {
            context.getModel().equation = context.getCommand().getValue();
            context.setState(new SecondOpState());
        }
        else
            context.setState(new ErrorState());
    }
}
