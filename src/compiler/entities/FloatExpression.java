package compiler.entities;

public class IntegerExpression extends Expression {
	protected IntegerExpression(Type type, Object value, boolean isFormal) {
		super(type, value, isFormal);
	}

	/* Defining operations */
	public Expression applyEQUAL(Expression rightOperand) throws Exception {
		if (rightOperand.getType() == Type.INTEGER) {
			if (!this.isFormal && !rightOperand.isFormal) {
				Integer f = (Integer) rightOperand.getValue();
				this.value = f.floatValue();
				return Expression.createExpression(Type.FLOAT, value);
			}
			return Expression.createParameter(Type.FLOAT);
		}
		
		return super.applyEQUAL(rightOperand);
	}

	public Expression applyEQ(Expression rightOperand) throws Exception {
		
		if(rightOperand.getType() == Type.INTEGER)
		{
			if (!this.isFormal && !rightOperand.isFormal) {
				Integer f = (Integer) rightOperand.getValue();
				return Expression.createExpression(Type.BOOLEAN, (float)this.value==f);
			}
		}

		return super.applyEQ(rightOperand);

	}

	public Expression applyNE(Expression rightOperand) throws Exception {
		
		if(rightOperand.getType() == Type.INTEGER)
		{
			if (!this.isFormal && !rightOperand.isFormal) {
				Integer f = (Integer) rightOperand.getValue();
				return Expression.createExpression(Type.BOOLEAN, (float)this.value!=f);
			}
		} 

		return super.applyNE(rightOperand);
	}

	public Expression applyLT(Expression rightOperand) throws Exception {

		if(rightOperand.getType() == Type.INTEGER)
		{
			if (!this.isFormal && !rightOperand.isFormal) {
				Integer f = (Integer) rightOperand.getValue();
				return Expression.createExpression(Type.BOOLEAN, (float)this.value<f);
			}
		} 

		if(rightOperand.getType() == Type.FLOAT)
		{
			if (!this.isFormal && !rightOperand.isFormal) {
				Float f = (Float) rightOperand.getValue();
				return Expression.createExpression(Type.BOOLEAN, (float)this.value<f);
			}
		} 

		throw new Exception("Right operand type is "+rightOperand.getType()+ " must be int or float.");


	}

	public Expression applyLE(Expression rightOperand) throws Exception {
		if(rightOperand.getType() == Type.INTEGER)
		{
			if (!this.isFormal && !rightOperand.isFormal) {
				Integer f = (Integer) rightOperand.getValue();
				return Expression.createExpression(Type.BOOLEAN, (float)this.value<=f);
			}
		} 

		if(rightOperand.getType() == Type.FLOAT)
		{
			if (!this.isFormal && !rightOperand.isFormal) {
				Float f = (Float) rightOperand.getValue();
				return Expression.createExpression(Type.BOOLEAN, (float)this.value<=f);
			}
		} 

		throw new Exception("Right operand type is "+rightOperand.getType()+ " must be int or float.");
	}

	public Expression applyGT(Expression rightOperand) throws Exception {
		if(rightOperand.getType() == Type.INTEGER)
		{
			if (!this.isFormal && !rightOperand.isFormal) {
				Integer f = (Integer) rightOperand.getValue();
				return Expression.createExpression(Type.BOOLEAN, (float)this.value>f);
			}
		} 

		if(rightOperand.getType() == Type.FLOAT)
		{
			if (!this.isFormal && !rightOperand.isFormal) {
				Float f = (Float) rightOperand.getValue();
				return Expression.createExpression(Type.BOOLEAN, (float)this.value>f);
			}
		} 

		throw new Exception("Right operand type is "+rightOperand.getType()+ " must be int or float.");
	}

