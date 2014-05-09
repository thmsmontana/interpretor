package compiler.entities;

public class Expression {
	protected Type type;
	protected Object value;
	protected boolean isFormal;

	protected Expression(Type type, Object value) {
		this(type, value, false);
	}

	protected Expression(Type type, Object value, boolean isFormal) {
		this.type = type;
		this.value = value;
		this.isFormal = isFormal;
	}

	public static Expression createParameter(Type type) {
		return createExpression(type, null, true);
	}

	public static Expression createExpression(Type type, Object value, boolean isFormal) {
		switch (type) {
			case BOOLEAN:
				return new BooleanExpression(type, value, isFormal);
			case INTEGER:
				return new IntegerExpression(type, value, isFormal);
			case FLOAT:
				return new FloatExpression(type, value, isFormal);
			case STRING:
				return new StringExpression(type, value, isFormal);
			default:
				return new Expression(type, null, isFormal);
		}
	}

	public static Expression createExpression(Type type, Object value) {
		createExpression(type, value, false);
	}


	public Object getValue() {
		return value;
	}
	
	public Type getType() {
		return type;
	}



	/* Defining operations */
	public Expression applyEQUAL(Expression rightOperand) throws Exception {
		if (this.getType() != rightOperand.getType()) {
			throw new Exception("Could not cast " + rightOperand.getType() + " into " this.getType() + ".");
		}
		
		if (!this.isFormal && !rightOperand.isFormal) {
			this.value = rightOperand.getValue();
		}
		return new Expression(type, value, isFormal);
	}

	public Expression applyOR(Expression rightOperand) throws Exception {
		throw new Exception("Operation OR is not permitted for type " + this.getType() + ".");
	}

	public Expression applyAND(Expression rightOperand) throws Exception {
		throw new Exception("Operation AND is not permitted for type " + this.getType() + ".");
	}

	public Expression applyEQ(Expression rightOperand) throws Exception {
		throw new Exception("Operation EQ is not permitted for type " + this.getType() + ".");
	}

	public Expression applyNE(Expression rightOperand) throws Exception {
		throw new Exception("Operation NE is not permitted for type " + this.getType() + ".");
	}

	public Expression applyLT(Expression rightOperand) throws Exception {
		throw new Exception("Operation LT is not permitted for type " + this.getType() + ".");
	}

	public Expression applyLE(Expression rightOperand) throws Exception {
		throw new Exception("Operation LE is not permitted for type " + this.getType() + ".");
	}

	public Expression applyGT(Expression rightOperand) throws Exception {
		throw new Exception("Operation GT is not permitted for type " + this.getType() + ".");
	}

	public Expression applyGE(Expression rightOperand) throws Exception {
		throw new Exception("Operation GE is not permitted for type " + this.getType() + ".");
	}

	public Expression applyPLUS(Expression rightOperand) throws Exception {
		throw new Exception("Operation PLUS is not permitted for type " + this.getType() + ".");
	}

	public Expression applyMINUS(Expression rightOperand) throws Exception {
		throw new Exception("Operation MINUS is not permitted for type " + this.getType() + ".");
	}

	public Expression applyTIMES(Expression rightOperand) throws Exception {
		throw new Exception("Operation TIMES is not permitted for type " + this.getType() + ".");
	}

	public Expression applyDIV(Expression rightOperand) throws Exception {
		throw new Exception("Operation DIV is not permitted for type " + this.getType() + ".");
	}

	public Expression applyMOD(Expression rightOperand) throws Exception {
		throw new Exception("Operation MOD is not permitted for type " + this.getType() + ".");
	}

	public Expression applyQUES(Expression trueOperand, Expression falseOperand) throws Exception {
		throw new Exception("The condition for a ternary expression should be a boolean.");
	}

	public Expression applyEXCL() throws Exception {
		throw new Exception("Operation EXCL is not permitted for type " + this.getType() + ".");
	}

	public Expression applyMINUS() throws Exception {
		throw new Exception("Unary '-' operator can only operate on int and float.");
	}
}}