package controller.state;

import controller.Command;
import controller.Controller;

public class SecondOpState implements State {
    @Override
    public void handle(Controller context) {
        if (isDigit(context.getCommand())) {
            context.getModel().equation += context.getCommand().getValue();
            context.getModel().full += context.getCommand().getValue();
        }
        else if (isOp(context.getCommand())) {
            context.getModel().rhs = Integer.parseInt(context.getModel().equation);
            switch (context.getCommand().getValue()) {
                case "+":
                    context.getModel().equation = Integer.toString(context.getModel().lhs + context.getModel().rhs);
                    break;
                case "-":
                    context.getModel().equation = Integer.toString(context.getModel().lhs - context.getModel().rhs);
                    break;
                case "*":
                    context.getModel().equation = Integer.toString(context.getModel().lhs * context.getModel().rhs);
                    break;
                case "/": //TODO: Check if rhs == 0
                    context.getModel().equation = Integer.toString(context.getModel().lhs / context.getModel().rhs);
                    break;
            }
            context.getModel().lhs = Integer.parseInt(context.getModel().equation);

            context.setState(new NextOpState());
        }
        else if (isEquals(context.getCommand())) {
            //TODO: Calculate
            context.setState(new CalcState());
        }
        else if (isClear(context.getCommand())) {
            context.getModel().lhs = null;
            context.getModel().rhs = null;
            context.getModel().equation = "";
            context.getModel().full = "";
            context.setState(new StartState());
        }
    }
}
