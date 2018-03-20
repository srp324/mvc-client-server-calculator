package controller.state;

import client.Client;
import controller.Controller;
import model.CalcVisitor;
import model.FullVisitor;

public class SecondOpState implements State {
    @Override
    public void handle(Controller context) {
        if (isDigit(context.getCommand())) {
            context.getModel().setEquation(context.getModel().getEquation() + context.getCommand().getValue());
            context.getModel().addRightLeaf(context.getModel().getEquation());
        }
        else if (isOp(context.getCommand())) {
            context.getModel().addNode(context.getCommand().getValue());

            context.getModel().setPrevOp(context.getModel().getCurrOp());
            context.getModel().setCurrOp(context.getCommand().getValue());

            context.getModel().setRhs(Integer.parseInt(context.getModel().getEquation()));
            switch (context.getModel().getPrevOp()) {
                case "+":
                    context.getModel().setEquation(Integer.toString(context.getModel().getLhs() + context.getModel().getRhs()));
                    break;
                case "-":
                    context.getModel().setEquation(Integer.toString(context.getModel().getLhs() - context.getModel().getRhs()));
                    break;
                case "*":
                    context.getModel().setEquation(Integer.toString(context.getModel().getLhs() * context.getModel().getRhs()));
                    break;
                case "/":
                    if (context.getModel().getRhs() == 0) {
                        context.getModel().setOnError("S");
                        context.getModel().setEquation("error");
                        context.setState(new ErrorState());
                        return;
                    }
                    else
                        context.getModel().setEquation(Integer.toString(context.getModel().getLhs() / context.getModel().getLhs()));
                    break;
            }

            CalcVisitor cv = new CalcVisitor();
            context.getModel().getTree().accept(cv);
            context.getModel().setLhs(cv.getValue());
            cv.setValue(0);

            FullVisitor fv = new FullVisitor();
            context.getModel().getTree().accept(fv);
            context.setState(new NextOpState());
        }
        else if (isEquals(context.getCommand())) {
            if (context.getModel().getCurrOp().equals("/") && context.getModel().getEquation().equals("0")) {
                context.getModel().setOnError("S");
                context.getModel().setEquation("error");
                context.setState(new ErrorState());
                return;
            }
                CalcVisitor cv = new CalcVisitor();
                context.getModel().getTree().accept(cv);
                context.getModel().setLhs( cv.getValue());
                cv.setValue(0);

                FullVisitor fv = new FullVisitor();
                context.getModel().getTree().accept(fv);
                Client.sendMsg(fv.getFull() + " = " + context.getModel().getLhs());
                context.getModel().setEquation(Integer.toString(context.getModel().getLhs()));
                context.setState(new CalcState());
        }
        else if (isClear(context.getCommand())) {
            context.getModel().setLhs(null);
            context.getModel().setRhs(null);
            context.getModel().setEquation("");
            context.getModel().clearNodes();
            context.setState(new StartState());
        }
    }
}
