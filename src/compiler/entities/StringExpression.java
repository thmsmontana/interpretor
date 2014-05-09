package compiler.entities;

public class StringExpression extends Expression {
    protected StringExpression(Type type, Object value, boolean isFormal) {
        super(type, value, isFormal);
    }
    
    /* Defining operations */

	public Expression applyPLUS(Expression rightOperand) throws Exception {
		if(rightOperand.getType()!=Type.STRING)
                    throw new Exception("Right operand type is "+rightOperand.getType()+ " must be String.");
                
                if(this.isFormal || rightOperand.isFormal)
                    return Expression.createParameter(type);
                String result = (String) this.value+(String)rightOperand.value;
                
                return Expression.createExpression(Type.STRING, result);
	}
}
