package evaluation;

import ast.Ast;
import ast.expressions.AstExpression;
import interfaces.IEnvironment;

import java.util.List;

public class Operation {

    private String operationName;


    public Operation(String operationName) {
        this.operationName = operationName;
    }

    public String getOperationName() {
        return operationName;
    }

    public Object apply(List<AstExpression> l, Interpreter i, IEnvironment e) throws Exception {
        if (this.operationName.equals("not")) {
            Number o1 = (Number) l.get(0).accept(i, e);
            if (o1.getVal() == 0) return new Number(1);
            return new Number(0);

        } else {
            Number o1 = (Number) l.get(0).accept(i, e);
            Number o2 = (Number) l.get(1).accept(i, e);
            switch (this.operationName) {
                case "add":
                    return new Number(o1.getVal() + o2.getVal());
                case "sub":
                    return new Number(o1.getVal() - o2.getVal());
                case "mul":
                case "and":
                    return new Number(o1.getVal() * o2.getVal());
                case "div":
                    if (o2.getVal() == 0) throw new Exception("division by 0");
                    return new Number(o1.getVal() / o2.getVal());
                case "lt":
                    int res = o1.getVal() - o2.getVal();
                    if (res > 0) return new Number(0);
                    return new Number(1);
                case "eq":
                    if ((o1.getVal() - o2.getVal()) == 0) return new Number(1);
                    return new Number(0);
                default:
                    break;
            }
        }
        return null;
    }
}
