package compiler.entities;

public class BooleanExpression extends Expression {

    protected BooleanExpression(Type type, Object value, boolean isFormal) {
        super(type, value, isFormal);
    }

    public Expression applyOR(Expression rightOperand) throws Exception {
        if (rightOperand.type != Type.BOOLEAN) {
            throw new Exception("Right operand of OR operation is type " + rightOperand.getType() + ", should be BOOLEAN.");
        }
        
        if (isFormal || rightOperand.isFormal)
            return Expression.createParameter(Type.BOOLEAN);
        
        Boolean result = ((Boolean) value) || ((Boolean) rightOperand.value);
        return Expression.createExpression(Type.BOOLEAN, result);
    }

    public Expression applyAND(Expression rightOperand) throws Exception {
        if (rightOperand.type != Type.BOOLEAN) {
            throw new Exception("Right operand of AND operation is type " + rightOperand.getType() + ", should be BOOLEAN.");
        }
        
        if (isFormal || rightOperand.isFormal)
            return Expression.createParameter(Type.BOOLEAN);
        
        Boolean result = ((Boolean) value) && ((Boolean) rightOperand.value);
        return Expression.createExpression(Type.BOOLEAN, result);
    }

    public Expression applyQUES(Expression trueOperand, Expression falseOperand) throws Exception {
        if (trueOperand.type != falseOperand.type) {
            throw new Exception("Both right operands of ternary equation should have same type");
        }
        
        if (trueOperand.isFormal || falseOperand.isFormal)
            return Expression.createParameter(trueOperand.type);
        
        return Expression.createExpression(trueOperand.type, (Boolean) value ? trueOperand.value : falseOperand.value);
    }

    public Expression applyEXCL() throws Exception {
        return isFormal ? Expression.createParameter(type) : Expression.createExpression(type, !((Boolean) value));
    }
}