	public Expression applyGE(Expression rightOperand) throws Exception {
		if(rightOperand.getType() == Type.INTEGER)
		{
			if (!this.isFormal && !rightOperand.isFormal) {
				Integer f = (Integer) rightOperand.getValue();
				return Expression.createExpression(Type.BOOLEAN, (float)this.value>=f);
			}
		} 

		if(rightOperand.getType() == Type.FLOAT)
		{
			if (!this.isFormal && !rightOperand.isFormal) {
				Float f = (Float) rightOperand.getValue();
				return Expression.createExpression(Type.BOOLEAN, (float)this.value>=f);
			}
		} 

		throw new Exception("Right operand type is "+rightOperand.getType()+ " must be int or float.");
	}

	public Expression applyPLUS(Expression rightOperand) throws Exception {
		if(rightOperand.getType() == Type.INTEGER)
		{
			if (!this.isFormal && !rightOperand.isFormal) {
				Integer f = (Integer) rightOperand.getValue();
				return Expression.createExpression(Type.FLOAT, (float)this.value+f);
			}
		} 

		if(rightOperand.getType() == Type.FLOAT)
		{
			if (!this.isFormal && !rightOperand.isFormal) {
				Float f = (Float) rightOperand.getValue();
				return Expression.createExpression(Type.FLOAT, (float)this.value+f);
			}
		} 

		throw new Exception("Right operand type is "+rightOperand.getType()+ " must be int or float.");
	}

	public Expression applyMINUS(Expression rightOperand) throws Exception {
		if(rightOperand.getType() == Type.INTEGER)
		{
			if (!this.isFormal && !rightOperand.isFormal) {
				Integer f = (Integer) rightOperand.getValue();
				return Expression.createExpression(Type.FLOAT, (float)this.value-f);
			}
		} 

		if(rightOperand.getType() == Type.FLOAT)
		{
			if (!this.isFormal && !rightOperand.isFormal) {
				Float f = (Float) rightOperand.getValue();
				return Expression.createExpression(Type.FLOAT, (float)this.value-f);
			}
		}

		throw new Exception("Right operand type is "+rightOperand.getType()+ " must be int or float.");
	}

	public Expression applyTIMES(Expression rightOperand) throws Exception {
		if(rightOperand.getType() == Type.INTEGER)
		{
			if (!this.isFormal && !rightOperand.isFormal) {
				Integer f = (Integer) rightOperand.getValue();
				return Expression.createExpression(Type.FLOAT, (float)this.value*f);
			}
		} 

		if(rightOperand.getType() == Type.FLOAT)
		{
			if (!this.isFormal && !rightOperand.isFormal) {
				Float f = (Float) rightOperand.getValue();
				return Expression.createExpression(Type.FLOAT, (float)this.value*f);
			}
		} 

		throw new Exception("Right operand type is "+rightOperand.getType()+ " must be int or float.");
	}

	public Expression applyDIV(Expression rightOperand) throws Exception {
		if(rightOperand.getType() == Type.INTEGER)
		{
			if (!this.isFormal && !rightOperand.isFormal) {
				Integer f = (Integer) rightOperand.getValue();
				return Expression.createExpression(Type.FLOAT, (float)this.value/f);
			}
		} 

		if(rightOperand.getType() == Type.FLOAT)
		{
			if (!this.isFormal && !rightOperand.isFormal) {
				Float f = (Float) rightOperand.getValue();
				return Expression.createExpression(Type.FLOAT, (float)this.value/f);
			}
		} 

		throw new Exception("Right operand type is "+rightOperand.getType()+ " must be int or float.");
	}

	public Expression applyMOD(Expression rightOperand) throws Exception {
		if(rightOperand.getType() == Type.INTEGER)
		{
			if (!this.isFormal && !rightOperand.isFormal) {
				Integer f = (Integer) rightOperand.getValue();
				return Expression.createExpression(Type.FLOAT, (float)this.value%f);
			}
		} 

		if(rightOperand.getType() == Type.FLOAT)
		{
			if (!this.isFormal && !rightOperand.isFormal) {
				Float f = (Float) rightOperand.getValue();
				return Expression.createExpression(Type.FLOAT, (float)this.value%f);
			}
		} 

		throw new Exception("Right operand type is "+rightOperand.getType()+ " must be int or float.");
	}

}
