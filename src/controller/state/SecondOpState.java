package controller.state;

import client.Client;
import controller.Controller;
import model.CalcVisitor;
import model.FullVisitor;

public class SecondOpState implements State {
    @Override
    public void handle(Controller context) {
        if (isDigit(context.getCommand())) {
            context.getModel().equation += context.getCommand().getValue();
            context.getModel().full += context.getCommand().getValue();

            context.getModel().addRightLeaf(context.getModel().equation);
        }
        else if (isOp(context.getCommand())) {
            context.getModel().addNode(context.getCommand().getValue());

            context.getModel().prevOp = context.getModel().currOp;
            context.getModel().currOp = context.getCommand().getValue();

            context.getModel().rhs = Integer.parseInt(context.getModel().equation);
            switch (context.getModel().prevOp) {
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

            context.setState(new NextOpState());
        }
        else if (isEquals(context.getCommand())) {
            CalcVisitor cv = new CalcVisitor();
            context.getModel().getTree().accept(cv);
            context.getModel().lhs = cv.getValue();
            cv.setValue(0);

            FullVisitor fv = new FullVisitor();
            context.getModel().getTree().accept(fv);
            Client.sendMsg(fv.getFull() + " = " + context.getModel().lhs);
            context.getModel().equation = Integer.toString(context.getModel().lhs);
            context.setState(new CalcState());
        }
        else if (isClear(context.getCommand())) {
            context.getModel().lhs = null;
            context.getModel().rhs = null;
            context.getModel().equation = "";
            context.getModel().full = "";
            context.getModel().clearNodes();
            context.setState(new StartState());
        }
    }
}
